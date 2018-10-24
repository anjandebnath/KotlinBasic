package com.example.user06.kotlinhelloworld.absclass

import com.example.user06.kotlinhelloworld.interfaces.ICallback
import com.example.user06.kotlinhelloworld.interfaces.ICharacter


/**
 * Created by Anjan Debnath on 10/22/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
abstract class Human : ICharacter{

    private var mUname: String
    private var mHealth: Double = 100.0
    private var mExperience: Long = 0
    private var mAttackPower: Int = 1

    private var callback: ICallback ? = null
    private var pet: Pet? = null

    //primary constructor
    class Human(var name: String, callback: ICallback){

    }

    //secondary constructor
    constructor(name: String, callback: ICallback){
        this.mUname = name
        this.callback = callback
    }

    fun setPet(pet: Pet): Unit {
        this.pet = pet
        println("$mUname I have a new pet. Hi ${pet.getName()}")
        callback?.humanCallback("$mUname I have a new pet. Hi ${pet.getName()}")

    }

    abstract override fun attack(opponent: ICharacter) : Unit

    abstract override fun defend() : Unit

    abstract override fun jump() : Unit

    abstract override fun heal(): Int

    override fun getName(): String {
        return this.mUname
    }


    override fun getHealth(): Double {
        return mHealth
    }

    override fun getExperience(): Long {
        return mExperience
    }

    override fun getAttackPower(): Int {
        return mAttackPower
    }

    override fun setAttackPower(attackPower: Int) {
       this.mAttackPower = attackPower
    }


    override fun decreaseHealth(opponentAttacker: Int): Double {
        mHealth -= opponentAttacker
        println("$mUname : I've been hit. My health now = $mHealth")
        callback?.humanCallback("$mUname : I've been hit. My health now = $mHealth")
        return mHealth
    }

    override fun gainExperience(experience: Long): Long {
       this.mExperience = experience
        return mExperience
    }

    fun getPet() : Pet? {
        return this.pet
    }


}