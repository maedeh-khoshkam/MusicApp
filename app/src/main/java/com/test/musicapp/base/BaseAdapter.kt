package com.test.musicapp.base

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>() {


    protected abstract val differ: AsyncListDiffer<T>

    var list: List<T>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> =
        getViewHolder(parent, viewType)

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        if (position in list.indices) {
            holder.onBind(list[position])
        }
    }

    abstract fun getViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T>

    override fun getItemCount(): Int {
        return list.size
    }

    protected var onItemClickListener: ((T) -> Unit)? = null

    fun setItemClickListener(listener: (T) -> Unit) {
        onItemClickListener = listener
    }

    interface Binder<in T> {
        fun bind(item: T)
    }
}