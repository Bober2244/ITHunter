package dev.bober.presentation.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.bober.presentation.R
import dev.bober.presentation.databinding.FavoriteScreenBinding

class FavoriteScreen : Fragment(R.layout.favorite_screen) {

    private var _binding: FavoriteScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return binding.root
    }
}