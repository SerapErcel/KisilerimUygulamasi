package com.serapercel.kisilerimuygulamasi.ui.fragment.family

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.serapercel.kisilerimuygulamasi.R
import com.serapercel.kisilerimuygulamasi.databinding.FragmentFamilyBinding
import com.serapercel.kisilerimuygulamasi.room.entity.Contact
import com.serapercel.kisilerimuygulamasi.ui.adapter.ContactAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FamilyFragment : Fragment() {

    private var _binding: FragmentFamilyBinding? = null
    private val binding get() = _binding!!
    lateinit var list: List<Contact>
    lateinit var familyViewModel: FamilyViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        familyViewModel =
            ViewModelProvider(this)[FamilyViewModel::class.java]

        _binding = FragmentFamilyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        familyViewModel.getList()

        familyViewModel.list.observe(viewLifecycleOwner) {
            list = it
            val adapter = ContactAdapter(requireActivity(), list)
            binding.lvFamily.adapter = adapter
        }

        binding.lvFamily.setOnItemClickListener { _, _, position, _ ->
            val navController = findNavController()
            val bundle = Bundle()
            bundle.putInt(
                "id",
                list[position].nid!!
            )
            navController.navigate(R.id.nav_detail, bundle)
        }
    }

    override fun onResume() {
        super.onResume()
        familyViewModel.getList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}