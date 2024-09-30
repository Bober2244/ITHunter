package dev.bober.presentation.favorite

import androidx.lifecycle.ViewModel
import dev.bober.domain.usecase.GetVacanciesUseCase

class FavoriteViewModel(
    private val getVacanciesUseCase: GetVacanciesUseCase
) : ViewModel() {

}