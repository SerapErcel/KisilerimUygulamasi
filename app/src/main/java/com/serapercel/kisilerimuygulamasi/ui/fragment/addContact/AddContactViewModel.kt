package com.serapercel.kisilerimuygulamasi.ui.fragment.addContact

import androidx.lifecycle.ViewModel
import com.serapercel.kisilerimuygulamasi.data.repository.ContactRepository
import com.serapercel.kisilerimuygulamasi.room.entity.Contact
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddContactViewModel @Inject constructor(var crepo: ContactRepository) : ViewModel() {

    fun add(contact: Contact) {
        CoroutineScope(Dispatchers.Main).launch {
            crepo.addContact(contact)
        }
    }
}