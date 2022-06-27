package com.upc.pe.jobagapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.upc.pe.jobagapplication.Model.JobOffer
import com.upc.pe.jobagapplication.R

class JobOfferAndEmpleadoIdAdapter(val jobOffer: JobOffer) :RecyclerView.Adapter<JobPrototype>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_anuncios_empleador_main, parent, false)
        return JobPrototype(view)
    }

    override fun onBindViewHolder(holder: JobPrototype, position: Int) {
        val addItem = jobOffer

        holder.tvTittleAnuncioEmpleador.text = addItem.title
        holder.tvDirectionAnuncioEmpleador.text = addItem.direction
        holder.tvSueldoAnuncioEmpleador.text = addItem.salary.toString()
    }

    override fun getItemCount(): Int {
        return jobOffer.id;
    }

}

class JobPrototype (itemView: View): RecyclerView.ViewHolder(itemView){
    val tvTittleAnuncioEmpleador = itemView.findViewById<TextView>(R.id.tvTittleAnuncioEmpleador)
    val tvDirectionAnuncioEmpleador = itemView.findViewById<TextView>(R.id.tvDirectionAnuncioEmpleador)
    val tvSueldoAnuncioEmpleador = itemView.findViewById<TextView>(R.id.tvSueldoAnuncioEmpleador)
}