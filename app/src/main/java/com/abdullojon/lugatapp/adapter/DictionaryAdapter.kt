package com.abdullojon.lugatapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.abdullojon.lugatapp.R
import com.abdullojon.lugatapp.data.Dictionary
import com.abdullojon.lugatapp.databinding.FragmentItemBinding

class DictionaryAdapter : RecyclerView.Adapter<DictionaryAdapter.ViewHolder>() {
    private var list: List<Dictionary> = emptyList()
    private var query = ""
    private var listenerSpec: ((String) -> Unit)? = null
    private var onItemClickListener: ((Dictionary) -> Unit)? = null
    private var onBookmarkClickListener: ((Dictionary) -> Unit)? = null

    fun SetListenerSpec(listener: (String) -> Unit) {
        listenerSpec = listener
    }

    fun setOnItemClickListener(listener: (Dictionary) -> Unit) {
        onItemClickListener = listener
    }

    fun setOnBookmarkClickListener(listener: (Dictionary) -> Unit) {
        onBookmarkClickListener = listener
    }

    fun submitList(list: List<Dictionary>, query: String) {
        this.list = list
        this.query = query
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: FragmentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Dictionary) {
            binding.text.text = "${data.english} - ${data.uzbek}".generateTextColor(
                query,
                ContextCompat.getColor(binding.root.context, R.color.green_primary)
            )

            val bookmarkRes = if (data.isFavourite == 1) {
                R.drawable.ic_bookmark_filled
            } else {
                R.drawable.ic_bookmark_border
            }
            binding.btnBookmark.setImageResource(bookmarkRes)

            binding.volume.setOnClickListener {
                listenerSpec?.invoke(data.english)
            }
            binding.btnBookmark.setOnClickListener {
                onBookmarkClickListener?.invoke(data)
            }
            binding.root.setOnClickListener {
                onItemClickListener?.invoke(data)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder = ViewHolder(
        FragmentItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}