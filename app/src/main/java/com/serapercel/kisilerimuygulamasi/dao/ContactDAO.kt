package com.serapercel.kisilerimuygulamasi.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.serapercel.kisilerimuygulamasi.model.Contact

interface ContactDAO {

    // Tablodaki Verileri Getirir
    @Query("SELECT * FROM contacts")
    suspend fun getContacts(): List<Contact>

    // Veri Tabloda Mevcutsa Günceller, Mevcut Değilse Ekler -YENİ
    @Upsert
    suspend fun upsertContact(contact: Contact)

    // Tabloya Veri Ekler
    @Insert
    suspend fun addContact(contact: Contact)

    // Tablodaki Veriyi Günceller
    @Update
    suspend fun updateContact(contact: Contact)

    // Tablodan Veri Siler
    @Delete
    suspend fun deleteContact(contact: Contact)
}