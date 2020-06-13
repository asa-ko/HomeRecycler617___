package app.shigenawa.ass.homerecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.home_data.view.*
import org.intellij.lang.annotations.JdkConstants

class HomeAdapter(private val context: Context ) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>(){
    val items:MutableList<Time> = mutableListOf()

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val dataText: TextView =view.findViewById(R.id.dateText)
    }

    private var mRecyclerView:RecyclerView?=null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mRecyclerView=recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        mRecyclerView=null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.home_data,parent,false)
        return ViewHolder(view)

        /*  val layoutInflater = LayoutInflater.from(context)
          val mView = layoutInflater.inflate(R.layout.home_data, parent, false)

          mView.setOnClickListener { view ->
              mRecyclerView?.let {
                  itemClickListener.onItemClick(view, it.getChildAdapterPosition(view))
              }
          }

          return ViewHolder(mView)

         */
    }

    override fun getItemCount(): Int {
        return items.size
    }


    // override fun getItemCount():Int= mItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=items[position]
        // //  holder.dataText.text= mHomedata[position].

        holder.dataText.setText(item.timeData)


        //  holder.dataText.text=mItems[position].timeData

    }


    fun addAll(items:List<Time>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(time: Time){
        items.add(time)
        notifyDataSetChanged()
    }

    /* fun removeItem(position: Int){
         items.removeAt(position)
         notifyItemRemoved(position)
         notifyDataSetChanged()
     }

     */

    /*class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val date:TextView= view.dataText
    }*/

    /*interface OnItemClickListener {
        fun onItemClick(item: Time)
    }

     */

}