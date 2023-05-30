package com.serapercel.kisilerimuygulamasi.ui.fragment.turkcellGYGY

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.serapercel.kisilerimuygulamasi.data.repository.ContactRepository
import com.serapercel.kisilerimuygulamasi.room.entity.Contact
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TurkcellGYGYViewModel @Inject constructor(var crepo: ContactRepository) : ViewModel() {
    private val _list = MutableLiveData<List<Contact>>()
    val list: LiveData<List<Contact>> get() = _list

    init {
        getList()
    }

    fun getList() {
        CoroutineScope(Dispatchers.Main).launch {
            _list.value = crepo.searchCategory("Turkcell GYGY")
        }
    }
}