package com.upc.pe.jobagapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.upc.pe.jobagapplication.Model.JobOffer
import com.upc.pe.jobagapplication.R

class JobOfferAnunciosEmpleadorAdapter (val joboffers: List<JobOffer>): RecyclerView.Adapter<JobOfferEmpleadorAnuncioPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobOfferEmpleadorAnuncioPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_anuncios_empleador_main, parent, false)
        return JobOfferEmpleadorAnuncioPrototype(view)
    }

    override fun onBindViewHolder(holder: JobOfferEmpleadorAnuncioPrototype, position: Int) {
        holder.bind(joboffers[position])
    }

    override fun getItemCount(): Int {
        return joboffers.size
    }

}

class JobOfferEmpleadorAnuncioPrototype(itemView: View) : RecyclerView.ViewHolder(itemView){
    val tvTittleAnuncioEmpleador = itemView.findViewById<TextView>(R.id.tvTittleAnuncioEmpleador)
    val tvDirectionAnuncioEmpleador = itemView.findViewById<TextView>(R.id.tvDirectionAnuncioEmpleador)
    val tvSueldoAnuncioEmpleador = itemView.findViewById<TextView>(R.id.tvSueldoAnuncioEmpleador)

    fun bind(JobOffer: JobOffer){
        tvTittleAnuncioEmpleador.text = JobOffer.title
        tvDirectionAnuncioEmpleador.text = JobOffer.direction
        tvSueldoAnuncioEmpleador.text = JobOffer.salary.toString()
    }
}