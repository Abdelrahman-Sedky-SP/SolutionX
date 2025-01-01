package com.example.solutionx.presentation.adapters.selectiveAdapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.solutionx.databinding.ItemSelectiveBinding

@SuppressLint("NotifyDataSetChanged")
class SelectiveAdapter(
    private val items: List<String> = emptyList(),
    private val listener: Selective? = null,
) : RecyclerView.Adapter<SelectiveAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectiveAdapter.ViewHolder {
        val binding = ItemSelectiveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SelectiveAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(private val binding: ItemSelectiveBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            if (listener is Selective.DeleteClickListener) setupDeleteButton(item, listener)
            if (listener is Selective.FavoriteListener) setupFavoriteButton(item, listener)
            if (listener is Selective.EditClickListener) setupEditButton(item, listener)

            binding.txtItemName.text = item
        }

        private fun setupDeleteButton(item: String, listener: Selective.DeleteClickListener) {
            with(binding.imgDelete) {
                visibility = View.VISIBLE
                setOnClickListener { listener.onDeleteClicked(item) }
            }
        }

        private fun setupFavoriteButton(item: String, listener: Selective.FavoriteListener) {
            with(binding.imgFavorite) {
                visibility = View.VISIBLE
                setOnClickListener {
                    listener.onFavoriteClicked(item)
                }
            }
        }

        private fun setupEditButton(item: String, listener: Selective.EditClickListener) {
            with(binding.imgEdit) {
                visibility = View.VISIBLE
                setOnClickListener {
                    listener.onEditClicked(item)
                }
            }
        }

    }

}