package com.upc.pe.jobagapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.upc.pe.jobagapplication.Model.JobOffer
import com.upc.pe.jobagapplication.R

class JobOfferAnunciosEmpleadorAdapter (
    val joboffers: List<JobOffer>,
    val listener: OnItemClickListener,
    val EmployeerId: Int
    ): RecyclerView.Adapter<JobOfferAnunciosEmpleadorAdapter.JobOfferEmpleadorAnuncioPrototype>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobOfferEmpleadorAnuncioPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_anuncios_empleador_main, parent, false)
        return JobOfferEmpleadorAnuncioPrototype(view)
    }

    override fun onBindViewHolder(holder: JobOfferEmpleadorAnuncioPrototype, position: Int) {
        val addItem = joboffers[position]

        if (EmployeerId == addItem.employeer.id){
            holder.tvTittleAnuncioEmpleador.text = addItem.title
            holder.tvDirectionAnuncioEmpleador.text = addItem.direction
            holder.tvSueldoAnuncioEmpleador.text = addItem.salary.toString()
        } else{
            holder.itemView.setVisibility(View.GONE)
        }
    }

    override fun getItemCount(): Int {
        return joboffers.size
    }

    inner class JobOfferEmpleadorAnuncioPrototype(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener{
        val tvTittleAnuncioEmpleador = itemView.findViewById<TextView>(R.id.tvTittleAnuncioEmpleador)
        val tvDirectionAnuncioEmpleador = itemView.findViewById<TextView>(R.id.tvDirectionAnuncioEmpleador)
        val tvSueldoAnuncioEmpleador = itemView.findViewById<TextView>(R.id.tvSueldoAnuncioEmpleador)

        init {
            itemView.setOnClickListener(this)
        }

        //Ctrl + I
        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.OnItemClick(position)
            }
        }
    }
}

interface OnItemClickListener{
    fun OnItemClick(position: Int)
}