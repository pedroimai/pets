package com.pedroimai.pets.listing

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pedroimai.pets.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListingFragment : Fragment(R.layout.fragment_listing) {

    private val viewModel: ListingViewModel by viewModels()

}