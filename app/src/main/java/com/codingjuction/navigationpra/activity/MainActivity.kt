package com.codingjuction.navigationpra.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.codingjuction.navigationpra.R


class MainActivity : AppCompatActivity() {

    private lateinit var navController : NavController

    private lateinit var bottonNav : BottomNavigationView

    lateinit var mtoolbar : Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mtoolbar = findViewById(R.id.toolbar)

        setSupportActionBar(mtoolbar)

        navController = Navigation.findNavController(this, R.id.fragment)

        bottonNav = findViewById(R.id.bottomNav)


        bottonNav.setupWithNavController(navController)

        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }
}


