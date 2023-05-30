package com.serapercel.kisilerimuygulamasi.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "nid")
    var nid: Int?,

    @ColumnInfo(name = "category")
    val category: String?,

    @ColumnInfo(name = "firstName")
    var firstName: String?,

    @ColumnInfo(name = "lastName")
    var lastName: String?,

    @ColumnInfo(name = "phone")
    var phone: String?,

    @ColumnInfo(name = "address")
    var address: String?
)
