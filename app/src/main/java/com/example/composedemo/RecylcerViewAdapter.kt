package com.example.composedemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


open class RecylcerViewAdapter (
    context: Context,
    ResponseModelList: List<ResponseModel>
) :
    RecyclerView.Adapter<RecylcerViewAdapter.MyViewHolder?>(), Filterable {
    private val context: Context
    private val ResponseModelList: List<ResponseModel>
    private var ResponseModelListFiltered: List<ResponseModel>

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvTitle: TextView
        var tvBy: TextView
        var tvNumberOfBakers: TextView

        init {
            tvTitle = view.findViewById(R.id.tvTitle)
            tvBy = view.findViewById(R.id.tvBy)
            tvNumberOfBakers = view.findViewById(R.id.tvNumberOfBakers)
        }
    }
override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_row_item, parent, false)
        return MyViewHolder(itemView)
    }

    override
    fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val ResponseModel: ResponseModel = ResponseModelListFiltered[position]
        holder.tvTitle.setText(ResponseModel.title)
        holder.tvBy.setText(ResponseModel.by)
        holder.tvNumberOfBakers.setText(ResponseModel.numBackers)

    }

    override fun getItemCount(): Int {
       return ResponseModelListFiltered.size
    }

    // name match condition. this might differ depending on your requirement
// here we are looking for name or phone number match
    /*val filter: Filter
        get() = object : Filter() {
            override
             fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()
                ResponseModelListFiltered = if (charString.isEmpty()) {
                    ResponseModelList
                } else {
                    val filteredList: MutableList<ResponseModel> = ArrayList()
                    for (row in ResponseModelList) { // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.title.toLowerCase().contains(charString.toLowerCase()) || row.title.contains(
                                charSequence
                            )
                        ) {
                            filteredList.add(row)
                        }
                    }
                    filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = ResponseModelListFiltered
                return filterResults
            }

            override
             fun publishResults(
                charSequence: CharSequence?,
                filterResults: FilterResults
            ) {
                ResponseModelListFiltered = filterResults.values as List<ResponseModel>
                notifyDataSetChanged()
            }
        }*/


    init {
        this.context = context
        this.ResponseModelList = ResponseModelList
        ResponseModelListFiltered = ResponseModelList
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override
            fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()
                ResponseModelListFiltered = if (charString.isEmpty()) {
                    ResponseModelList
                } else {
                    val filteredList: MutableList<ResponseModel> = ArrayList()
                    for (row in ResponseModelList) { // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.title.toLowerCase().contains(charString.toLowerCase()) || row.title.contains(
                                charSequence
                            )
                        ) {
                            filteredList.add(row)
                        }
                    }
                    filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = ResponseModelListFiltered
                return filterResults
            }

            override
            fun publishResults(
                charSequence: CharSequence?,
                filterResults: FilterResults
            ) {
                ResponseModelListFiltered = filterResults.values as List<ResponseModel>
                notifyDataSetChanged()
            }
        }
    }
}