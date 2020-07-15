package com.example.schoolscientistsexample

import com.google.gson.annotations.SerializedName

class ExampleDevice (
    @SerializedName("type") private var type : Boolean,
    @SerializedName("data_type") private var dataType: String,
    @SerializedName("name") private var name: String
){
    override fun toString(): String {
        return "Category [type: ${this.type}, dataType: ${this.dataType}, name: ${this.name}]"
    }

    fun getName() :String{
        return name
    }

    fun isManage() : Boolean{
        return type
    }
}
