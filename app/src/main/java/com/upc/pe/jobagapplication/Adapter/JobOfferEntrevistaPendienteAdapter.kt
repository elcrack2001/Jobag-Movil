package com.upc.pe.jobagapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.upc.pe.jobagapplication.Model.JobOffer
import com.upc.pe.jobagapplication.R

class JobOfferEntrevistaPendienteAdapter (
    val joboffers: List<JobOffer>,
    val EmployeerId: Int
    ): RecyclerView.Adapter<JobOfferEntrevistaPendienteAdapter.JobOfferEmpleadorPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobOfferEmpleadorPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_entrevista_pendiente_empleador, parent, false)
        return JobOfferEmpleadorPrototype(view)
    }

    override fun onBindViewHolder(holder: JobOfferEmpleadorPrototype, position: Int) {
        val addItem = joboffers[position]

        if (EmployeerId == addItem.employeer.id){
            holder.tvTitleJobOffer.text = addItem.title
            holder.tvDateJobOffer.text = addItem.final_date_offer
        }else{
            holder.itemView.setVisibility(View.GONE)
        }
    }

    override fun getItemCount(): Int {
        return joboffers.size
    }

    inner class JobOfferEmpleadorPrototype(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvTitleJobOffer = itemView.findViewById<TextView>(R.id.tvTitleJobOffer)
        val tvDateJobOffer = itemView.findViewById<TextView>(R.id.tvDateInterview)
    }

}
