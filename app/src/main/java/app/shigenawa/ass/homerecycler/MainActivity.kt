package app.shigenawa.ass.homerecycler

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import io.realm.Realm
import io.realm.RealmResults
import io.realm.Sort
import io.realm.kotlin.createObject
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.home_data.*
import java.text.FieldPosition
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

   private val realm: Realm by lazy {
       Realm.getDefaultInstance()
   }

   val DateFormat  = SimpleDateFormat("yyyy/MM/dd", Locale.JAPAN).format(Date())
   // var DateFormat:String="aaa"

    // val dateText=intent.getStringExtra("date")
    //val date1=dateText.toString()
    // val time:Time?=read()
    //   val todayDate: String? = time.timeData


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dateText=intent.getStringExtra("date")

  //      val time:Time?=read()
       /* if(time!=null){
            DateFormat=time.timeData
        }

        */

        val taskList=readAll()

/*
        if(taskList.isEmpty()){
            create(DateFormat)
        }

 */


        val adapter =
            HomeAdapter(this, taskList,
                object : HomeAdapter.OnItemClickListener {
                override fun onItemClick(item: Time) {
                    // クリック時の処理
                    Toast.makeText(applicationContext, item.timeData + "を削除しました", Toast.LENGTH_SHORT).show()
                    delete(item.id)
                }
            }, true,
            object : HomeAdapter.OnButtonClickListener{
              override fun Transition(item: Time,position:Int) {
               //     override fun Transition(item: Time) {
                    Toast.makeText(applicationContext,item.timeData+"を表示します",Toast.LENGTH_SHORT).show()

                    val turn:Int=position
                    //val ratingValueString1:String=item.ratingValue1.toString()
                   // val ratingValueString2:String=item.ratingValue2.toString()
                   // val dateString:String=item.timeData.toString()
                   // val uriString:String=item.uri.toString()
                   // trans(dateString,uriString,ratingValueString1,ratingValueString2,item.id)
                   transPosition(position)
                }
            })

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=adapter

      // adapter.addAll(taskList)

        addButton.setOnClickListener {

          //  create(DateFormat)
            Toast.makeText(applicationContext,DateFormat+"を追加",Toast.LENGTH_SHORT).show()

           val registerPage = Intent(this, RegisterActivity::class.java)
            registerPage.putExtra("today",DateFormat)
            startActivity(registerPage)
            finish()

           /* if(DateFormat.toInt()%2==0){
            itemConstrainLayout.setBackgroundColor(Color.rgb(195,253,255))
        }

            */


        //  val task = Time(timeData = DataFormat.toString())
         //   adapter.addItem(task)



            //    Snackbar.make(addButton, "Content is empty", Snackbar.LENGTH_SHORT).show()

        }

    }

    fun create(content:String){
        realm.executeTransaction {
            val task=it.createObject(Time::class.java,UUID.randomUUID().toString())
            task.timeData=content
        }
    }

    fun readAll(): RealmResults<Time> {
        return realm.where(Time::class.java).findAll().sort("timeData", Sort.DESCENDING)
    }

    fun update(id: String, content: String) {
        realm.executeTransaction {
            val task = realm.where(Time::class.java).equalTo("id", id).findFirst()
                ?: return@executeTransaction
            task.timeData = content
        }
    }

    fun update(task: Time, content: String) {
        realm.executeTransaction {
            task.timeData = content
        }
    }

    fun delete(id: String) {
        realm.executeTransaction {
            val task = realm.where(Time::class.java).equalTo("id", id).findFirst()
                ?: return@executeTransaction
            task.deleteFromRealm()
        }
    }

    fun delete(task: Time) {
        realm.executeTransaction {
            task.deleteFromRealm()
        }
    }

    fun deleteAll() {
        realm.executeTransaction {
            realm.deleteAll()
        }
    }

    fun read():Time?{
        return realm.where(app.shigenawa.ass.homerecycler.Time::class.java).findFirst()
    }

    fun trans(date:String,uri:String,value1:String,value2:String,id: String){
        val DataPage=Intent(this,DataShowActivity::class.java)
        DataPage.putExtra("date",date)
        DataPage.putExtra("uri",uri)
        DataPage.putExtra("value1",value1)
        DataPage.putExtra("value2",value2)
        DataPage.putExtra("id",id)
        startActivity(DataPage)
        finish()
    }

    fun transPosition(position: Int){
        val DataPage=Intent(this,DataShowActivity::class.java)
        val positionString:String=position.toString()
        DataPage.putExtra("position",positionString)
        startActivity(DataPage)
        finish()
    }

}