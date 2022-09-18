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
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layoutResourceId,
            parent,
            false
        )
        return GalleryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(galleryList[position])
        holder.binding.executePendingBindings()
        this@GalleryListAdapter.itemClickListener?.let {
            (holder.binding as? GalleryListItemBinding)?.itemClickListener =
                this@GalleryListAdapter.itemClickListener
        }
    }

    override fun getItemCount(): Int = galleryList.size ?: 0

    class GalleryViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(nasaGallery: NasaGallery) {
            if (binding is GalleryDetailsItemBinding) {
                binding.model = nasaGallery
            } else if (binding is GalleryListItemBinding) {
                binding.model = nasaGallery
            }
        }
    }

}