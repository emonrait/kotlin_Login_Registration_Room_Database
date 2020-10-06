package com.example.kotlinloginregistrationroom.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kotlinloginregistrationroom.R
import com.example.kotlinloginregistrationroom.data.User
import com.example.kotlinloginregistrationroom.data.UserViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_registration.*
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_update, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.updateName.setText(args.currentUser.name)
        view.updateEmail.setText(args.currentUser.email)
        view.updateMobile.setText(args.currentUser.mobile)
        view.updateAddress.setText(args.currentUser.address)
        view.updatePassword.setText(args.currentUser.password)

        view.updatebtn.setOnClickListener {
            updateItem()

        }

        return view
    }

    private fun updateItem() {
        val name = updateName.text.toString()
        val email = updateEmail.text.toString()
        val mobile = updateMobile.text.toString()
        val address = updateAddress.text.toString()
        val password = updatePassword.text.toString()

        if (inputCheck(name, email, mobile, address, password)) {
            val updateUser = User(args.currentUser.id, name, email, mobile, address, password)
            mUserViewModel.updateUser(updateUser)
            Toast.makeText(requireContext(), "Update Successful", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        } else {
            Toast.makeText(
                requireContext(),
                "Update Unsuccessful! Please input data all field",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun inputCheck(
        name: String,
        email: String,
        mobile: String,
        address: String,
        password: String
    ): Boolean {
        return !(name.isEmpty() && email.isEmpty() && mobile.isEmpty() && address.isEmpty() && password.isEmpty())

    }

}