package com.example.schoolscientistsexample

import com.google.gson.annotations.SerializedName

class MichaelTUserInfo (
        @SerializedName("id") private var id : Int,
        @SerializedName("name") private var name: String,
        @SerializedName("position") private var position: String,
        @SerializedName("education") private var education: String
    )
{
    fun getId() :Int{
        return id
    }

    fun getName() :String{
        return name
    }

    fun getPosition() :String{
        return position
    }

    fun getEducation() :String{
        return education
    }
}
