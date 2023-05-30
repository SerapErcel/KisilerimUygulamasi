package com.serapercel.kisilerimuygulamasi.ui.fragment.addContact

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.serapercel.kisilerimuygulamasi.databinding.FragmentAddContactBinding
import com.serapercel.kisilerimuygulamasi.room.entity.Contact
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddContactFragment : Fragment() {

    private var _binding: FragmentAddContactBinding? = null
    private val binding get() = _binding!!

    private lateinit var addContactViewModel: AddContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        addContactViewModel =
            ViewModelProvider(this)[AddContactViewModel::class.java]

        _binding = FragmentAddContactBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val spinnerAdapter: ArrayAdapter<String> = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            mutableListOf("Family", "Friends", "School", "Turkcell GYGY")
        )
        binding.spinner.adapter = spinnerAdapter

        binding.btnAddContact.setOnClickListener {
            if (!binding.etFirstName.text.isNullOrEmpty() || !binding.etLastName.text.isNullOrEmpty()) {
                val category = binding.spinner.selectedItem as String
                val firstName = binding.etFirstName.text.toString()
                val lastName = binding.etLastName.text.toString()
                val address = binding.etAddress.text.toString()
                val phone = binding.etPhoneNum.text.toString()
                val contact = Contact(null, category, firstName, lastName, phone, address)
                addContactViewModel.add(contact)
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}