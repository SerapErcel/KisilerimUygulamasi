package com.serapercel.kisilerimuygulamasi.ui.fragment.family

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.serapercel.kisilerimuygulamasi.databinding.FragmentFamilyBinding
import com.serapercel.kisilerimuygulamasi.room.entity.Contact
import com.serapercel.kisilerimuygulamasi.ui.adapter.ContactAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FamilyFragment : Fragment() {

    private var _binding: FragmentFamilyBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
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