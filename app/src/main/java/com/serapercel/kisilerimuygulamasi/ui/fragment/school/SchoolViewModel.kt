package com.serapercel.kisilerimuygulamasi.ui.fragment.school

import androidx.lifecycle.ViewModel
import com.serapercel.kisilerimuygulamasi.data.repository.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SchoolViewModel  @Inject constructor(var crepo: ContactRepository) : ViewModel() {
    // TODO: Implement the ViewModel
}