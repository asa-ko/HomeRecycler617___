package app.shigenawa.ass.homerecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter(private val context: Context ) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>(){
    val items:MutableList<HomeData> = mutableListOf()

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val dataText: TextView =view.findViewById(R.id.dataText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.home_data,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=items[position]
      //  holder.dataText.text= mHomedata[position].

        holder.dataText.setText(item.data)
    }
    fun addAll(items:List<HomeData>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(homeData: HomeData){
        items.add(homeData)
        notifyDataSetChanged()
    }

}