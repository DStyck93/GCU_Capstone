package com.dstyx.health_app.scenes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dstyx.health_app.R

class CreateAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_account)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Create Account Button
        val createAccountBtn = findViewById<Button>(R.id.createAccount_createButton)
        createAccountBtn.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }

        // Cancel Button
        val cancelBtn = findViewById<Button>(R.id.createAccount_cancel)
        cancelBtn.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }
    }
}