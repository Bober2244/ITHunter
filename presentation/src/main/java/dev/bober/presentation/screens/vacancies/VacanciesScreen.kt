package dev.bober.presentation.screens.vacancies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.bober.presentation.databinding.VacanciesScreenBinding

class VacanciesScreen : Fragment() {

    private var _binding : VacanciesScreenBinding? = null
    private val binding get() = requireNotNull(_binding!!) {"Binding wasn't initialized"}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = VacanciesScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}