package com.example.solutionx.presentation.adapters.singleSelectionAdapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.solutionx.R
import com.example.solutionx.data.models.SingleItem
import com.example.solutionx.databinding.ItemSingleSelectionBinding

@SuppressLint("NotifyDataSetChanged")
class SingleSelectionAdapter(
    private val items : List<SingleItem> = emptyList(),
    private val listener: SingleSelectionAdapterListener
) : RecyclerView.Adapter<SingleSelectionAdapter.ViewHolder>() {

    private var checkedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSingleSelectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(private val binding: ItemSingleSelectionBinding) : View.OnClickListener,
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(item: SingleItem): Unit = with(binding) {
            val isItemSelected = checkedPosition == bindingAdapterPosition

            imgCheck.visibility = if (isItemSelected) View.VISIBLE else View.GONE

            txtItemName.apply {
                text = item.name
                val textColor = if (isItemSelected) R.color.primary else R.color.onBackground
                setTextColor(ContextCompat.getColor(context, textColor))
                root.isSelected = isItemSelected
            }
        }

        override fun onClick(view: View) {
            applySelector(items[bindingAdapterPosition])
        }
    }

    private fun applySelector(item: SingleItem) {
        if (items.contains(item)) {
            val position = items.indexOf(item)
            checkedPosition = position
            notifyDataSetChanged()
            listener.onItemSelected(item)
        }
    }

    interface SingleSelectionAdapterListener {
        fun onItemSelected(item: SingleItem)
    }

}