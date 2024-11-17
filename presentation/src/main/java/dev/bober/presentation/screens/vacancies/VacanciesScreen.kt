package dev.bober.presentation.screens.vacancies

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.bober.presentation.databinding.VacanciesScreenBinding
import dev.bober.presentation.entity.VacanciesList
import dev.bober.presentation.screens.vacancies.recycler.VacanciesAdapter
import dev.bober.presentation.utils.checkNumbers

class VacanciesScreen : Fragment() {

    private var _binding : VacanciesScreenBinding? = null
    private val binding get() = requireNotNull(_binding!!) {"Binding wasn't initialized"}

    private val adapter by lazy { VacanciesAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = VacanciesScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NewApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.arrowBack.setOnClickListener {
            findNavController().navigateUp()
        }
        val args = arguments?.getSerializable("vacancies", VacanciesList::class.java)
        binding.allVacancies.adapter = adapter
        adapter.submitList(args?.vacancies)
        binding.allVacanciesSize.text = checkNumbers(args?.vacancies?.size ?: 0)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.allVacancies.adapter = null
        _binding = null
    }
}