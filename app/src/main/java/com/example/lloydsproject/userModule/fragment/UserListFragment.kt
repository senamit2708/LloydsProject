package com.example.lloydsproject.userModule.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lloydsproject.MainActivity
import com.example.lloydsproject.R
import com.example.lloydsproject.databinding.UserListBinding
import com.example.lloydsproject.userModule.adapter.UserListAdapter
import com.example.lloydsproject.userModule.interfaces.UserIface
import com.example.lloydsproject.userModule.model.UserData
import com.example.lloydsproject.userModule.viewmodel.UserViewModel

class UserListFragment : Fragment(), UserIface {

    private val TAG = UserListFragment::class.java.simpleName
    private lateinit var binding: UserListBinding
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var userListAdapter: UserListAdapter
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mUserViewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadRecycler()
        loadUserDetailFromServer()
        loadUserDetail()
    }

    private fun loadUserDetailFromServer() {
        if ((activity as MainActivity?)!!.checkInternetConnection(requireContext())) {
            mUserViewModel.loadUserDataFromServer()
        }
    }

    private fun loadUserDetail() {
        mUserViewModel.retrieveData()
            .observe(requireActivity(), Observer<List<UserData>> { userList ->
                userListAdapter.setUserData(userList)
            })
    }

    private fun loadRecycler() {
        layoutManager = LinearLayoutManager(requireContext())
        userListAdapter = UserListAdapter(requireContext(), this)
        binding.userRecyclerView.layoutManager = layoutManager
        binding.userRecyclerView.adapter = userListAdapter
    }

    override fun funUserDetail(userData: UserData?) {
        mUserViewModel.setSelectedUserDetail(userData)
        requireView().findNavController()
            .navigate(R.id.action_userListFragment_to_userDetailFragment)
    }
}
