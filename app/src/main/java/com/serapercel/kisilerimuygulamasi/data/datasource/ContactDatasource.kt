package com.serapercel.kisilerimuygulamasi.data.datasource

import com.serapercel.kisilerimuygulamasi.room.dao.ContactDAO
import com.serapercel.kisilerimuygulamasi.room.entity.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactDatasource(var cdao: ContactDAO) {

    suspend fun getContacts(): List<Contact> = withContext(Dispatchers.IO) {
        cdao.getContacts()
    }

    suspend fun addContact(contact: Contact) = withContext(Dispatchers.IO) {
        cdao.addContact(contact)
    }

    suspend fun upsertContact(contact: Contact) = withContext(Dispatchers.IO) {
        cdao.upsertContact(contact)
    }

    suspend fun deleteContact(contact: Contact) = withContext(Dispatchers.IO) {
        cdao.deleteContact(contact)
    }

    suspend fun searchCategory(search: String): List<Contact> =
        withContext(Dispatchers.IO) {
            cdao.searchCategory(search)
        }

    suspend fun searchFirstName(search: String): List<Contact> =
        withContext(Dispatchers.IO) {
            cdao.searchFirstName(search)
        }

}