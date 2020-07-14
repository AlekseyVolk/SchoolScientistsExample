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

    private suspend fun ledOnBody(name: String) : String {
        try {
            var req = "https://ms0.newtonbox.ru/set/" + name + "/on"
            val res = client.get<String>(req)
            Log.i( req +" Simple case ", res)
            return res
        } catch (th: Throwable) {
            return "ОШИБКА"
        }
    }

    fun ledOn(name: String) : String {
        return runBlocking { ledOnBody(name) }
    }

    private suspend fun ledOffBody(name: String) : String {
        try {
            var req = "https://ms0.newtonbox.ru/set/" + name + "/off"
            val res = client.get<String>(req)
            Log.i( req +" Simple case ", res)
            return res
        } catch (th: Throwable) {
            return "ОШИБКА"
        }
    }

    fun ledOff(name: String) : String {
        return runBlocking { ledOffBody(name) }
    }

    private suspend fun deviceListBody() : String {
        try {
            var res = client.get<String>("https://ms0.newtonbox.ru/list/")
            Log.i("https://ms0.newtonbox.ru/list/ Simple case ", res)
            return res
        } catch (th: Throwable) {
            return "[{\"type\": false, \"data_type\": \"d\", \"name\": \"house/device1/temperature\"}, \n" +
                    "{\"type\": false, \"data_type\": \"d\", \"name\": \"house/device0/temperature\"}, \n" +
                    "{\"type\": false, \"data_type\": \"d\", \"name\": \"house/device1/humidity\"}, \n" +
                    "{\"type\": false, \"data_type\": \"d\", \"name\": \"house/device0/humidity\"}, \n" +
                    "{\"type\": false, \"data_type\": \"b\", \"name\": \"house/device1/statusled\"}, \n" +
                    "{\"type\": false, \"data_type\": \"b\", \"name\": \"house/device0/statusled\"}, \n" +
                    "{\"type\": true, \"data_type\": \"b\", \"name\": \"house/device1/led\"}, \n" +
                    "{\"type\": true, \"data_type\": \"b\", \"name\": \"house/device0/led\"}]"
        }
    }

    fun deviceList() : String {
        return runBlocking { deviceListBody() }
    }
}