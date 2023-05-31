package com.serapercel.kisilerimuygulamasi.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.serapercel.kisilerimuygulamasi.R
import com.serapercel.kisilerimuygulamasi.databinding.FragmentHomeBinding
import com.serapercel.kisilerimuygulamasi.room.entity.Contact
import com.serapercel.kisilerimuygulamasi.ui.adapter.ContactAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    lateinit var list: List<Contact>
    lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.getList()

        homeViewModel.list.observe(viewLifecycleOwner) {
            list = it
            val adapter = ContactAdapter(requireActivity(), list)
            binding.lvHomeContacts.adapter = adapter
        }

        binding.svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                homeViewModel.search(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                homeViewModel.search(newText)
                return true
            }
        })

        binding.lvHomeContacts.setOnItemClickListener { _, _, position, _ ->
            val navController = findNavController()
            val bundle = Bundle()
            bundle.putInt( "id", list[position].nid!! )
            navController.navigate(R.id.nav_detail, bundle)
        }
    }

    override fun onResume() {
        super.onResume()
        homeViewModel.getList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}