package com.example.android3

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.GridView
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var gridView: GridView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridView = findViewById(R.id.gridView)

        val items = listOf(
            GridItem("Apple", R.drawable.ic_launcher_background),
            GridItem("Banana", R.drawable.ic_launcher_background),
            GridItem("Orange", R.drawable.ic_launcher_background),
            GridItem("Mango", R.drawable.ic_launcher_background),
            GridItem("Grapes", R.drawable.ic_launcher_background),
            GridItem("Pineapple", R.drawable.ic_launcher_background)
        )

        val adapter = GridAdapter(this, items)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { _, _, position, _ ->
            val item = items[position]
            Toast.makeText(this, "Clicked: ${item.name}", Toast.LENGTH_SHORT).show()
        }
    }
}