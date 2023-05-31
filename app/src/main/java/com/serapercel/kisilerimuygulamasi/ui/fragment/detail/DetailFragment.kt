package com.serapercel.kisilerimuygulamasi.ui.fragment.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.serapercel.kisilerimuygulamasi.R
import com.serapercel.kisilerimuygulamasi.databinding.FragmentDetailBinding
import com.serapercel.kisilerimuygulamasi.room.entity.Contact
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var detailViewModel: DetailViewModel
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailViewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val navController = findNavController()
        super.onViewCreated(view, savedInstanceState)
        val id = args.id
        detailViewModel.getContactSafeCall(id)

        val spinnerAdapter: ArrayAdapter<String> = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            mutableListOf("Family", "Friends", "School", "Turkcell GYGY")
        )
        binding.spinnerDetail.adapter = spinnerAdapter

        detailViewModel.contact.observe(viewLifecycleOwner) { contact ->
            var categoryId = 0
            when (contact.category) {
                "Family" -> categoryId = 0
                "Friends" -> categoryId = 1
                "School" -> categoryId = 2
                "Turkcell GYGY" -> categoryId = 3
            }
            binding.spinnerDetail.setSelection(categoryId)
            binding.etDetailFirstName.setText(contact.firstName)
            binding.etDetailLastName.setText(contact.lastName)
            binding.etDetailPhoneNum.setText(contact.phone)
            binding.etDetailAddress.setText(contact.address)

            binding.btnDeleteContact.setOnClickListener {
                detailViewModel.deleteContact(contact)
                navController.navigate(R.id.nav_home)
            }
            binding.btnUpdateContact.setOnClickListener {

                val newContact = Contact(
                    contact.nid,
                    binding.spinnerDetail.selectedItem.toString(),
                    binding.etDetailFirstName.text.toString(),
                    binding.etDetailLastName.text.toString(),
                    binding.etDetailPhoneNum.text.toString(),
                    binding.etDetailAddress.text.toString()
                )
                detailViewModel.updateContact(newContact)
                navController.navigate(R.id.nav_home)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}