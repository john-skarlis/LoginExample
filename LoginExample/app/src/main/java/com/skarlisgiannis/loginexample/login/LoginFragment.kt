package com.skarlisgiannis.loginexample.login

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.skarlisgiannis.loginexample.R
import com.skarlisgiannis.loginexample.model.LoginPost
import com.skarlisgiannis.loginexample.model.LoginResponse
import com.skarlisgiannis.loginexample.viewModel.MainViewModel
import com.skarlisgiannis.loginexample.viewModel.MainViewModelFactory
import com.skarlisgiannis.loginexample.repository.Repository


class LoginFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_login, container, false)

        val emailTXT: EditText = view.findViewById(R.id.EmailText)
        val passwordTXT: EditText = view.findViewById(R.id.PasswordText)
        val result: TextView = view.findViewById(R.id.resultTextView)
        val loginBtn: Button = view.findViewById(R.id.LoginButton)
        val showBtn: Button = view.findViewById(R.id.showBtn)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)



        loginBtn.setOnClickListener {

            viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
            val myPost = LoginPost(emailTXT.text.toString(), passwordTXT.text.toString())
            viewModel.login(myPost)
            viewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
                if (response.isSuccessful) {
                    var loginResponse: LoginResponse? = response.body()
                    result.setText("Success Login " + "\n" + "Login token: " + loginResponse?.token)
                } else {
                    result.setText("Wrong credentials" + "\n" + "Please try again")
                }
            })
        }


        showBtn.setOnClickListener {
            if (showBtn.text.toString().equals("Show")) {
                passwordTXT.transformationMethod = HideReturnsTransformationMethod.getInstance()
                showBtn.text = "Hide"
            } else {
                passwordTXT.transformationMethod = PasswordTransformationMethod.getInstance()
                showBtn.text = "Show"
            }
        }

        return view
    }


}

