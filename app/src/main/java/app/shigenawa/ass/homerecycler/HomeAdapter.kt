package app.shigenawa.ass.homerecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.realm.OrderedRealmCollection
import io.realm.Realm
import io.realm.RealmRecyclerViewAdapter
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_show.view.*
import java.text.SimpleDateFormat
import java.util.*

class HomeAdapter(
    private val context: Context,
    private var timeList: OrderedRealmCollection<Time>,
    private  val autoUpdate: Boolean
) :
    RealmRecyclerViewAdapter<Time,HomeAdapter.ViewHolder>(timeList,autoUpdate){

    val items:MutableList<HomeData> = mutableListOf()

    //private val rResults:RealmResults<Time>=realmResults

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        var dateText: TextView =view.findViewById(R.id.dateText)
       /* init {
            dateText=view.dateShowText
        }

        */
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

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(context).inflate(R.layout.home_data,viewGroup,false)
        return ViewHolder(v)

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
        return timeList.size
    }


   // override fun getItemCount():Int= mItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val time:Time=timeList?.get(position)?:return
     // //  holder.dataText.text= mHomedata[position].

     //   holder.dateText.setText(time.timeData)

        holder.dateText.text=SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.JAPANESE).format(time.timeData)

      //  holder.dataText.text=mItems[position].timeData

    }


    fun addAll(items:List<Time>){
        this.timeList.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(time: Time){
        timeList.add(time)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int){
        items.removeAt(position)
        notifyItemRemoved(position)
        notifyDataSetChanged()
    }



    /*class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val date:TextView= view.dataText
    }*/

    /*interface OnItemClickListener {
        fun onItemClick(item: Time)
    }

     */

}