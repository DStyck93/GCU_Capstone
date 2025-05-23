package com.dstyx.health_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Login Button Click
        val loginBtn = findViewById<Button>(R.id.loginButton)
        loginBtn.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }

        // Create Account Button Click
        val createAccountBtn = findViewById<Button>(R.id.login_createAccountBtn)
        createAccountBtn.setOnClickListener {
            startActivity(Intent(this, CreateAccount::class.java))
        }
    }
}

