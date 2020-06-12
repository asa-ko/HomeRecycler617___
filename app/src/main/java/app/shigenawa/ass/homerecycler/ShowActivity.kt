package app.shigenawa.ass.homerecycler

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.net.toUri
import kotlinx.android.synthetic.main.activity_register.*

class ShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dateText=intent.getStringExtra("date")
        val imageUri=intent.getStringExtra("imageUri")

       val  uri:Uri=imageUri.toUri()

        dateShowText.setText(dateText)
        imageView.setImageURI(uri)

        backButton.setOnClickListener {
            val MainPage=Intent(this,MainActivity::class.java)
            startActivity(MainPage)
            finish()
        }
    }
}
