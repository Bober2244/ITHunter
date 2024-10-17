package dev.bober.presentation.screens.response

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.bober.presentation.R
import dev.bober.presentation.databinding.ResponseScreenBinding

class ResponseScreen : Fragment(R.layout.response_screen) {

    private var _binding : ResponseScreenBinding? = null
    private val binding get() = requireNotNull(_binding!!) {"Binding wasn't initialized"}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}