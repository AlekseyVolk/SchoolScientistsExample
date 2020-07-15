package com.example.schoolscientistsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_michael_i_main.*
import kotlinx.android.synthetic.main.activity_michael_i_main.view.*

class MichaelIMainActivity : AppCompatActivity() {

    private var t = ServerCommandMichaelI()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_michael_i_main)
    }

    fun scopeGet(view: View){
        var str = t.gameScoreGet()
        textViewTeam2Scope.text = str
    }
}
