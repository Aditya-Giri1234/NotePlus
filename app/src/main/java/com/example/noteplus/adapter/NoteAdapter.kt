package com.example.noteplus.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteplus.Entity.Notes
import com.example.noteplus.R

class NoteAdapter (private var list:List<Notes>): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    class ViewHolder(var view: View):RecyclerView.ViewHolder(view) {
        val tvTitle=view.findViewById<TextView>(R.id.tvTitle)
        val tvDesc=view.findViewById<TextView>(R.id.tvDesc)
        val tvDateTime=view.findViewById<TextView>(R.id.tvDateTime)
        val cardview=view.findViewById<CardView>(R.id.cardView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note,parent,false))
    }

    override fun onBindViewHolder(holder: NoteAdapter.ViewHolder, position: Int) {
       holder.tvTitle.text=list[position].title
       holder.tvDesc.text=list[position].noteText
       holder.tvDateTime.text=list[position].dateTime
        if(list[position].color!=null){
            holder.cardview.setCardBackgroundColor(Color.parseColor(list[position].color))
        }
        else{
            holder.cardview.setCardBackgroundColor(Color.parseColor(R.color.colorLightBlack.toString()))
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}