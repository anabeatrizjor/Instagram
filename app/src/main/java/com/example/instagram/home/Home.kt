package com.example.instagram.home

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.instagram.R
import com.example.instagram.camera.FragmentCamera
import com.example.instagram.databinding.ActivityHomeBinding
import com.example.instagram.feed.FragmentFeed
import com.example.instagram.profile.FragmentProfile
import com.example.instagram.search.FragmentSearch
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var homeFragment: Fragment
    private lateinit var searchFragment: Fragment
    private lateinit var cameraFragment: Fragment
    private lateinit var profileFragment: Fragment
    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = getColor(R.color.white)

        val toolbar = findViewById<Toolbar>(R.id.toolbargeneral)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.baseline_camera_alt_24)
            title = ""
        }

        homeFragment = FragmentFeed()
        searchFragment = FragmentSearch()
        cameraFragment = FragmentCamera()
        profileFragment = FragmentProfile()

        binding.mainBottomNav.setOnNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            currentFragment = homeFragment
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment, currentFragment!!)
                .commit()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val selectedFragment = when (item.itemId) {
            R.id.menu_bottom_home -> homeFragment
            R.id.menu_bottom_profile -> profileFragment
            R.id.menu_bottom_search -> searchFragment
            R.id.menu_bottom_add -> cameraFragment
            else -> null
        }
        if (selectedFragment != null && selectedFragment != currentFragment) {
            currentFragment = selectedFragment
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment, currentFragment!!)
                .commit()
        }
        return true
    }
}
