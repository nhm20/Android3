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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        val items = listOf(
            MyItem("Apple", R.drawable.ic_launcher_foreground),
            MyItem("Banana", R.drawable.ic_launcher_foreground),
            MyItem("Orange", R.drawable.ic_launcher_foreground),
            MyItem("Mango", R.drawable.ic_launcher_foreground),
            MyItem("Grapes", R.drawable.ic_launcher_foreground)
        )

        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = MyAdapter(items) { item ->
            Toast.makeText(this, "Clicked: ${item.name}", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter
    }
}