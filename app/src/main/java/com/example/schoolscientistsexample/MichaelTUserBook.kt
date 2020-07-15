package com.example.schoolscientistsexample

import com.google.gson.annotations.SerializedName

class MichaelTUserBook (
    @SerializedName("book__id") private var id : Int,
    @SerializedName("book__title") private var name: String,
    @SerializedName("book__author") private var author: String,
    @SerializedName("book__date_start") private var dateStart: String,
    @SerializedName("book__date_end") private var dateEnd: String
)