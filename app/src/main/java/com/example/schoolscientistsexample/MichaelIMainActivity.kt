package com.example.schoolscientistsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock.sleep
import android.view.View
import com.google.gson.Gson
// import android.R
import android.widget.TextView
import android.os.Handler
import android.os.Message
import kotlinx.android.synthetic.main.activity_michael_i_main.*


class MichaelIMainActivity : AppCompatActivity() {

    private var t = ServerCommandMichaelI()

    private var thread = Thread()

    private var endThread = false

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

    fun startAutoUpdateScore(view: View) {

        endThread = false

        val runnable = object : Runnable {
            override fun run() {
                var jsonStr : String
                var score: MichaelITeamScore
                while (true) {
                    jsonStr = t.gameScoreGet()

                    score = Gson().fromJson<MichaelITeamScore>(jsonStr, MichaelITeamScore::class.java)

                    var msg = handler.obtainMessage()
                    var bundle = Bundle()
                    bundle.putString("teamScore", score.team1ScoreGet().toString()+"#"+ score.team2ScoreGet().toString())
                    msg.setData(bundle)
                    handler.sendMessage(msg)

                    sleep(2000)

                    if(endThread)
                        break
                }
            }
        }

        buttonAutoUpdateStart.isEnabled = false
        buttonAutoUpdateStop.isEnabled = true

        thread = Thread(runnable)
        thread.start()
    }

    fun stopAutoUpdateScore(view: View) {
        endThread = true

        buttonAutoUpdateStart.isEnabled = true
        buttonAutoUpdateStop.isEnabled = false
    }

    var handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            var bundle = msg.getData()
            var msg = bundle.getString("teamScore")

            var score = msg!!.split("#")

            var infoTextView = findViewById(R.id.textViewTeam1Score) as TextView
            infoTextView.setText(score[0])

            infoTextView = findViewById(R.id.textViewTeam2Score) as TextView
            infoTextView.setText(score[1])
        }
    }
}
