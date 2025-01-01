package com.example.solutionx.presentation.fragment.selective

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.solutionx.data.DataSource
import com.example.solutionx.databinding.FragmentSelectiveBinding
import com.example.solutionx.presentation.adapters.selectiveAdapter.Selective
import com.example.solutionx.presentation.adapters.selectiveAdapter.SelectiveAdapter

class SelectiveFragment : Fragment(), Selective.FavoriteListener, Selective.DeleteClickListener {

    private lateinit var selectiveAdapter: SelectiveAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSelectiveBinding.inflate(inflater, container, false)
        selectiveAdapter = SelectiveAdapter(DataSource.getOrders(), this@SelectiveFragment)
        binding.recyclerSingleSelection.apply {
            adapter = selectiveAdapter
        }
        return binding.root
    }

    override fun onFavoriteClicked(item: String) {
        Log.i("SelectiveFragment", "Item selected: $item")
    }

    override fun onDeleteClicked(item: String) {
        Log.i("SelectiveFragment", "Item deleted: $item")
    }
}