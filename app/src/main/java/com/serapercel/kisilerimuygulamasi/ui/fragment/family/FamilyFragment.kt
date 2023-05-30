package com.serapercel.kisilerimuygulamasi.ui.fragment.family

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.serapercel.kisilerimuygulamasi.databinding.FragmentFamilyBinding

class FamilyFragment : Fragment() {

    private var _binding: FragmentFamilyBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val familyViewModel =
            ViewModelProvider(this).get(FamilyViewModel::class.java)

        _binding = FragmentFamilyBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}