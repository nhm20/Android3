package com.example.android3

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BoundUnBoundServiceExample : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bound_un_bound_service_example)

        val resultText = findViewById<TextView>(R.id.resultText)
        val btnBound = findViewById<Button>(R.id.btnBound)
        val btnUnbound = findViewById<Button>(R.id.btnUnbound)
        val btnForeground = findViewById<Button>(R.id.btnForeground)

        btnBound.setOnClickListener {
            resultText.text = """
                ✅ Bound Service:
                - Allows components (like activities) to bind and interact with the service.
                - Provides client-server interface for communication.
                - Stops automatically when no component is bound.
            """.trimIndent()
        }

        btnUnbound.setOnClickListener {
            resultText.text = """
                ✅ Unbound Service:
                - Started with startService() or startForegroundService().
                - Runs in the background indefinitely until stopped manually.
                - Does not return a result to the caller.
            """.trimIndent()
        }

        btnForeground.setOnClickListener {
            resultText.text = """
                ✅ Foreground Service:
                - Runs in the foreground with a visible notification.
                - Used for tasks that must continue (e.g., music playback, fitness tracking).
                - Less likely to be killed by the system.
            """.trimIndent()
        }
    }
}