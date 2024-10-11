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
import dev.bober.presentation.adapter.DelegateItem
import dev.bober.presentation.adapter.MainAdapter
import dev.bober.presentation.adapter.utils.concatenate
import dev.bober.presentation.adapter.utils.concatenateWithOffers
import dev.bober.presentation.adapter.utils.concatenateWithVacancies
import dev.bober.presentation.databinding.SearchScreenBinding
import dev.bober.presentation.search.recyclers.RecommendationsListDelegate
import dev.bober.presentation.search.recyclers.VacanciesDelegate
import dev.bober.utils.Resource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchScreen : Fragment() {

    private var _binding : SearchScreenBinding? = null
    private val binding get() = requireNotNull(_binding!!) {"Binding wasn't initialized"}

    private val viewModel : SearchViewModel by viewModel()
    private val adapter : MainAdapter by lazy { MainAdapter() }

    private var data = mutableListOf<DelegateItem>()

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
            addDelegate(RecommendationsListDelegate())
            addDelegate(VacanciesDelegate())
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(
                state = Lifecycle.State.STARTED
            ) {
                viewModel.dataState.collect { res ->
                    when(res) {
                        is Resource.Loading -> Log.d("Presentation", "Loading data")
                        is Resource.Error -> Toast.makeText(
                            context,
                            res.error.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                        is Resource.Success -> {
                            val currData = res.data
                            data.concatenate(currData)
                            adapter.submitList(data)
                        }
                    }
                }
            }
        }

        viewModel.loadData()

        binding.vacancies.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.vacancies.adapter = null
        _binding = null
    }
}