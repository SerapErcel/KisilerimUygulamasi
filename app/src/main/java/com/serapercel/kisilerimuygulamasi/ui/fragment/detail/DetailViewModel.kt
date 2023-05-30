package com.serapercel.kisilerimuygulamasi.ui.fragment.detail

import androidx.lifecycle.ViewModel
import com.serapercel.kisilerimuygulamasi.data.repository.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(var crepo: ContactRepository) : ViewModel() {
    // TODO: Implement the ViewModel
}