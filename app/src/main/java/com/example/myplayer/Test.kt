package com.example.myplayer

import android.util.Log

//Open class with integrated constructor
open class Person(var name: String = "Brayan", val age: Int = 29)

//This class could specify multiple constructors, also inherits from person class.
class Developer : Person {
    constructor(name: String) : super(name)
}

fun test() {
    val person = Person("Jhon", 30)
    val person2 = Person(age = 20)
    val developer = Developer(name = "Patricio")
    Log.i("MESSAGES", "New Developer: ${developer.name} ${developer.age}")
}


// <<<<<<<<<<<<<<<<<<<LAMBDAS>>>>>>>>>>>>>>>>>>>
fun doAsync(x: Int, callback: (String) -> Unit) {
    callback("finished")
}

fun testLambdas() {

    doAsync(20) { result -> Log.i("MESSAGES: ", "XD: $result") }

    val sum = { a: Int, b: Int -> a + b }
    applyOp(3, 5, sum)

    val multiplication = { a: Int, b: Int -> a * b }
    applyOp(5, 5, multiplication)

    val result = applyOp(2, 10) { x: Int, y: Int -> x - y }
    Log.i("MESSAGES", "Sub: $result")
}

fun applyOp(x: Int, y: Int, f: (Int, Int) -> Int): Int = f(x, y)

// <<<<<<<<<<<<<<<<<COLLECTIONS>>>>>>>>>>>>>>
fun testList(items: List<MediaItem>) {
    val urlList: List<String> = items
        .filter { it.type == MediaItem.Type.PHOTO }
        .sortedBy { it.title }
        .map { it.thumbUrl }

    // it's the same it keyword is used when lambda expression has only one parameter
    urlList.forEach { url -> print("Element: $url") }
    urlList.forEach { print("Element: $it") }

    (1..4).forEach(::print)

    val mutableList: MutableList<Int> = mutableListOf(2, 3, 4)
    mutableList.add(10)
}

//<<<<<<<<<<<<<<<<< INFIX FUNCTIONS >>>>>>>>>>>>>
fun testInfix() {
    val result = 10.addition(11)
    val result2 = 10 addition 11
}

infix fun Int.addition(other: Int) = this + other

//<<<<<<<<<<<<<<< NULLS >>>>>>>>>>>>>>>>>>>>>>>>>
val myInt: Int? = null
val myLong: Long = myInt?.toLong() ?: 0L
