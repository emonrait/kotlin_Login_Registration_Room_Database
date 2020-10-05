package com.example.kotlinloginregistrationroom.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kotlinloginregistrationroom.R
import com.example.kotlinloginregistrationroom.data.User
import com.example.kotlinloginregistrationroom.data.UserViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_registration.*
import kotlinx.android.synthetic.main.fragment_registration.view.*


class RegistrationFragment : Fragment() {
    private lateinit var muserViewModel: UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_registration, container, false)
        muserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.LoginLink.setOnClickListener {
            findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
        }

        view.Register.setOnClickListener {
            insertDatatoDatabase()

        }
        return view
    }

    private fun insertDatatoDatabase() {
        val name = textInputEditTextName.text.toString()
        val email = textInputEditTextEmail.text.toString()
        val mobile = textInputEditTextMobile.text.toString()
        val address = textInputEditTextAddress.text.toString()
        val password = textInputEditTextPassword.text.toString()

        if (inputCheck(name, email, mobile, address, password)) {
            val user = User(0, name, email, mobile, address, password)
            muserViewModel.addUser(user)
            Snackbar.make(scrollView, "Registration Successful", Snackbar.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
        } else {
            Snackbar.make(scrollView, "Registration Unsuccessful! Please input data all field", Snackbar.LENGTH_LONG).show()
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