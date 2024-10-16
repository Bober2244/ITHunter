package dev.bober.ithunter

import android.os.Bundle
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.bober.ithunter.databinding.ActivityMainBinding
import dev.bober.presentation.R.id.navigation_search
import dev.bober.presentation.R.id.navigation_favorite
import dev.bober.presentation.R.id.navigation_response
import dev.bober.presentation.R.id.navigation_messages
import dev.bober.presentation.R.id.navigation_profile
import dev.bober.utils.badgeSetup

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(getColor(dev.bober.presentation.R.color.black)),
        )
        super.onCreate(savedInstanceState)
        hideActionBar()
        setupActivity()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun hideActionBar(){
        supportActionBar?.hide()
    }

    private fun setupActivity(){
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                navigation_search,
                navigation_favorite,
                navigation_response,
                navigation_messages,
                navigation_profile,
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}