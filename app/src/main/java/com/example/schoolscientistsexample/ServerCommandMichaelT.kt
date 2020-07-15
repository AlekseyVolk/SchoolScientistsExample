package com.example.schoolscientistsexample

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.runBlocking

class ServerCommandMichaelT {
    private val client = HttpClient()

    private suspend fun userInfoGetBody(userId: String): String{
        try{
            var query = "https://ms3.newtonbox.ru/user/" + userId
            val res = client.get<String>(query)
            Log.i(query + " Simple case ", res)
            return res
        }
        catch (th : Throwable) {
            return "ОШИБКА"
        }
    }

    fun userInfoGet(userId: String): String{
        return runBlocking { userInfoGetBody(userId) }
    }
}