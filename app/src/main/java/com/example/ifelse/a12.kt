package com.example.ifelse

import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class a12 : AppCompatActivity() {
    private lateinit var typingTextView: TextView
    private val typingAnimationHandler = Handler()
    private lateinit var textContent: Array<String>
    private var textIndex: Int = 0
    private var sentenceIndex: Int = 0
    private val characterDelay: Long = 150 // milliseconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a12)
        val backButton = findViewById<Button>(R.id.buttonx)
        backButton.setOnClickListener {
            finish()
        }
        typingTextView = findViewById(R.id.typingTextView2)
        textContent = arrayOf(
            "You are 21, the same age as when Rebecca Schaeffer died. Rebecca Schaeffer was an American actress and model. She gained fame for her role in the television series My Sister Sam. Tragically, her life was cut short when she was murdered by an obsessed fan in 1989. Her death highlighted the need for stricter privacy laws and protection for celebrities."
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