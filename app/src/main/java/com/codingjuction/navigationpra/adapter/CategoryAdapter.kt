package com.codingjuction.navigationpra.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codingjuction.navigationpra.R
import com.codingjuction.navigationpra.activity.MainActivity
import com.codingjuction.navigationpra.model.CategoryModel
import com.squareup.picasso.Picasso

class CategoryAdapter(var context : Context?, var list : List<CategoryModel>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cardview_categories, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val c = list.get(p1)
        p0.mtxt.text = c.name
        Picasso.get().load(c.image).into(p0.mImg)
    }


    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!), View.OnClickListener {
        override fun onClick(v: View?) {
            val p = adapterPosition
            val ca = list[p]

            //I have put mainactivity for demo purpose, in the real app, I have put another new activity
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra("catname", ca.name)
            context!!.startActivity(intent)
        }

        var mtxt : TextView = itemView!!.findViewById(R.id.title)
        var mImg : ImageView = itemView!!.findViewById(R.id.image)

        init{
            itemView!!.setOnClickListener(this)
        }
    }
}