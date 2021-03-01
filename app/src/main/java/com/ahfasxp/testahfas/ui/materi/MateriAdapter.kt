package com.ahfasxp.testahfas.ui.materi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahfasxp.testahfas.R
import com.ahfasxp.testahfas.core.domain.model.Materi
import kotlinx.android.synthetic.main.list_items.view.*
import java.util.*

class MateriAdapter : RecyclerView.Adapter<MateriAdapter.ListViewHolder>() {

    private var listData = ArrayList<Materi>()
    var onItemClick: ((Materi) -> Unit)? = null

    fun setData(newListData: List<Materi>?) {
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
        fun bind(data: Materi) {
            with(itemView) {

                tv_item_name.text = data.name
                tv_item_content.text = data.content

                itemView.setOnClickListener {
                    onItemClick?.invoke(listData[adapterPosition])
                }
            }
        }
    }
}