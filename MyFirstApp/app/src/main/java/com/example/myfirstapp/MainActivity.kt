package com.example.myfirstapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.Display
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import kotlin.properties.Delegates




class MainActivity : AppCompatActivity() {
    private var a by Delegates.notNull<Int>()
    private var b by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val num = findViewById<TextView>(R.id.textView4)
        val countString = num.text.toString()
        var count = countString.toInt()
        b=2
        a=1

        findViewById<Button>(R.id.button3).setOnClickListener {

            count++
            num.text = count.toString()

        }
        findViewById<Button>(R.id.button4).setOnClickListener {

            if (count >= 1){
                val countString = num.text.toString()
                var count = countString.toInt()
                count--
                num.text = count.toString()
            }else{
                num.text = "0"
            }

        }
        val sw = findViewById<Switch>(R.id.switch1)
        sw.setOnCheckedChangeListener { compoundButton, isCheck ->
            if (isCheck == false) {
                b = 1
            }
            if (isCheck == true) {
                b = 2
            }
        }





    }
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }
    fun sendMessage(view: View) {
        var bundle = Bundle()
        val editText = findViewById<EditText>(R.id.editTextTextPersonName2)
        val message = editText.text.toString()
        val num = findViewById<TextView>(R.id.textView4)
        val countString = num.text.toString()
        val imageText = findViewById<EditText>(R.id.editTextTextPersonName)
        val imageName = imageText.text.toString()
        bundle.putString("key",message)
        bundle.putString("key1",countString)
        bundle.putString("key2",imageName)
        bundle.putInt("color",a)
        bundle.putInt("swBtn",b)


        val intent = Intent(this, DisplayMesssageActivity::class.java ).apply {
            putExtra("bundle", bundle)

        }


        startActivity(intent)



    }
    fun select(view: View) {

        when(view.id) {
            R.id.radio_B -> a = 1
            R.id.radio_G -> a = 2
            R.id.radio_Y -> a = 3
        }

    }


}

