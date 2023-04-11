package com.example.othregensburg.zapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val data: List<String>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // TODO (1) Let the ViewHolder implement a View.OnClickListener
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemCheckBox: CheckBox = view.findViewById(R.id.checkbox)

        // TODO (2) Set the OnCLickListener to the checkboxes

        // TODO (3) Show a Toast with position and state of the clicked checkbox

        // TODO (4) Fix the issue with checkbox state of the recycled views which occurs after scrolling up and down
        // Hint: Make use of a SpareBooleanArray
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val itemString = data[position]
        holder.itemCheckBox.text = itemString
    }
}
