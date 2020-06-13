package app.shigenawa.ass.homerecycler

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_show.view.*

class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    var dateText:TextView?=null
    init {
        dateText=itemView.dateShowText
    }
}