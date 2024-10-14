package dev.bober.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.bober.domain.model.VacancyModel
import dev.bober.domain.usecase.AddFavoriteUseCase
import dev.bober.domain.usecase.GetVacanciesUseCase
import dev.bober.domain.usecase.RemoveFavoriteUseCase
import dev.bober.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val getVacanciesUseCase: GetVacanciesUseCase,
    private val addFavoriteUseCase: AddFavoriteUseCase,
    private val removeFavoriteUseCase: RemoveFavoriteUseCase,
) : ViewModel() {
    private val _vacancyState = MutableStateFlow<Resource<List<VacancyModel>>>(Resource.Loading())
    val vacancyState = _vacancyState.asStateFlow()

    fun loadVacancies() {
        viewModelScope.launch {
            getVacanciesUseCase()
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
}