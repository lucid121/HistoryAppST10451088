package com.example.ifelse

import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class a25 : AppCompatActivity() {
    private lateinit var typingTextView: TextView
    private val typingAnimationHandler = Handler()
    private lateinit var textContent: Array<String>
    private var textIndex: Int = 0
    private var sentenceIndex: Int = 0
    private val characterDelay: Long = 150 // milliseconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a25)
        val backButton = findViewById<Button>(R.id.buttonx)
        backButton.setOnClickListener {
            finish()
        }
        typingTextView = findViewById(R.id.typingTextView2)
        textContent = arrayOf(
            "You are 34 the same age as when Bessie Coleman died. Bessie Coleman, an American aviator, defied racial and gender barriers to become one of the first black women to earn a pilot’s license. She staged the first public flight by an African American woman in America and encouraged interest in aviation among black communities. Despite facing discrimination, Coleman’s legacy inspires generations of aspiring aviators."
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