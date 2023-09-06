package com.example.lloydsproject.userModule.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lloydsproject.LloydDatabase
import com.example.lloydsproject.databinding.NewUserBinding
import com.example.lloydsproject.userModule.model.UserData
import com.example.lloydsproject.userModule.repository.NewUserRepository
import com.example.lloydsproject.userModule.viewmodel.NewUserViewModel
import com.example.lloydsproject.userModule.viewmodel.NewUserViewModelFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewUserFrag: Fragment() {

    private lateinit var binding: NewUserBinding
    private val newUserViewModel: NewUserViewModel by lazy {
        ViewModelProvider(requireActivity()).get(NewUserViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSubmit.setOnClickListener {
            val user = UserData(email = "senamit2708@gmial.com", firstName = binding.txtName.text.toString(), lastName = binding.txtLastName.text.toString(), avatar = "img")
            newUserViewModel.saveUser(user)
        }
    }

    companion object {
        private val TAG = NewUserFrag::class.java.simpleName
    }
}