package com.ahfasxp.testahfas.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahfasxp.testahfas.R
import com.ahfasxp.testahfas.core.data.source.remote.response.DataTryout
import kotlinx.android.synthetic.main.list_items.view.*
import java.util.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ListViewHolder>() {

    private var listData = ArrayList<DataTryout>()
    var onItemClick: ((DataTryout) -> Unit)? = null

    fun setData(newListData: List<DataTryout>?) {
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
        fun bind(data: DataTryout) {
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