package com.serapercel.kisilerimuygulamasi.ui.fragment.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.serapercel.kisilerimuygulamasi.databinding.FragmentFriendsBinding
import com.serapercel.kisilerimuygulamasi.room.entity.Contact
import com.serapercel.kisilerimuygulamasi.ui.adapter.ContactAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FriendsFragment : Fragment() {

    private var _binding: FragmentFriendsBinding? = null
    private val binding get() = _binding!!
    lateinit var list: List<Contact>
    lateinit var friendsViewModel: FriendsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        friendsViewModel =
            ViewModelProvider(this)[FriendsViewModel::class.java]

        _binding = FragmentFriendsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        friendsViewModel.getList()

        friendsViewModel.list.observe(viewLifecycleOwner) {
            list = it
            val adapter = ContactAdapter(requireActivity(), list)
            binding.lvFriends.adapter = adapter
        }
    }

    override fun onResume() {
        super.onResume()
        friendsViewModel.getList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}