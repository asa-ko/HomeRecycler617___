package app.shigenawa.ass.homerecycler

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_register.backButton
import kotlinx.android.synthetic.main.activity_register.dateShowText
import kotlinx.android.synthetic.main.activity_show.*

class ShowActivity : AppCompatActivity() {
    val realm: Realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

       // val intent=getIntent()
        //val time: Time? = read()
       val dateText= intent.getStringExtra("date")
        val imageUri = intent.getStringExtra("uriStr")
     //   val uriStr=intent.getStringArrayListExtra("uriStr")
        val value1=intent.getStringExtra("value1")
        val value2=intent.getStringExtra("value2")


        dateShowText.text=dateText

        val uri:Uri=Uri.parse(imageUri)
        showImageView.setImageURI(uri)

        val ratingValue1:Float=value1.toFloat()
        val ratingValue2:Float=value2.toFloat()

        ratingText1.text=value1
        ratingText2.text=value2
       ratingBar1.rating=ratingValue1
        ratingBar2.rating=ratingValue2



        backButton.setOnClickListener {
            val HomePage = Intent(this, MainActivity::class.java)
            startActivity(HomePage)
            finish()
        }
    }
    /*
        fun read():Time?{
            return realm.where(Time::class.java).findFirst()
        }

     */

}
