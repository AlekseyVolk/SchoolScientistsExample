package com.example.schoolscientistsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_michael_t_main.*

class MichaelTMainActivity : AppCompatActivity() {

    var t = ServerCommandMichaelT()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_michael_t_main)
    }

    fun userInfoGet(view: View){
        val json = t.userInfoGet(editTextUserId.text.toString())

        val gson = Gson()
        val michaelTUserType = object : TypeToken<MichaelTUserInfo>() {}.type

        var userInfo: MichaelTUserInfo = gson.fromJson(JsonParser().parse(json).getAsJsonObject().get("object"), michaelTUserType)

        textViewUserId.text = json
    }
}
