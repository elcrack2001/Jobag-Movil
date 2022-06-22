package com.upc.pe.jobagapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.upc.pe.jobagapplication.Model.JobOffer
import com.upc.pe.jobagapplication.R

class JobOfferEntrevistaPendienteAdapter (val joboffers: List<JobOffer>): RecyclerView.Adapter<JobOfferEmpleadorPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobOfferEmpleadorPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_entrevista_pendiente_empleador, parent, false)
        return JobOfferEmpleadorPrototype(view)
    }

    override fun onBindViewHolder(holder: JobOfferEmpleadorPrototype, position: Int) {
        holder.bind(joboffers[position])
    }

    override fun getItemCount(): Int {
        return joboffers.size
    }

}

class JobOfferEmpleadorPrototype(itemView: View) : RecyclerView.ViewHolder(itemView){
    val tvTitleJobOffer = itemView.findViewById<TextView>(R.id.tvTitleJobOffer)
    val tvDateJobOffer = itemView.findViewById<TextView>(R.id.tvDateInterview)

    fun bind(JobOffer: JobOffer){
        tvTitleJobOffer.text = JobOffer.title
        tvDateJobOffer.text = JobOffer.final_date_offer
    }
}