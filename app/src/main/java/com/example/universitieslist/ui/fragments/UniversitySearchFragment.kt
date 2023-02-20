package com.example.universitieslist.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.universitieslist.R
import com.example.universitieslist.databinding.UniversitySearchFragmentBinding

class UniversitySearchFragment : Fragment(R.layout.university_search_fragment) {

    private lateinit var universitySearchFragment: UniversitySearchFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        universitySearchFragment =
            UniversitySearchFragmentBinding.inflate(inflater, container, false)
        viewInitialize()
        return universitySearchFragment.root
    }


    private fun viewInitialize() {
        universitySearchFragment.tvSearch.setOnClickListener {
            if (!universitySearchFragment.etCountryName.text.toString().trim().isNullOrEmpty()) {
                findNavController().navigate(
                    R.id.search_to_list,
                    bundleOf("query" to universitySearchFragment.etCountryName.text.toString().trim())
                )
            } else {
                Toast.makeText(requireActivity(), "Please enter country name", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}