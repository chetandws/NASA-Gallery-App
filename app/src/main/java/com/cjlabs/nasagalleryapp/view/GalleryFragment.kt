package com.cjlabs.nasagalleryapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.cjlabs.nasagalleryapp.R
import com.cjlabs.nasagalleryapp.databinding.FragmentGalleryListBinding
import com.cjlabs.nasagalleryapp.model.NasaGallery
import com.cjlabs.nasagalleryapp.view.adapter.GalleryListAdapter
import com.cjlabs.nasagalleryapp.view.adapter.ItemClickListener
import com.cjlabs.nasagalleryapp.viewmodel.NasaViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GalleryFragment : Fragment(), ItemClickListener {

    private var _binding: FragmentGalleryListBinding? = null
    private val sharedViewModel: NasaViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGalleryListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            adapter = GalleryListAdapter(sharedViewModel.nasaGalleryList,R.layout.gallery_list_item, this@GalleryFragment)
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun itemClicked(item: NasaGallery) {
        sharedViewModel.setItemPosition(item)
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }
}