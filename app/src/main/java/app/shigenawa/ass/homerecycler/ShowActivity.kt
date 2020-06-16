package app.shigenawa.ass.homerecycler

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.net.toUri
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_register.*

class ShowActivity : AppCompatActivity() {
    val realm: Realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        val time: Time? = read()
      //  val dateText = intent.getStringExtra("date")
      //  val imageUri = intent.getStringExtra("uriStr")
     //   val uriStr=intent.getStringArrayListExtra("uriStr")
     //   val value1=intent.getFloatExtra("value1")
     //   val value2=intent.getFloatExtra("value2")


       // val uri:Uri=Uri.parse(imageUri)
       // imageView.setImageURI(uri)

      /*  if(time!=null) {
            val uried: Uri = Uri.parse(time.uri)
            val dated:String?=time.timeData

          //  dateShowText.text=dateText
          //  imageView.setImageURI(uried)
        }

       */


        backButton.setOnClickListener {
            val HomePage = Intent(this, MainActivity::class.java)
            startActivity(HomePage)
            finish()
        }
    }
        fun read():Time?{
            return realm.where(Time::class.java).findFirst()
        }

}
