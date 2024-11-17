package dev.bober.presentation.screens.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.bober.domain.model.VacancyModel
import dev.bober.domain.usecase.AddFavoriteUseCase
import dev.bober.domain.usecase.GetFavoritesCountUseCase
import dev.bober.domain.usecase.GetFavoritesVacancies
import dev.bober.domain.usecase.GetVacanciesUseCase
import dev.bober.domain.usecase.RemoveFavoriteUseCase
import dev.bober.utils.Resource
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val getFavoritesVacancies: GetFavoritesVacancies,
    private val addFavoriteUseCase: AddFavoriteUseCase,
    private val removeFavoriteUseCase: RemoveFavoriteUseCase,
    private val getFavoritesCountUseCase: GetFavoritesCountUseCase
) : ViewModel() {
    private val _vacancyState = MutableStateFlow<Resource<List<VacancyModel>>>(Resource.Loading())
    val vacancyState = _vacancyState.asStateFlow()

    init {
        viewModelScope.launch {
            getFavoritesVacancies()
                .collect { res ->
                    _vacancyState.value = res
                }
        }
    }

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
        return getFavoritesCountUseCase().last().data ?: 0
    }
}