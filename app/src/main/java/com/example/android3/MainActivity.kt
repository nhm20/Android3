package com.example.android3

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        listView=findViewById(R.id.listView)
        val items = listOf(
            MyItem("Android App", "This is Android", R.drawable.img_1),
            MyItem("IOS App", "This is IOS", R.drawable.img),
            MyItem("Web App", "This is Web", R.drawable.img_2)
        )

        val adapter=MyAdapter(this, items)
        listView.adapter = adapter

        listView.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val item = items[position]
                Toast.makeText(this@MainActivity, "Clicked ${item.title}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}