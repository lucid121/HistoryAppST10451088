package com.example.ifelse

import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class a56 : AppCompatActivity() {
    private lateinit var typingTextView: TextView
    private val typingAnimationHandler = Handler()
    private lateinit var textContent: Array<String>
    private var textIndex: Int = 0
    private var sentenceIndex: Int = 0
    private val characterDelay: Long = 150 // milliseconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a56)
        val backButton = findViewById<Button>(R.id.buttonx)
        backButton.setOnClickListener {
            finish()
        }
        typingTextView = findViewById(R.id.typingTextView2)
        textContent = arrayOf(
            "You are 65, the same age as when Johann Sebastian Bach died. Bach was a German composer and musician of the Baroque period. His works, such as the Brandenburg Concertos, Mass in B minor, and The Art of Fugue, remain influential. His genius spanned multiple disciplines, making him a true Renaissance man."
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