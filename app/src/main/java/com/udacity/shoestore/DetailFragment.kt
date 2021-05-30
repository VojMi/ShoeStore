package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?     {
        val binding: FragmentDetailBinding =
            DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false)

        binding.saveButton.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_detailFragment_to_listFragment))

        binding.backButton.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_detailFragment_to_listFragment))

        return binding.root
    }


}