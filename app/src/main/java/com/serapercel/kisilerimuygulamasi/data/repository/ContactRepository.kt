package com.serapercel.kisilerimuygulamasi.data.repository

import com.serapercel.kisilerimuygulamasi.data.datasource.ContactDatasource
import com.serapercel.kisilerimuygulamasi.room.entity.Contact


class ContactRepository(var cds: ContactDatasource) {

    suspend fun getContacts(): List<Contact> = cds.getContacts()

    suspend fun addContact(contact: Contact) = cds.addContact(contact)

    suspend fun upsertContact(contact: Contact) = cds.upsertContact(contact)

    suspend fun deleteContact(contact: Contact) = cds.deleteContact(contact)

    suspend fun searchCategory(search: String): List<Contact> = cds.searchCategory(search)

    suspend fun searchFirstName(search: String): List<Contact> = cds.searchFirstName(search)

}