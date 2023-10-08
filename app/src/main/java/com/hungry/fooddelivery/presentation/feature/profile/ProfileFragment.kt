package com.hungry.fooddelivery.presentation.feature.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hungry.fooddelivery.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        profileViewModel.username.observe(viewLifecycleOwner) { username ->
            binding.tvUsername.text = username
        }

        profileViewModel.password.observe(viewLifecycleOwner) { password ->
            binding.tvPassword.text = password
        }

        profileViewModel.email.observe(viewLifecycleOwner) { email ->
            binding.tvEmail.text = email
        }

        profileViewModel.phone.observe(viewLifecycleOwner) { phone ->
            binding.tvPhone.text = phone
        }

        return binding.root
    }
}
