package com.test.musicapp.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.test.domain.models.MusicModel
import com.test.musicapp.R
import com.test.musicapp.base.BaseAdapter
import com.test.musicapp.base.BaseViewHolder
import com.test.musicapp.databinding.MusicItemViewBinding
import javax.inject.Inject

class MusicSearchAdapter @Inject constructor(
    private val glide: RequestManager
) : BaseAdapter<MusicModel>() {


    private val diffCallback = object : DiffUtil.ItemCallback<MusicModel>() {
        override fun areItemsTheSame(oldItem: MusicModel, newItem: MusicModel): Boolean =
            oldItem.trackId == newItem.trackId

        override fun areContentsTheSame(oldItem: MusicModel, newItem: MusicModel): Boolean =
            oldItem.hashCode() == newItem.hashCode()
    }

    override val differ: AsyncListDiffer<MusicModel> = AsyncListDiffer(this, diffCallback)

    override fun getViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<MusicModel> {
        val binding =
            MusicItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MusicSearchItemViewHolder(binding)
    }

    inner class MusicSearchItemViewHolder(private val binding: MusicItemViewBinding) :
        BaseViewHolder<MusicModel>(binding.root) {
        override fun onBind(item: MusicModel) {
            binding.apply {
                val context = tvReleaseDate.context
                tvTrackName.text = item.trackName
                tvReleaseDate.text =
                    context.getString(R.string.str_date, item.releaseDate)
                tvArtistName.text =
                    context.getString(R.string.str_artist_name, item.artistName, item.country)
                musicDescription.text = context.getString(
                    R.string.str_description,
                    item.primaryGenreName,
                    item.trackPrice.toString()
                )
                glide.load(item.artworkUrl100).into(musicImage)
            }
        }

    }


}