package com.ahfasxp.testahfas.ui.tryout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahfasxp.testahfas.R
import com.ahfasxp.testahfas.core.domain.model.Tryout
import kotlinx.android.synthetic.main.list_items.view.*
import java.util.*

class TryoutAdapter : RecyclerView.Adapter<TryoutAdapter.ListViewHolder>() {

    private var listData = ArrayList<Tryout>()
    var onItemClick: ((Tryout) -> Unit)? = null

    fun setData(newListData: List<Tryout>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_items, parent, false)
        )

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: Tryout) {
            with(itemView) {

                tv_item_name.text = data.name
                tv_item_content.text = data.description
                tv_item_date.text = data.time

                itemView.setOnClickListener {
                    onItemClick?.invoke(listData[adapterPosition])
                }
            }
        }
    }
}