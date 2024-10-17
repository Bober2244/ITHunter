package dev.bober.presentation.screens.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dev.bober.presentation.adapter.DelegationAdapter
import dev.bober.presentation.adapter.DelegateItem
import dev.bober.presentation.databinding.SearchScreenBinding
import dev.bober.presentation.screens.search.recycler.MoreButtonDelegate
import dev.bober.presentation.screens.search.recycler.RecommendationsListDelegate
import dev.bober.presentation.screens.search.recycler.VacanciesDelegate
import dev.bober.presentation.utils.concatenate
import dev.bober.utils.Resource
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchScreen : Fragment() {

    private var _binding : SearchScreenBinding? = null
    private val binding get() = requireNotNull(_binding!!) {"Binding wasn't initialized"}

    private val viewModel : SearchViewModel by viewModel()
    private val adapter by lazy { DelegationAdapter() }

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

        val data = mutableListOf<DelegateItem>()

        adapter.apply {
            addDelegate(
                RecommendationsListDelegate(
                    onClick = {
                        startActivity(viewModel.openLink(link = it))
                    }
                )
            )
            addDelegate(VacanciesDelegate())
            addDelegate(MoreButtonDelegate())
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(
                state = Lifecycle.State.CREATED
            ) {
                viewModel.dataState.collect { res ->
                    when(res) {
                        is Resource.Loading -> binding.progressBar.visibility = VISIBLE
                        is Resource.Error -> Toast.makeText(
                            context,
                            res.error.toString(),
                            LENGTH_SHORT
                        ).show()
                        is Resource.Success -> {
                            val currData = res.data
                            binding.progressBar.visibility = GONE
                            data.concatenate(currData)
                            adapter.submitList(data)
                        }
                    }
                }
            }
        }

        binding.vacancies.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.vacancies.adapter = null
        _binding = null
    }
}