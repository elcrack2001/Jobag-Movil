package com.upc.pe.jobagapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.upc.pe.jobagapplication.Model.Interview
import com.upc.pe.jobagapplication.R

class InterviewEmpleadorAdapter (val interviews: List<Interview>): RecyclerView.Adapter<InterviewEmpleadorPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InterviewEmpleadorPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_entrevista_pendiente_empleador, parent, false)
        return InterviewEmpleadorPrototype(view)
    }

    override fun onBindViewHolder(holder: InterviewEmpleadorPrototype, position: Int) {
        holder.bind(interviews[position])
    }

    override fun getItemCount(): Int {
        return interviews.size
    }

}

class InterviewEmpleadorPrototype(itemView: View) : RecyclerView.ViewHolder(itemView){
    val tvTitleJobOffer = itemView.findViewById<TextView>(R.id.tvTitleJobOffer)
    val tvDateInterview = itemView.findViewById<TextView>(R.id.tvDateInterview)
    val tvLink = itemView.findViewById<TextView>(R.id.tvLink)

    fun bind(interview: Interview){
        tvTitleJobOffer.text = interview.id.toString()
        tvDateInterview.text = interview.link_Interview
        tvLink.text = interview.final_date_Interview
    }
}