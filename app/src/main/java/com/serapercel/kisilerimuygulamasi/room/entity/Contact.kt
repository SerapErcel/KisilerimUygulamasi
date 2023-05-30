package com.serapercel.kisilerimuygulamasi.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "nid")
    val nid: Int?,

    @ColumnInfo(name = "category")
    val category: String?,

    @ColumnInfo(name = "firstName")
    val firstName: String?,

    @ColumnInfo(name = "lastName")
    val lastName: String?,

    @ColumnInfo(name = "phone")
    val phone: String?,

    @ColumnInfo(name = "address")
    val address: String?
)
