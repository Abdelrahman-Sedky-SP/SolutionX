package com.example.solutionx.presentation.fragment.singleSelection

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.solutionx.data.DataSource
import com.example.solutionx.data.models.SingleItem
import com.example.solutionx.databinding.FragmentSingleSelectionBinding
import com.example.solutionx.presentation.adapters.singleSelectionAdapter.SingleSelectionAdapter

class SingleSelectionFragment : Fragment(), SingleSelectionAdapter.SingleSelectionAdapterListener {

    private lateinit var singleSelectionAdapter: SingleSelectionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSingleSelectionBinding.inflate(inflater, container, false)

        singleSelectionAdapter =
            SingleSelectionAdapter(DataSource.getCountries(requireContext()), this@SingleSelectionFragment)

        binding.recyclerSingleSelection.apply {
            adapter = singleSelectionAdapter
        }

        return binding.root
    }

    override fun onItemSelected(item: SingleItem) {
        Log.i("SingleSelectionFragment", "Item selected: ${item.name}")
    }
}