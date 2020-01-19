package com.example.projet.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projet.R
import com.example.projet.data.models.Revenue
import kotlinx.android.synthetic.main.item_revenue.view.*

class RevenueAdapter constructor(
    private val onRevenueSelected:
        (Revenue) -> Unit
) :
    RecyclerView.Adapter<RevenueAdapter.RevenueCellViewHolder>() {
    private val revenue: MutableList<Revenue> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RevenueCellViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_revenue,
            parent,
            false
        )
        return RevenueCellViewHolder(view)
    }

    override fun getItemCount(): Int {
        return revenue.size
    }

    fun addRevenues(revenues: List<Revenue>) {
        this.revenue.addAll(revenues)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RevenueCellViewHolder, position: Int) {
        val card = revenue[position]
        holder.bind(card, onRevenueSelected)
    }

    class RevenueCellViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(revenue: Revenue, listener: (Revenue) -> Unit) = with(itemView) {
            tv_cin.text = "${context.resources.getString(R.string.cin)}  : ${revenue.cin}"
            tv_name_person.text = "${context.resources.getString(R.string.name)} : ${revenue.namePerson}"
            tv_type.text = "${context.resources.getString(R.string.type)} ${revenue.type}"
            tv_desc.text = "${context.resources.getString(R.string.description)} ${revenue.description}"
            tv_amount.text = "${context.resources.getString(R.string.amount)} ${revenue.amount.toString()} DT"
            itemView.setOnClickListener { listener.invoke(revenue) }
        }
    }
}