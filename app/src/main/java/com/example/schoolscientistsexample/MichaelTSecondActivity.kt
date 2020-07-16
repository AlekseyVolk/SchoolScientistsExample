package com.example.schoolscientistsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken

class MichaelTSecondActivity : AppCompatActivity() {

    private var t = ServerCommandMichaelT()

    private lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_michael_t_second)
    }

    override fun onResume(){
        super.onResume()

        var userId = "5"
        userId = getIntent().getExtras()!!.get("MichaelTMainActivityTest").toString()

        val jsonList = t.userBookList(userId)

        val gson = Gson()
        val arrayBookType = object : TypeToken<ArrayList<MichaelTUserBook>>() {}.type

        var books: ArrayList<MichaelTUserBook> = gson.fromJson(JsonParser().parse(jsonList).getAsJsonObject().get("user_list"), arrayBookType)
        // выведим в консоль список который мы получили
        books.forEachIndexed  { idx, dev -> println("> Item ${idx}:\n${dev}") }

        listView = findViewById<ListView>(R.id.michaelTBookList)

        listView.adapter = MichaelTUserBookAdapter(this, books)
    }
}
