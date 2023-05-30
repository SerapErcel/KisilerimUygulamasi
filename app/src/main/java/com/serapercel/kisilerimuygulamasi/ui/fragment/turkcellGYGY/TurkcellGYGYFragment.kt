package com.serapercel.kisilerimuygulamasi.ui.fragment.turkcellGYGY

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.serapercel.kisilerimuygulamasi.databinding.FragmentTurkcellGYGYBinding

class TurkcellGYGYFragment : Fragment() {

    private var _binding: FragmentTurkcellGYGYBinding? = null
    private val binding get() = _binding!!

    private lateinit var turkcellViewModel: TurkcellGYGYViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        turkcellViewModel =
            ViewModelProvider(this)[TurkcellGYGYViewModel::class.java]
        _binding = FragmentTurkcellGYGYBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}