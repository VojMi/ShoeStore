package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.ListFragmentBinding

class ListFragment : Fragment() {

    private lateinit var binding: ListFragmentBinding
    private lateinit var viewModel: ListViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.title = "Choose your shoes!"

        val binding: ListFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.list_fragment, container, false)

        binding.addButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_listFragment_to_detailFragment)
        )
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {

            R.id.logout -> {
               requireView().findNavController().navigate(R.id.action_listFragment_to_loginFragment)
               return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
