package com.example.schoolscientistsexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException


class MainActivity : AppCompatActivity() {


    var t = ServerCommand()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toastMe(view: View) {
        // val myToast = Toast.makeText(this, message, duration);
        val myToast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT)
        myToast.show()
    }

    fun countMe (view: View) {

       var count: Int

       try {
           // Get the value of the text view.
           val countString = textView.text.toString()
           // Convert value to a number and increment it
           count = Integer.parseInt(countString)
       }
       catch(e: NumberFormatException)
       {
           count = 0
       }

        count++
        // Display the new value in the text view.
        textView.text = count.toString();
    }

    fun randomMe(view: View) {

        // Create an Intent to start the second activity
        val randomIntent = Intent(this, SecondActivity::class.java)

        var count: Int

        try {
            // Get the value of the text view.
            val countString = textView.text.toString()
            // Convert value to a number and increment it
            count = Integer.parseInt(countString)
        }
        catch(e: NumberFormatException)
        {
            count = 0
        }

        // Add the count to the extras for the Intent.
        randomIntent.putExtra(SecondActivity.TOTAL_COUNT, count)

        // Start the new activity.
        startActivity(randomIntent)
    }

    fun ledOn(view: View){
        t.ledOn()
    }

    fun ledOff(view: View){
        t.ledOff()
    }
}
