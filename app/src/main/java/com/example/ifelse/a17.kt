package com.example.ifelse

import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class a17 : AppCompatActivity() {
    private lateinit var typingTextView: TextView
    private val typingAnimationHandler = Handler()
    private lateinit var textContent: Array<String>
    private var textIndex: Int = 0
    private var sentenceIndex: Int = 0
    private val characterDelay: Long = 150 // milliseconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a17)
        val backButton = findViewById<Button>(R.id.buttonx)
        backButton.setOnClickListener {
            finish()
        }
        typingTextView = findViewById(R.id.typingTextView2)
        textContent = arrayOf(
            "You are 26, the same age as when Jean Harlow died. Jean Harlow was a glamorous American actress and sex symbol during the Golden Age of Hollywood. Known for her platinum blonde hair and sultry on-screen persona, she starred in films like Dinner at Eight and Red Dust. Her untimely death in 1937 at the age of 26 left a void in Hollywood."
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