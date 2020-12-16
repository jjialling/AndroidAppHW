package com.example.myfirstapp

import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.ImageView
import android.widget.TextView


class DisplayMesssageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_messsage)




        val message = intent.getBundleExtra("bundle")?.getString("key")
        val num = intent.getBundleExtra("bundle")?.getString("key1")
        val bg = intent.getBundleExtra("bundle")?.getInt("color")
        val sw = intent.getBundleExtra("bundle")?.getInt("swBtn")
        val imageName = intent.getBundleExtra("bundle")?.getString("key2")




        val screenColor = findViewById<View>(R.id.rView)
        if (bg == 1){
            screenColor.setBackgroundColor(Color.parseColor("#00ddff"))
        }else if (bg == 2) {
            screenColor.setBackgroundColor(Color.parseColor("#99cc00"))
        }else if (bg == 3) {
            screenColor.setBackgroundColor(Color.parseColor("#ffbb33"))
        }



        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message

        }
        val textView1 = findViewById<TextView>(R.id.textView_age).apply {

            if (sw == 1) {
                text = "  "
            }else if (sw == 2){
                text = num
            }

        }
        val image = findViewById<ImageView>(R.id.imageView)
        var input = imageName.toString()
        var imgName = "head"

        if (input == imgName) {

            image.setImageResource(R.drawable.img_8677)


        }








    }
}




