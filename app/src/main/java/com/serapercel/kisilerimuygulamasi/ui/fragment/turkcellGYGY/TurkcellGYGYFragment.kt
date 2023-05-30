package com.serapercel.kisilerimuygulamasi.ui.fragment.turkcellGYGY

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.serapercel.kisilerimuygulamasi.R
import com.serapercel.kisilerimuygulamasi.databinding.FragmentTurkcellGYGYBinding
import com.serapercel.kisilerimuygulamasi.room.entity.Contact
import com.serapercel.kisilerimuygulamasi.ui.adapter.ContactAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TurkcellGYGYFragment : Fragment() {

    private var _binding: FragmentTurkcellGYGYBinding? = null
    private val binding get() = _binding!!
    lateinit var list: List<Contact>
    private lateinit var turkcellViewModel: TurkcellGYGYViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        turkcellViewModel =
            ViewModelProvider(this)[TurkcellGYGYViewModel::class.java]
        _binding = FragmentTurkcellGYGYBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        turkcellViewModel.getList()

        turkcellViewModel.list.observe(viewLifecycleOwner) {
            list = it
            val adapter = ContactAdapter(requireActivity(), list)
            binding.lvTurkcell.adapter = adapter
        }
        binding.lvTurkcell.setOnItemClickListener { _, _, position, _ ->
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
        turkcellViewModel.getList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}