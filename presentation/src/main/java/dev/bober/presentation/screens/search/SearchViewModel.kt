package dev.bober.presentation.screens.search

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.bober.domain.model.ResultModel
import dev.bober.domain.model.VacancyModel
import dev.bober.domain.usecase.AddFavoriteUseCase
import dev.bober.domain.usecase.GetDataUseCase
import dev.bober.domain.usecase.GetFavoritesCountUseCase
import dev.bober.domain.usecase.RemoveFavoriteUseCase
import dev.bober.domain.usecase.SaveDataUseCase
import dev.bober.utils.Resource
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel(
    private val getDataUseCase: GetDataUseCase,
    private val saveDataUseCase: SaveDataUseCase,
    private val addFavoriteUseCase: AddFavoriteUseCase,
    private val removeFavoriteUseCase: RemoveFavoriteUseCase,
    private val getFavoritesCountUseCase: GetFavoritesCountUseCase,
) : ViewModel() {

    private val _dataState = MutableStateFlow<Resource<ResultModel>>(Resource.Loading())
    val dataState = _dataState.asStateFlow()

    init {
        viewModelScope.launch {
            getDataUseCase()
                .collect { res ->
                    _dataState.value = res
                    res.data?.let { saveDataUseCase(it.offers, it.vacancies) }
                }
        }
    }

    fun openLink(link: String) = Intent(Intent.ACTION_VIEW, Uri.parse(link))

    fun addFavorite(vacancy: VacancyModel) {
        viewModelScope.launch {
            addFavoriteUseCase(vacancy)
        }
    }

    fun removeFavorite(id: String) {
        viewModelScope.launch {
            removeFavoriteUseCase(id)
        }
    }

    suspend fun getFavoritesCount(): Int {
        var count = 0
        viewModelScope.async {
            getFavoritesCountUseCase()
                .collect { res ->
                    count = res
                }
        }.await()
        return count
    }
}