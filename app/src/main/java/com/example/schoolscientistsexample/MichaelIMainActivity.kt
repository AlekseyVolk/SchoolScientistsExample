package com.example.schoolscientistsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_michael_i_main.*

class MichaelIMainActivity : AppCompatActivity() {

    private var t = ServerCommandMichaelI()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_michael_i_main)
    }

    fun scoreGet(view: View){
        var jsonStr = t.gameScoreGet()

        val score: MichaelITeamScore = Gson().fromJson<MichaelITeamScore>(jsonStr, MichaelITeamScore::class.java)

        textViewTeam1Score.text = score.team1ScoreGet().toString()
        textViewTeam2Score.text = score.team2ScoreGet().toString()
    }
}
