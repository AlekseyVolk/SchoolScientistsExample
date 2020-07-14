package com.example.schoolscientistsexample

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.runBlocking

class ServerCommandAndrey {

    private val client = HttpClient()

    private suspend fun createOrderBody(item: Int): String{
        try{
            var query = "https://ms1.newtonbox.ru/terminal0/" + item
            val res = client.get<String>(query)
            Log.i(query + " Simple case ", res)
            return res
        }
        catch (th : Throwable) {
            return "ошибка"
        }
    }

    // пример для Андрея Губанова
    fun createOrder(item: Int): String{
        return runBlocking { createOrderBody(item) }
    }
}