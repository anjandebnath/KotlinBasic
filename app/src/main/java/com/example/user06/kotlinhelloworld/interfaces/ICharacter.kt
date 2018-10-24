package com.example.user06.kotlinhelloworld.interfaces

import java.util.*


/**
 * Created by Anjan Debnath on 10/22/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
interface ICharacter {


    fun getName(): String
    fun getHealth(): Double
    fun getExperience(): Long
    fun getAttackPower(): Int
    fun setAttackPower(attackPower: Int): Unit

    fun defend(): Unit
    fun jump(): Unit
    fun heal(): Int
    fun attack(opponent: ICharacter): Unit

    fun decreaseHealth(opponentAttacker: Int): Double
    fun gainExperience(experience: Long): Long

}