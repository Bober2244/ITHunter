package dev.bober.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.bober.domain.model.OfferModel
import dev.bober.domain.model.ResultModel
import dev.bober.domain.model.VacancyModel
import dev.bober.domain.usecase.GetDataUseCase
import dev.bober.domain.usecase.GetOffersUseCase
import dev.bober.domain.usecase.GetVacanciesUseCase
import dev.bober.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel(
    private val getDataUseCase: GetDataUseCase
) : ViewModel() {

    private val _dataState = MutableStateFlow<Resource<ResultModel>>(Resource.Loading())
    val dataState: StateFlow<Resource<ResultModel>> get() = _dataState.asStateFlow()

    fun loadData() {
        viewModelScope.launch {
            getDataUseCase()
                .collect { res ->
                    _dataState.value = res
                }
        }
    }
}