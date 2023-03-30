package com.example.lloydsproject.userModule.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lloydsproject.databinding.UserListAdapterBinding
import com.example.lloydsproject.userModule.interfaces.UserIface
import com.example.lloydsproject.userModule.model.UserData

class UserListAdapter(val context: Context, val iface: UserIface) :
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    private val TAG = UserListAdapter::class.java.simpleName
    private var userList: List<UserData>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            UserListAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text =
            userList?.get(position)?.firstName + " " + userList?.get(position)?.lastName
        holder.emailId.text = userList?.get(position)?.email
        Glide.with(context).load(userList?.get(position)?.avatar).into(holder.imgUser)
        holder.itemView.setOnClickListener(View.OnClickListener {
            iface.funUserDetail(userList?.get(position))
        })
    }

    override fun getItemCount(): Int {
        return userList?.size ?: 0
    }

    fun setUserData(userList: List<UserData>?) {
        this.userList = userList
        notifyDataSetChanged()
    }

    class ViewHolder(binding: UserListAdapterBinding) : RecyclerView.ViewHolder(binding.root) {
        val imgUser = binding.imgUser
        val name = binding.txtName
        val emailId = binding.txtEmailId
    }
}