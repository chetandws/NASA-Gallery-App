package com.cjlabs.nasagalleryapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.cjlabs.nasagalleryapp.databinding.GalleryDetailsItemBinding
import com.cjlabs.nasagalleryapp.databinding.GalleryListItemBinding
import com.cjlabs.nasagalleryapp.model.NasaGallery

class GalleryListAdapter(
    private val galleryList: List<NasaGallery>,
    private val layoutResourceId: Int,
    private val itemClickListener: ItemClickListener? = null
) : RecyclerView.Adapter<GalleryListAdapter.GalleryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {

        val viewHolder: GalleryViewHolder = if (itemClickListener == null) {
            val binding: GalleryDetailsItemBinding =
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    layoutResourceId, parent, false)
            GalleryPagerViewHolder(binding)
        } else {
            val binding: GalleryListItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutResourceId, parent, false)
            GalleryListViewHolder(binding)
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val dataModel: NasaGallery = galleryList[position]
        holder.bind(dataModel)
        holder.binding.executePendingBindings()
        this@GalleryListAdapter.itemClickListener?.let {
            (holder.binding as? GalleryListItemBinding)?.itemClickListener =
                this@GalleryListAdapter.itemClickListener
        }
    }

    override fun getItemCount(): Int = galleryList.size ?: 0

    class GalleryListViewHolder(binding: GalleryListItemBinding) :
        GalleryViewHolder(binding) {

        override fun bind(nasaGallery: NasaGallery) {
            (binding as? GalleryListItemBinding)?.model = nasaGallery
        }
    }

    class GalleryPagerViewHolder(binding: GalleryDetailsItemBinding) :
        GalleryViewHolder(binding) {
        override fun bind(nasaGallery: NasaGallery) {
            (binding as? GalleryDetailsItemBinding)?.model = nasaGallery
        }
    }

    abstract class GalleryViewHolder(
        val binding: ViewDataBinding,
    ) :
        RecyclerView.ViewHolder(binding.root) {
        abstract fun bind(nasaGallery: NasaGallery)
    }

}