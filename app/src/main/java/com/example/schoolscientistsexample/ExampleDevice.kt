package com.example.schoolscientistsexample

class ExampleDevice (
    private var type : Boolean,
    private var dataType: Boolean,
    private var name: String
){
    override fun toString(): String {
        return "Category [type: ${this.type}, dataType: ${this.dataType}, name: ${this.name}]"
    }

    fun getName() :String{
        return name
    }
}
