package com.example.simpleandroidapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.simpleandroidapp.features.details.DetailsFragment
import com.example.simpleandroidapp.features.login.LoginFragment

/**
 * Main activity for the app, responsible for navigation.
 */
class MainActivity : AppCompatActivity() {
    companion object {
        const val USERNAME_KEY = "username"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goToDetailsFragment(username: String) {
        val args = bundleOf(Pair(USERNAME_KEY, username))
        val fragmentManager = supportFragmentManager

        fragmentManager.commit {
            setReorderingAllowed(true)
            setCustomAnimations(
                R.anim.slide_in,
                R.anim.fade_out,
                R.anim.fade_in,
                R.anim.slide_out
            )
            replace(R.id.fragment_main_layout, DetailsFragment::class.java, args)
        }
    }

    fun goToLoginFragment() {
        val fragmentManager = supportFragmentManager

        fragmentManager.commit {
            setReorderingAllowed(true)
            setCustomAnimations(
                R.anim.slide_out,
                R.anim.fade_out,
                R.anim.fade_in,
                R.anim.slide_in
            )
            replace<LoginFragment>(R.id.fragment_main_layout)
        }
    }

}