package com.example.schoolscientistsexample

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.renderSetCookieHeader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ServerCommandExample{

    private val client = HttpClient()

    private suspend fun ledOnBody() : String {
        try {
            val res = client.get<String>("https://ms0.newtonbox.ru/set/house/device1/led/on")
            Log.i("https://ms0.newtonbox.ru/set/house/device1/led/on Simple case ", res)
            return res
        } catch (th: Throwable) {
            return "ОШИБКА"
        }
    }

    fun ledOn() : String {
        return runBlocking { ledOnBody() }
    }

    private suspend fun ledOffBody() : String {
        try {
            val res = client.get<String>("https://ms0.newtonbox.ru/set/house/device1/led/off")
            Log.i("https://ms0.newtonbox.ru/set/house/device1/led/off Simple case ", res)
            return res
        } catch (th: Throwable) {
            return "ОШИБКА"
        }
    }

    fun ledOff() : String {
        return runBlocking { ledOffBody() }
    }
}