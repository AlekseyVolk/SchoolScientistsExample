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

    private suspend fun deviceListBody() : String {
        return "[{\"type\": false, \"data_type\": \"d\", \"name\": \"house/device1/temperature\"}, \n" +
                "{\"type\": false, \"data_type\": \"d\", \"name\": \"house/device0/temperature\"}, \n" +
                "{\"type\": false, \"data_type\": \"d\", \"name\": \"house/device1/humidity\"}, \n" +
                "{\"type\": false, \"data_type\": \"d\", \"name\": \"house/device0/humidity\"}, \n" +
                "{\"type\": false, \"data_type\": \"b\", \"name\": \"house/device1/statusled\"}, \n" +
                "{\"type\": false, \"data_type\": \"b\", \"name\": \"house/device0/statusled\"}, \n" +
                "{\"type\": true, \"data_type\": \"b\", \"name\": \"house/device1/led\"}, \n" +
                "{\"type\": true, \"data_type\": \"b\", \"name\": \"house/device0/led\"}]"

        try {
            val res = client.get<String>(" https://ms0.newtonbox.ru/list/")
            Log.i(" https://ms0.newtonbox.ru/list/ Simple case ", res)
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