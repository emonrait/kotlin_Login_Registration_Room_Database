package com.example.kotlinloginregistrationroom.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlinloginregistrationroom.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_registration.*


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_login, container, false)

        view.register.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }

        view.login.setOnClickListener {
            val email = Email.text.toString()
            val password = Password.text.toString()
            if (inputCheck(email, password)) {
                Snackbar.make(scrollview5, "Login Successful", Snackbar.LENGTH_LONG).show()
                Email.setText("")
                Password.setText("")

                findNavController().navigate(R.id.action_loginFragment_to_listFragment)

            } else {
                Snackbar.make(
                    scrollview5,
                    "Registration Unsuccessful! Please input Email & Password",
                    Snackbar.LENGTH_LONG
                ).show()
            }


        }

        return view
    }

    private fun inputCheck(email: String, password: String): Boolean {
        return !(email.isEmpty() && password.isEmpty())

    }

}