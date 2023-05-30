package com.serapercel.kisilerimuygulamasi.ui.fragment.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serapercel.kisilerimuygulamasi.data.repository.ContactRepository
import com.serapercel.kisilerimuygulamasi.room.entity.Contact
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(var crepo: ContactRepository) : ViewModel() {

    var contact = MutableLiveData<Contact>()
    fun getContactSafeCall(id: Int) {
        viewModelScope.launch(Dispatchers.Main) {
            contact.value= crepo.getContact(id)
        }
    }

    fun updateContact(contact: Contact) {
        CoroutineScope(Dispatchers.Main).launch {
            crepo.updateContact(contact)
        }
    }

    fun deleteContact(contact: Contact) {
        CoroutineScope(Dispatchers.Main).launch {
            crepo.deleteContact(contact)
        }
    }

}