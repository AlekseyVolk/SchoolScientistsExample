package com.example.schoolscientistsexample

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ServerCommand{

    private val client = HttpClient()

    fun ledOn() {
        GlobalScope.launch(Dispatchers.IO) {
            val data = client.get<String>("https://ms0.newtonbox.ru/set/house/device1/led/on")
            Log.i("https://ms0.newtonbox.ru/set/house/device1/led/on Simple case ", data)
        }
    }

    fun ledoff() {
        GlobalScope.launch(Dispatchers.IO) {
            val data = client.get<String>("https://ms0.newtonbox.ru/set/house/device1/led/off")
            Log.i("https://ms0.newtonbox.ru/set/house/device1/led/on Simple case ", data)
        }
    }
}