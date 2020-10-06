package com.example.kotlinloginregistrationroom.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinloginregistrationroom.R
import com.example.kotlinloginregistrationroom.data.User
import kotlinx.android.synthetic.main.fragment_update.view.*
import kotlinx.android.synthetic.main.list_item.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var userlist = emptyList<User>()


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userlist[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.name_txt.text = currentItem.name.toString()
        holder.itemView.email_txt.text = currentItem.email.toString()
        holder.itemView.mobile_txt.text = currentItem.mobile.toString()
        holder.itemView.address_txt.text = currentItem.address.toString()
        holder.itemView.password_txt.text = currentItem.password.toString()
        holder.itemView.rowLayout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)

        }
    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    fun setData(user: List<User>) {
        this.userlist = user
        notifyDataSetChanged()

    }
}