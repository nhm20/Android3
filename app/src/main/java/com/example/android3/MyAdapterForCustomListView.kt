package com.example.android3

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MyAdapterForCustomListView(
    var mCtx: Context, var resources: Int,
    var items: MutableList<MyItem>
) : ArrayAdapter<MyItem>(mCtx, resources, items) {


    override fun getView(
        position: Int, convertView: View?,
        parent: ViewGroup
    ): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resources, null)

        val imageView: ImageView = view.findViewById(R.id.im1)
        val titleTextView: TextView = view.findViewById(R.id.textView1)
        val descriptionTextView: TextView = view.findViewById(R.id.textView2)
        val delete: Button = view.findViewById(R.id.delete)

        val mItem = items[position]
        //imageView.setImageDrawable(mCtx.resources.getDrawable(mItem.img))

        imageView.setImageURI(Uri.parse(mItem.img.toString()))
        titleTextView.text = mItem.title
        descriptionTextView.text = mItem.subTitle

        delete.setOnClickListener {
            items.removeAt(position)
            notifyDataSetChanged()
        }
        return view
    }
}