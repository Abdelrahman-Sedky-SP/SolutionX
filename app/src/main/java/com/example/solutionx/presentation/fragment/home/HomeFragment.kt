package com.example.solutionx.presentation.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.solutionx.R
import com.example.solutionx.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.buttonResources.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_resourcesFragment)
        }
        binding.buttonSingleSelection.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_singleSelectionFragment)
        }
        binding.buttonSelective.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_selectiveFragment)
        }
        return binding.root
    }

}