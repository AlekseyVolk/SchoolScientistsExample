package com.example.schoolscientistsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_michael_t_main.*

class MichaelTMainActivity : AppCompatActivity() {

    var t = ServerCommandMichaelT()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_michael_t_main)
    }

    fun userInfoGet(view: View){
        val str = t.userInfoGet(editTextUserId.text.toString())
        textViewUserId.text = str
    }
}
