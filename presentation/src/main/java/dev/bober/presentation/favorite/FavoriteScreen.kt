package dev.bober.presentation.favorite

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
import dev.bober.presentation.databinding.FavoriteScreenBinding
import dev.bober.presentation.favorite.recycler.FavoritesAdapter
import dev.bober.presentation.utils.toFavoritesList
import dev.bober.utils.Resource
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteScreen : Fragment() {

    private var _binding: FavoriteScreenBinding? = null
    private val binding get() = requireNotNull(_binding!!) { "Binding wasn't initialized" }

    private val viewModel: FavoriteViewModel by viewModel()
    val adapter by lazy { FavoritesAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FavoriteScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(
                state = Lifecycle.State.STARTED
            ) {
                viewModel.vacancyState.collect { res ->
                    when (res) {
                        is Resource.Loading -> binding.favoritesProgress.visibility = VISIBLE
                        is Resource.Error -> Toast.makeText(
                            context,
                            res.error.toString(),
                            LENGTH_SHORT
                        ).show()

                        is Resource.Success -> {
                            val currData = res.data.toFavoritesList()
                            binding.favoritesProgress.visibility = GONE
                            binding.vacNumber.text = checkNumbers(currData.size)

                            adapter.submitList(currData)
                        }
                    }
                }
            }
        }
        binding.favorites.adapter = adapter

        viewModel.loadVacancies()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.favorites.adapter = null
        _binding = null
    }

    private fun checkNumbers(number: Int): String {
        return if (number % 10 == 1) "$number вакансия"
        else if (number % 10 in 2..4) "$number вакансии"
        else "$number вакансий"
    }
}