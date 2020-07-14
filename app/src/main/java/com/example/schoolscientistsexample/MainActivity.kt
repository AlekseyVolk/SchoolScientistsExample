package com.example.schoolscientistsexample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent

class MainActivity : AppCompatActivity() {

    var tAndrey = ServerCommandAndrey()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun andreyExample(view: View){
        val str = tAndrey.createOrder(1)

        textView.text = str

        val myToast = Toast.makeText(this, str, Toast.LENGTH_SHORT)
        myToast.show()
    }

    fun example(view: View){
        val intent = Intent(this@MainActivity, ExampleMainActivity::class.java)
        startActivity(intent)
    }
}
