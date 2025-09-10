package com.example.android3

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var et1: EditText
    lateinit var et2:EditText
    lateinit var add: Button
    private lateinit var imageView: ImageView
    private var selectedImageUri: Uri? = null

    private val PICK_IMAGE = 1


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listView=findViewById<ListView>(R.id.listView)

        var list= mutableListOf<MyItem>()
        et1=findViewById(R.id.et1)
        et2=findViewById(R.id.et2)
        add=findViewById(R.id.add)
        imageView = findViewById(R.id.im2)

        var ad= MyAdapterForCustomListView(
            this, R.layout.custom_list_view, list)
        listView.adapter=ad

        imageView.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            startActivityForResult(intent, PICK_IMAGE)
        }

        add.setOnClickListener {
            selectedImageUri?.let { list.add(MyItem(et1.text.toString(),et2.text.toString(), it))
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
                ad.notifyDataSetChanged()
            } ?: run {
                Toast.makeText(this, "Please select an image first",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            selectedImageUri = data?.data
            selectedImageUri?.let {
                val bitmap: Bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver
                    , it)
                imageView.setImageBitmap(bitmap)
            }
        }
    }
}