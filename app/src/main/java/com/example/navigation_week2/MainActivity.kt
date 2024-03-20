package com.example.navigation_week2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.navigation_week2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)
        navController = (supportFragmentManager.findFragmentById(R.id.navHost) as
                NavHostFragment).navController
        //kalo mau tambahin drawer isi di paramter ke-3, kalo gada gausa
        NavigationUI.setupActionBarWithNavController(this, navController,binding.drawerLayout)

        //menyuruh agar navController menghandle Navigation View
        NavigationUI.setupWithNavController(binding.navView,navController)

        //menyerahkan agar navController menghandle bottomNav
        binding.bottomNav.setupWithNavController(navController)



    }

    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp()
        //artinysa bisa memunculkan drawer atau memunculkan backbutton di kiri atas
        return NavigationUI.navigateUp(navController,binding.drawerLayout) || super.onSupportNavigateUp()
    }
}