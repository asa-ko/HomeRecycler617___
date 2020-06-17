package app.shigenawa.ass.homerecycler

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.realm.Realm
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_data_show.*

class DataShowActivity : AppCompatActivity() {

    val realm:Realm by lazy {
        Realm.getDefaultInstance()
    }
/*
    val dateText:String=""
    val imageUri:String=""
    val value1:String=""
    val value2:String=""
    val id:String=""

 */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_show)

     //   val task:Time?=read()

        /*
        val dateText= intent.getStringExtra("date")
        val imageUri = intent.getStringExtra("uri")
        val value1=intent.getStringExtra("value1")
        val value2=intent.getStringExtra("value2")
        val id=intent.getStringExtra("id")
        */
        val positionString=intent.getStringExtra("position")
        val position:Int=positionString.toInt()
            series(position)
       // val time=read(position)
       // show(time)

        /*
        dateShowText.text=dateText

        val uri:Uri=Uri.parse(imageUri)
        dateShowImageView.setImageURI(uri)

        val ratingValue1:Float=value1.toFloat()
        val ratingValue2:Float=value2.toFloat()

        ratingText1.text=value1
        ratingText2.text=value2
       ratingBar11.rating=ratingValue1
        ratingBar22.rating=ratingValue2

         */


        backButton.setOnClickListener {
            val mainPage= Intent(this,MainActivity::class.java)
            startActivity(mainPage)
            finish()
        }

        nextdayButton.setOnClickListener {
            val nextDayPosition:Int=position-1
            if(nextDayPosition==0){
                Toast.makeText(applicationContext,"これより最新のデータはありません", Toast.LENGTH_SHORT).show()
            }
           // show(nextDayPosition)
            series(nextDayPosition)
        }

        yesterdayButton.setOnClickListener {
            val yesterdayPosition:Int=position+1
           // show(yesterdayPosition)
            series(yesterdayPosition)
        }
    }

    fun series(position:Int){
        val list=read()
       val time=list.get(position)


            val dateText: String = time?.timeData.toString()
            val imageUri: String = time?.uri.toString()
            val value1: String = time?.ratingValue1.toString()
            val value2: String = time?.ratingValue2.toString()


            dateShowText.text = dateText

            val uri: Uri = Uri.parse(imageUri)
            dateShowImageView.setImageURI(uri)

            val ratingValue1: Float = value1.toFloat()
            val ratingValue2: Float = value2.toFloat()

            ratingText1.text = value1
            ratingText2.text = value2
            ratingBar11.rating = ratingValue1
            ratingBar22.rating = ratingValue2

       // show(time)
    }

    fun read():RealmResults<Time>{
        return realm.where(Time::class.java).findAll()
    }

/*
    fun show(time:Time){
       // realm.executeTransaction {
       //     val time=realm.where(Time::class.java).findAll()

            val dateText:String=time.timeData.toString()
            val imageUri:String=time.uri.toString()
            val value1:String=time.ratingValue1.toString()
            val value2:String=time.ratingValue2.toString()
          //  val id:String=""

        dateShowText.text=dateText

        val uri:Uri=Uri.parse(imageUri)
        dateShowImageView.setImageURI(uri)

        val ratingValue1:Float=value1.toFloat()
        val ratingValue2:Float=value2.toFloat()

        ratingText1.text=value1
        ratingText2.text=value2
        ratingBar11.rating=ratingValue1
        ratingBar22.rating=ratingValue2
       // }
    }

 */




}
