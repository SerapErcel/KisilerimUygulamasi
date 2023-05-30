package com.serapercel.kisilerimuygulamasi.ui.fragment.school

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.serapercel.kisilerimuygulamasi.R
import com.serapercel.kisilerimuygulamasi.databinding.FragmentSchoolBinding
import com.serapercel.kisilerimuygulamasi.room.entity.Contact
import com.serapercel.kisilerimuygulamasi.ui.adapter.ContactAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SchoolFragment : Fragment() {

    private var _binding: FragmentSchoolBinding? = null
    private val binding get() = _binding!!
    lateinit var list: List<Contact>
    private lateinit var schoolViewModel: SchoolViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        schoolViewModel =
            ViewModelProvider(this)[SchoolViewModel::class.java]
        _binding = FragmentSchoolBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        schoolViewModel.getList()

        schoolViewModel.list.observe(viewLifecycleOwner) {
            list = it
            val adapter = ContactAdapter(requireActivity(), list)
            binding.lvSchool.adapter = adapter
        }
        binding.lvSchool.setOnItemClickListener { _, _, position, _ ->
            val navController = findNavController()
            val bundle = Bundle()
            bundle.putInt(
                "id",
                list[position].nid!!
            ) // Argümanı bundle'a ekle, istediğiniz veriyi ekleyebilirsiniz
            navController.navigate(R.id.nav_detail, bundle)
        }
    }

    override fun onResume() {
        super.onResume()
        schoolViewModel.getList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}