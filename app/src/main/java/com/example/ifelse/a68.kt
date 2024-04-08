package com.example.ifelse

import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class a68 : AppCompatActivity() {
    private lateinit var typingTextView: TextView
    private val typingAnimationHandler = Handler()
    private lateinit var textContent: Array<String>
    private var textIndex: Int = 0
    private var sentenceIndex: Int = 0
    private val characterDelay: Long = 150 // milliseconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a68)
        val backButton = findViewById<Button>(R.id.buttonx)
        backButton.setOnClickListener {
            finish()
        }
        typingTextView = findViewById(R.id.typingTextView2)
        textContent = arrayOf(
            "You are 77, the same age as when Galileo Galilei, the pioneering astronomer, departed. Galileo's observations with the telescope confirmed the heliocentric model of the solar system. His defiance of dogma and commitment to empirical evidence laid the groundwork for modern science."
        )

        startTypingAnimation()
    }

    private fun startTypingAnimation() {
        textIndex = 0
        sentenceIndex = 0
        typingTextView.text = ""
        typingAnimationHandler.removeCallbacksAndMessages(null)
        typingAnimationHandler.postDelayed(object : Runnable {
            override fun run() {
                if (sentenceIndex < textContent.size) {
                    if (textIndex <= textContent[sentenceIndex].length) {
                        typingTextView.text = textContent[sentenceIndex].substring(0, textIndex++)
                        typingAnimationHandler.postDelayed(this, characterDelay)
                    } else {
                        sentenceIndex++
                        textIndex = 0
                        if (sentenceIndex < textContent.size) {
                            typingTextView.append("\n") // Add a new line before starting the next sentence
                        }
                    }
                }
            }
        }, characterDelay)
    }
}