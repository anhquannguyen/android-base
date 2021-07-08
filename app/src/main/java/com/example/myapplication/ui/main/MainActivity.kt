package com.example.myapplication.ui.main

import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.R
import com.example.myapplication.ViewModelProviderFactory
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.extension.hideKeyboard
import com.example.myapplication.extension.log
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    private val viewModel: MainViewModel by viewModels { factory }

    private val destinationIds =
        setOf(
            R.id.nav_home, R.id.nav_search, R.id.nav_account
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            setup(toolbar, bottomNav)
        }

    }

    private val setup: (Toolbar, BottomNavigationView) -> Unit = { toolbar, bottomNavigationView ->
        setSupportActionBar(toolbar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navHostFragment.childFragmentManager.addOnBackStackChangedListener {
            val count = navHostFragment.childFragmentManager.backStackEntryCount
            log("backStackEntryCount $count")
        }
        val navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _: NavController, destination: NavDestination, _: Bundle? ->
            //hideKeyboard()

//            Note: If not setupWithNavController, try this
//            val isItemNavigation = destinationIds.contains(destination.id)
//            bottomNavigationView.beVisibleIf(isItemNavigation)
//            supportActionBar?.let {
//                it.setDisplayHomeAsUpEnabled(!isItemNavigation)
//                it.title = destination.label
//            }

        }

        val appBarConfiguration = AppBarConfiguration(destinationIds)
        toolbar.setupWithNavController(navController, appBarConfiguration)
//        toolbar.setNavigationOnClickListener { onBackPressed() }

        bottomNavigationView.setupWithNavController(navController)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            navigateDestination(it.itemId, navController)
            true
        }

    }

    private val navigateDestination: (Int, NavController) -> Unit = { id, navController ->
        val currentDestinationId = navController.currentDestination?.id
        if (id != currentDestinationId)
            navController.navigate(id, null, navOptions { popUpTo(id) { inclusive = true } })
    }


}
