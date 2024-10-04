package dev.bober.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.bober.domain.model.OfferModel
import dev.bober.domain.model.VacancyModel
import dev.bober.domain.usecase.GetOffersUseCase
import dev.bober.domain.usecase.GetVacanciesUseCase
import dev.bober.presentation.model.Vacancy
import dev.bober.utils.Resource
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchViewModel(
    private val getOffersUseCase: GetOffersUseCase,
    private val getVacanciesUseCase: GetVacanciesUseCase,
) : ViewModel() {

    private val _offersState = MutableStateFlow<Resource<List<OfferModel>>>(Resource.Loading())
    val offerState: StateFlow<Resource<List<OfferModel>>> get() = _offersState.asStateFlow()

    private val _vacancyState = MutableStateFlow<Resource<List<VacancyModel>>>(Resource.Loading())
    val vacancyState: StateFlow<Resource<List<VacancyModel>>> get() = _vacancyState.asStateFlow()

    fun loadOffers() {
        viewModelScope.launch {
            getOffersUseCase()
                .collect { res ->
                    _offersState.value = res
                }
        }
    }

    fun loadVacancies() {
        viewModelScope.launch {
            getVacanciesUseCase()
                .collect { res ->
                    _vacancyState.value = res
                }
        }
    }
}