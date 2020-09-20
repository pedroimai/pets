package com.pedroimai.pets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pedroimai.pets.listing.ListingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ListingFragment.newInstance())
                    .commitNow()
        }
    }
}