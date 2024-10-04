package dev.bober.presentation.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dev.bober.presentation.adapter.MainAdapter
import dev.bober.presentation.adapter.utils.concatenateWithOffers
import dev.bober.presentation.databinding.SearchScreenBinding
import dev.bober.presentation.search.recyclers.RecommendationsDelegate
import dev.bober.presentation.search.recyclers.VacanciesDelegate
import dev.bober.utils.Resource
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import dev.bober.presentation.adapter.utils.concatenateWithVacancy
import dev.bober.presentation.model.Vacancy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import org.koin.core.parameter.parametersOf

class SearchScreen : Fragment() {

    private var _binding : SearchScreenBinding? = null
    private val binding get() = requireNotNull(_binding!!) {"Binding wasn't initialized"}

    private val viewModel : SearchViewModel by viewModel()
    private val adapter : MainAdapter by lazy { MainAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SearchScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.apply {
            addDelegate(RecommendationsDelegate())
            addDelegate(VacanciesDelegate())
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(
                state = Lifecycle.State.STARTED
            ) {
                viewModel.offerState.collect { res ->
                    when (res) {
                        is Resource.Loading -> Log.i("Offers", "Loading offers")
                        is Resource.Error -> Toast.makeText(
                            context,
                            res.error.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                        is Resource.Success -> {
                            val offers = res.data
                            adapter.submitList(offers.concatenateWithVacancy(listOf()))
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(
                state = Lifecycle.State.STARTED
            ) {
                viewModel.vacancyState.collect { result ->
                    when (result) {
                        is Resource.Loading -> Log.i("Vacancies", "Loading vacancies")
                        is Resource.Error -> Toast.makeText(
                            context,
                            result.error.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                        is Resource.Success -> {
                            val vacancies = result.data
                            adapter.submitList(vacancies.concatenateWithOffers(listOf()))
                        }
                    }
                }
            }
        }
        viewModel.loadOffers()
        viewModel.loadVacancies()

        binding.vacancies.adapter = adapter
        binding.recommendationsList.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.vacancies.adapter = null
        binding.recommendationsList.adapter = null
        _binding = null
    }
}