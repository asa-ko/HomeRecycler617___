package app.shigenawa.ass.homerecycler

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_data_show.*

class DataShowActivity : AppCompatActivity() {

    val realm:Realm by lazy {
        Realm.getDefaultInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_show)

     //   val task:Time?=read()

        val dateText= intent.getStringExtra("date")
        val imageUri = intent.getStringExtra("uri")
        val value1=intent.getStringExtra("value1")
        val value2=intent.getStringExtra("value2")


        dateShowText.text=dateText

        val uri:Uri=Uri.parse(imageUri)
        dateShowImageView.setImageURI(uri)

        val ratingValue1:Float=value1.toFloat()
        val ratingValue2:Float=value2.toFloat()

        ratingText1.text=value1
        ratingText2.text=value2
       ratingBar11.rating=ratingValue1
        ratingBar22.rating=ratingValue2


        backButton.setOnClickListener {
            val mainPage= Intent(this,MainActivity::class.java)
            startActivity(mainPage)
            finish()
        }
    }

}
