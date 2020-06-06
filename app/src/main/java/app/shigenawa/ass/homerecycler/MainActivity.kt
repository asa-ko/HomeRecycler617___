package app.shigenawa.ass.homerecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.home_data.*

class MainActivity : AppCompatActivity() {

    val HomeData:List<HomeData> = listOf(

        HomeData("6月3日"),
        HomeData("6月2日"),
        HomeData("6月1日"),
        HomeData("5月31"),
        HomeData("5月30"),
        HomeData("5月29"),
        HomeData("5月28"),
        HomeData("5月27"),
        HomeData("5月26"),
        HomeData("5月25"),
        HomeData("5月24"),
        HomeData("5月23")

        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter=HomeAdapter(this)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=adapter

        adapter.addAll(HomeData)

      /*  addButton.setOnClickListener {
            if(!TextUtils.isEmpty((dataText.text.toString()))){
                val task =HomeData()
            }
        }
        
       */
    }



}
