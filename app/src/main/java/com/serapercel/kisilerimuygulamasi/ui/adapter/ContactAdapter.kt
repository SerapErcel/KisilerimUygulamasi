package com.serapercel.kisilerimuygulamasi.ui.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.serapercel.kisilerimuygulamasi.R
import com.serapercel.kisilerimuygulamasi.room.entity.Contact

class ContactAdapter(private val context: Activity, private val list: List<Contact>) :
    ArrayAdapter<Contact>(context, R.layout.card_item, list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.card_item, null, true)

        val category = rootView.findViewById<TextView>(R.id.tvContactCategory)
        val firstName = rootView.findViewById<TextView>(R.id.tvContactFirstName)
        val lastName = rootView.findViewById<TextView>(R.id.tvContactLastName)
        val phone = rootView.findViewById<TextView>(R.id.tvContactPhone)
        val address = rootView.findViewById<TextView>(R.id.tvContactAddress)

        val contact = list[position]
        category.text = contact.category
        firstName.text = contact.firstName
        lastName.text = contact.lastName
        phone.text = contact.phone
        address.text = contact.address

        return rootView
    }
}