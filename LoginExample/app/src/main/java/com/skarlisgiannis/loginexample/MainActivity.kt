package com.skarlisgiannis.loginexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.skarlisgiannis.loginexample.login.LoginFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, LoginFragment()).commit()
    }
}