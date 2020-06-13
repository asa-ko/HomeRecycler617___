package app.shigenawa.ass.homerecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import kotlinx.android.synthetic.main.home_data.view.*
import org.intellij.lang.annotations.JdkConstants

class HomeAdapter(
    private val context: Context,
    private val taskList:OrderedRealmCollection<Time>,
    private val autoUpdate: Boolean
) :
    RealmRecyclerViewAdapter<Time,HomeAdapter.ViewHolder>(taskList,autoUpdate){
    //val items:MutableList<Time> = mutableListOf()

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=taskList[position]
        // //  holder.dataText.text= mHomedata[position].
        holder.dataText.setText(item.timeData)
        //  holder.dataText.text=mItems[position].timeData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.home_data,parent,false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val dataText: TextView =view.findViewById(R.id.dateText)
    }

    fun addAll(taskList: OrderedRealmCollection<Time>){
        this.taskList.addAll(taskList)
        notifyDataSetChanged()
    }

    fun addItem(time: Time){
        taskList.add(time)
        notifyDataSetChanged()
    }



    /*
    private var mRecyclerView:RecyclerView?=null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mRecyclerView=recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        mRecyclerView=null
    }

     */


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