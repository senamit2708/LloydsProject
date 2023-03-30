package com.example.lloydsproject.userModule.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.lloydsproject.databinding.UserDetailBinding
import com.example.lloydsproject.userModule.viewmodel.UserViewModel

class UserDetailFragment : Fragment() {

    private val TAG = UserDetailFragment::class.java.simpleName
    private lateinit var binding: UserDetailBinding
    private lateinit var mUserViewModel: UserViewModel
    private var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mUserViewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UserDetailBinding.inflate(inflater, container, false)
        context = container?.context
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getUserDetail()
    }

    private fun getUserDetail() {
        mUserViewModel.getSelectedUserDetail().observe(requireActivity(), Observer { user ->
            user?.let {
                binding.txtName.text = user?.firstName + user?.lastName
                context?.let { context ->
                    Glide.with(context).load(user.avatar).into(binding.imgFace)
                }

            }
        })
    }
}