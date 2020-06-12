package app.shigenawa.ass.homerecycler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.home_data.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    val realm: Realm = Realm.getDefaultInstance()

    val DataFormat  = SimpleDateFormat("yyyy/MM/dd").format(Date())
   // val dateText=intent.getStringExtra("date")
    //val date1=dateText.toString()
   // val time:Time?=read()
     //   val todayDate: String? = time.timeData


    val Time:List<Time> = listOf(

        Time()

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
    /*val HomeData:List<HomeData> = listOf(
            HomeData(DataFormat)
    )
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dateText=intent.getStringExtra("date")


        val adapter=HomeAdapter( this)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=adapter

        adapter.addAll(Time)

       addButton.setOnClickListener {

           val registerPage = Intent(this, RegisterActivity::class.java)
           startActivity(registerPage)
           finish()

           val task = Time(timeData = DataFormat.toString())
           adapter.addItem(task)

           //    Snackbar.make(addButton, "Content is empty", Snackbar.LENGTH_SHORT).show()

       }

       /* button3.setOnClickListener {
            val ShowPage=Intent(this,ShowActivity::class.java)
            startActivity(ShowPage)
            finish()
        }
        */

       /* deleteText.setOnClickListener{
           // adapter.removeItem(-1)
        }
        */
    }
    fun read():Time?{
        return realm.where(app.shigenawa.ass.homerecycler.Time::class.java).findFirst()
    }


}




