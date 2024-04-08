package com.example.ifelse

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.blob)
        val numberEditText = findViewById<EditText>(R.id.bobs)
        val clearButton = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val userInput = numberEditText.text.toString().toIntOrNull()
            if (userInput != null) {
                val nextActivityIntent = Intent(this, Tempo::class.java)
                nextActivityIntent.putExtra("next_activity", when (userInput) {
                    14 -> a5::class.java
                    16 -> a6::class.java
                    15 -> a7::class.java
                    17 -> a8::class.java
                    18 -> a9::class.java
                    19 -> a10::class.java
                    20 -> a11::class.java
                    21 -> a12::class.java
                    22 -> a13::class.java
                    23 -> a14::class.java
                    24 -> a15::class.java
                    25 -> a16::class.java
                    26 -> a17::class.java
                    27 -> a18::class.java
                    28 -> a19::class.java
                    29 -> a20::class.java
                    30 -> a21::class.java
                    31 -> a22::class.java
                    32 -> a23::class.java
                    33 -> a24::class.java
                    34 -> a25::class.java
                    35 -> a26::class.java
                    36 -> a27::class.java
                    37 -> a28::class.java
                    38 -> a29::class.java
                    39 -> a30::class.java
                    40 -> a31::class.java
                    41 -> a32::class.java
                    42 -> a33::class.java
                    43 -> a34::class.java
                    44 -> a35::class.java
                    45 -> a36::class.java
                    46 -> a37::class.java
                    47 -> a38::class.java
                    48 -> a39::class.java
                    49 -> a40::class.java
                    50 -> a41::class.java
                    51 -> a42::class.java
                    52 -> a43::class.java
                    53 -> a44::class.java
                    54 -> a45::class.java
                    55 -> a46::class.java
                    56 -> a47::class.java
                    57 -> a48::class.java
                    58 -> a49::class.java
                    59 -> a50::class.java
                    60 -> a51::class.java
                    61 -> a52::class.java
                    62 -> a53::class.java
                    63 -> a54::class.java
                    64 -> a55::class.java
                    65 -> a56::class.java
                    66 -> a57::class.java
                    67 -> a58::class.java
                    68 -> a59::class.java
                    69 -> a60::class.java
                    70 -> a61::class.java
                    71 -> a62::class.java
                    72 -> a63::class.java
                    73 -> a64::class.java
                    74 -> a65::class.java
                    75 -> a66::class.java
                    76 -> a67::class.java
                    77 -> a68::class.java
                    78 -> a69::class.java
                    79 -> a70::class.java
                    80 -> a71::class.java
                    81 -> a72::class.java
                    82 -> a73::class.java
                    83 -> a74::class.java
                    84 -> a75::class.java
                    85 -> a76::class.java
                    86 -> a77::class.java
                    87 -> a78::class.java
                    88 -> a79::class.java
                    89 -> a80::class.java
                    90 -> a81::class.java
                    91 -> a82::class.java
                    92 -> a83::class.java
                    93 -> a84::class.java
                    94 -> a85::class.java
                    95 -> a86::class.java
                    else -> null
                })
                if (nextActivityIntent.getSerializableExtra("next_activity") != null) {
                    startActivity(nextActivityIntent)
                } else {
                    Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show()
            }
        }

        clearButton.setOnClickListener {
            numberEditText.text.clear() // Clears the EditText view
        }
    }
}

// TemporaryActivity.kt



