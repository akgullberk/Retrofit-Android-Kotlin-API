package com.example.retrofitkotlin.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitkotlin.R
import com.example.retrofitkotlin.model.CryptoModel

class RecyclerViewAdapter(private val cryptoList : ArrayList<CryptoModel>,private val listener : Listener) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    private val colors : Array<String> = arrayOf("#a300bb","#004b23","#99e65f","#7cc443","#8f4027","#dabdab","#1e202b","#9aadd1")
    interface  Listener{
        fun onItemClick(cryptoModel: CryptoModel)
    }
    class RowHolder(view : View) : RecyclerView.ViewHolder(view) {

        private val textName : TextView = view.findViewById(R.id.text_name)
        private val textPrice : TextView = view.findViewById(R.id.text_price)


        fun bind(cryptoModel: CryptoModel,colors : Array<String>,position: Int, listener : Listener){
            itemView.setOnClickListener {
                listener.onItemClick(cryptoModel)
            }
            itemView.setBackgroundColor(Color.parseColor(colors[position % 8]))
            textName.text = cryptoModel.currency
            textPrice.text = cryptoModel.price


        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
        return RowHolder(view)
    }

    override fun getItemCount(): Int {
        return cryptoList.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {

        holder.bind(cryptoList[position],colors,position,listener)
    }


}