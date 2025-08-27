package com.example.android3

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    private val viewModel: MyViewModel by viewModels()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btn= findViewById<Button>(R.id.btn)
        val txtView=findViewById<TextView>(R.id.txtView)

        viewModel.result.observe(this, Observer {
            txtView.text = it
        })

        btn.setOnClickListener {
           viewModel.startWork()
        }
    }
}