package com.example.ifelse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Tempo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tempo)
        // Use a Handler to delay the start of the next activity
        Handler(Looper.getMainLooper()).postDelayed({
            // Start the next activity based on the intent extra
            val nextActivityClass = intent.getSerializableExtra("next_activity") as Class<*>
            startActivity(Intent(this, nextActivityClass))
            finish() // Close the TemporaryActivity
        }, 10000) // 10 seconds delay
    }
    }
