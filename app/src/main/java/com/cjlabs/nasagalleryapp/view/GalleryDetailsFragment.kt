package com.cjlabs.nasagalleryapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.cjlabs.nasagalleryapp.R
import com.cjlabs.nasagalleryapp.databinding.FragmentGalleryDetailsBinding
import com.cjlabs.nasagalleryapp.view.adapter.GalleryListAdapter
import com.cjlabs.nasagalleryapp.viewmodel.NasaViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class GalleryDetailsFragment : Fragment() {

    private var _binding: FragmentGalleryDetailsBinding? = null

    private val sharedViewModel: NasaViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentGalleryDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            adapter = GalleryListAdapter(sharedViewModel.nasaGalleryList, R.layout.gallery_details_item)
            Log.i(javaClass.simpleName,"onViewCreated ItemPosition =${sharedViewModel.getItemPosition()}")

            detailViewPager.post {
                detailViewPager.setCurrentItem(sharedViewModel.getItemPosition(), false)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}