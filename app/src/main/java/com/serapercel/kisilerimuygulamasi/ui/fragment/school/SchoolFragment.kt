package com.serapercel.kisilerimuygulamasi.ui.fragment.school

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.serapercel.kisilerimuygulamasi.databinding.FragmentSchoolBinding

class SchoolFragment : Fragment() {

    private var _binding: FragmentSchoolBinding? = null
    private val binding get() = _binding!!

    private lateinit var schoolViewModel: SchoolViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        schoolViewModel =
            ViewModelProvider(this)[SchoolViewModel::class.java]
        _binding = FragmentSchoolBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}