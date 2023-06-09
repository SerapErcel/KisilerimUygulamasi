package com.serapercel.kisilerimuygulamasi.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.serapercel.kisilerimuygulamasi.room.entity.Contact

@Dao
interface ContactDAO {

    // Tablodaki Verileri Getirir
    @Query("SELECT * FROM contacts ORDER BY nid DESC LIMIT 10")
    suspend fun getContacts(): List<Contact>

    // Tablodaki Veriyi Getirir
    @Query("SELECT * FROM contacts WHERE nid like :id")
    suspend fun getContact(id: Int): Contact

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

    @Query("SELECT * FROM contacts WHERE category like '%' || :search || '%'")
    suspend fun searchCategory(search: String): List<Contact>

    @Query("SELECT * FROM contacts WHERE firstName like '%' || :search || '%'")
    suspend fun searchFirstName(search: String): List<Contact>
}