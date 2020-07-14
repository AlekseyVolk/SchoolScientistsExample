package com.example.schoolscientistsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ExampleThirdActivity : AppCompatActivity() {

    var t = ServerCommandExample()

    private lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_third )

        val jsonList = t.deviceList()

        val gson = Gson()
        val arrayDevicesType = object : TypeToken<ArrayList<ExampleDevice>>() {}.type

        var devices: ArrayList<ExampleDevice> = gson.fromJson(jsonList, arrayDevicesType)
        devices.forEachIndexed  { idx, dev -> println("> Item ${idx}:\n${dev}") }

        listView = findViewById<ListView>(R.id.deviceList)

        //val adapter = ExampleDeviceAdapter(this, android.R.layout.simple_expandable_list_item_1, devices)
        listView.adapter = ExampleDeviceAdapter(this, devices)
    }
}
