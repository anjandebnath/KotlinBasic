package com.example.user06.kotlinhelloworld.absclass

import com.example.user06.kotlinhelloworld.interfaces.ICallback
import com.example.user06.kotlinhelloworld.interfaces.ICharacter



/**
 * Created by Anjan Debnath on 10/24/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
abstract class Pet: ICharacter {

    private var name: String? = null
    private var health: Double = 100.0
    private var mExperience: Long = 0
    private var mAttackPower: Int = 1

    private val owner: Human
    private var callBack: ICallback? = null


    //secondary constructor
    constructor(name: String, owner: Human, callBack: ICallback){
          this.name = name
          this.callBack = callBack
          this.owner = owner
          this.owner.setPet(this)
          gainExperience(1)
    }

    abstract override fun defend(): Unit

    abstract override fun jump() : Unit

    abstract override fun heal(): Int

    abstract override fun attack(opponent: ICharacter) : Unit


    fun getOwner(): Human{
        return owner
    }

    override fun getName(): String {
        return name.toString();
    }

    override fun getHealth(): Double {
        return health
    }

    override fun getExperience(): Long {
        return mExperience
    }

    override fun gainExperience(experience: Long): Long {
        this.mExperience += experience
        return mExperience
    }

    override fun getAttackPower(): Int {
        return mAttackPower
    }

    override fun setAttackPower(attackPower: Int) {
       this.mAttackPower = attackPower
    }

    fun heal(additionalHealth: Double) : Double{
        health += additionalHealth
        return health
    }



    override fun decreaseHealth(opponentAttacker: Int): Double {
        health -= opponentAttacker
        cry()
        println("${getName()}  Health now =  ${getHealth()}")
        //if callback is not null
        callBack?.petCallback("${getName()}  Health now =  ${getHealth()}")
        return health;
    }

    abstract fun cry():Unit


}