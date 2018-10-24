package com.example.user06.kotlinhelloworld

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ShareActionProvider


/**
 * Created by Anjan Debnath on 10/22/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
class DetailActivityKotlin : AppCompatActivity() {

    /**
     * If you don’t declare a variable as nullable,
     * then you cannot assign it a null value.
     * To declare a variable as nullable, you have to append a ? to its type
     * at the point of declaration, as you see in this shareActionProvider declaration:
     */
    private var shareActionProvider: ShareActionProvider? = null
    var n = 34;
    var dayOfWeek = 4;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main);

        /**
         * To access a property or method on a nullable variable in Java,
         * you would first do a null check.
         * With Kotlin, you can simplify the above expression with the use
         * of a safe call operator (?.).
         * The property or method is only called when the nullable variable is not null.
         */
        actionBar?.setDisplayHomeAsUpEnabled(true);

        if( n% 2 == 0){
            println("$n is even")
        }

        var dayOfWeekInString = when(dayOfWeek){

            1->"Monday"
            2->"Tuesday"
            else -> "Invalid Day"
        }

        when(dayOfWeek){
            in 1..5 -> println("We're in the first week")
            in 6..7 -> println("We are in the last week")
            else -> println("none of the above")
        }

        for(value in 1..10){
            println("$value")
        }

        var primeNumbers = intArrayOf(2,3,5,7,11)
        for(number in primeNumbers){
            print("$number")
        }

        for(index in primeNumbers.indices){
            println("primeNumber(${index+1}): ${primeNumbers[index]}")
        }




    }

    //Parent class
    open class Computer(var name: String,
                        var brand: String){

    }

    //Child class
    class Laptop(name: String,
                 brand: String): Computer(name, brand){

    }
}