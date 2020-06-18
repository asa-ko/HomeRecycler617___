package app.shigenawa.ass.homerecycler

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import io.realm.Realm
import io.realm.RealmResults
import io.realm.Sort
import kotlinx.android.synthetic.main.activity_data_show.*

class DataShowActivity : AppCompatActivity() {

    val realm:Realm by lazy {
        Realm.getDefaultInstance()
    }

  //  var nextDayPosition:Int=0
  //  var yesterdayPosition:Int=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_show)


        /*
        val dateText= intent.getStringExtra("date")
        val imageUri = intent.getStringExtra("uri")
        val value1=intent.getStringExtra("value1")
        val value2=intent.getStringExtra("value2")
        val id=intent.getStringExtra("id")
        */
        val positionString=intent.getStringExtra("position")
        var position:Int=positionString.toInt()
            series(position)

        var nextDayPosition:Int
        var yesterdayPosition:Int

        val list=read()
        val positionMax:Int=list.size
       // val time=read(position)
       // show(time)


        backButton.setOnClickListener {
            val mainPage= Intent(this,MainActivity::class.java)
            startActivity(mainPage)
            finish()
        }

     /*   if(position==-1){
            nextdayButton.visibility= View.INVISIBLE
            Toast.makeText(applicationContext,"これより最新のデータはありません", Toast.LENGTH_SHORT).show()
        }*/

        nextdayButton.setOnClickListener {
           // nextDayAction(position)
             position=position-1
            if(position==-1){
                nextdayButton.visibility= View.INVISIBLE
                Toast.makeText(applicationContext,"これより最新のデータはありません", Toast.LENGTH_SHORT).show()
            }else
            series(position)

           /* nextdayButton.setOnClickListener {
                nextDayPosition=nextDayPosition-1
                if(nextDayPosition==0){
                    Toast.makeText(applicationContext,"これより最新のデータはありません", Toast.LENGTH_SHORT).show()
                }
                series(nextDayPosition)
            }
            */
        }

        yesterdayButton.setOnClickListener {
            //yesterdayAction(position)

           // val list=read()
            //val time=list.get(position)
            position=position+1
            if(position==positionMax){
                yesterdayButton.visibility=View.INVISIBLE
                Toast.makeText(applicationContext,"これより古いデータはありません", Toast.LENGTH_SHORT).show()
            }else
           series(position)
                 /*     yesterdayButton.setOnClickListener {
                yesterdayPosition=yesterdayPosition+1
                // show(yesterdayPosition)
                series(yesterdayPosition)
            }
         */


        }


      /*  fun nextDayAction(position:Int){
            nextDayPosition=position-1
            if(nextDayPosition==0){
                Toast.makeText(applicationContext,"これより最新のデータはありません", Toast.LENGTH_SHORT).show()
            }
            series(nextDayPosition)

            nextdayButton.setOnClickListener { nextDayAction(nextDayPosition) }
            yesterdayButton.setOnClickListener { yesterdayAction(nextDayPosition) }
        }

        fun yesterdayAction(position:Int){
            yesterdayPosition=position+1
            // show(yesterdayPosition)
            series(yesterdayPosition)
            nextdayButton.setOnClickListener { nextDayAction(yesterdayPosition) }
            yesterdayButton.setOnClickListener { yesterdayAction(yesterdayPosition) }
        }


       */
    }


    fun series(position:Int){
        val list=read()
       val time=list.get(position)


           val dateText: String? = time?.timeData
           val imageUri: String? = time?.uri
           val value1: String = time?.ratingValue1.toString()
           val value2: String = time?.ratingValue2.toString()


            dateShowText.text = dateText

      if(time?.uri!=null) {
            val uriData: Uri = Uri.parse(imageUri)
         // dateShowImageView.setImageURI(uriData)
          dateShowImageView.setImageURI(uriData)
        }


         //  val ratingValue1: Float = value1.toFloat()
         //  val ratingValue2: Float = value2.toFloat()

            ratingText1.text = value1
            ratingText2.text = value2
       if(time?.ratingValue1!=null&&time?.ratingValue2!=null) {
            val ratingValue1: Float = value1.toFloat()
            val ratingValue2: Float = value2.toFloat()

            ratingBar11.rating = ratingValue1
            ratingBar22.rating = ratingValue2
        }






       // show(time)
    }





    fun read():RealmResults<Time>{
        return realm.where(Time::class.java).findAll().sort("timeData", Sort.DESCENDING)
    }

  /*  fun nextDayAction(position:Int){
        nextDayPosition=position-1
        if(nextDayPosition==0){
            Toast.makeText(applicationContext,"これより最新のデータはありません", Toast.LENGTH_SHORT).show()
        }
        series(nextDayPosition)

        nextdayButton.setOnClickListener { nextDayAction(nextDayPosition) }
        yesterdayButton.setOnClickListener { yesterdayAction(nextDayPosition) }
    }

    fun yesterdayAction(position:Int){
        yesterdayPosition=position+1
        // show(yesterdayPosition)
        series(yesterdayPosition)
        nextdayButton.setOnClickListener { nextDayAction(yesterdayPosition) }
        yesterdayButton.setOnClickListener { yesterdayAction(yesterdayPosition) }
    }

     */


}
