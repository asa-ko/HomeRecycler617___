package app.shigenawa.ass.homerecycler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.home_data.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    val DataFormat  = SimpleDateFormat("yyyy/MM/dd").format(Date())
   // val dateText=intent.getStringExtra("date")
    //val date1=dateText.toString()

    val Time:List<Time> = listOf(

        Time(DataFormat)

     /*  HomeData("6月3日"),
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

      */




        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //  val dateText=intent.getStringExtra("date")

        val adapter=HomeAdapter(this)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=adapter

        adapter.addAll(Time)

       addButton.setOnClickListener {
           if(!TextUtils.isEmpty((dataText.text.toString()))){
                val task =Time(timeData=dataText.text.toString())
               adapter.addItem(task)
            }else{
               Snackbar.make(addButton, "Content is empty", Snackbar.LENGTH_SHORT).show()
           }



          val registerPage=Intent(this,RegisterActivity::class.java)
           startActivity(registerPage)
           finish()

         
        }


    }



}
