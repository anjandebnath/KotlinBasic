package com.example.user06.kotlinhelloworld.concclass

import com.example.user06.kotlinhelloworld.absclass.Human
import com.example.user06.kotlinhelloworld.absclass.Pet
import com.example.user06.kotlinhelloworld.interfaces.ICallback
import com.example.user06.kotlinhelloworld.interfaces.ICharacter


/**
 * Created by Anjan Debnath on 10/24/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
class Dog(name: String, owner: Human,
          callBack: ICallback) : Pet(name, owner, callBack), ICharacter{

    private var callBack: ICallback? = null

    fun bark():Unit{
        println(getName() + ": Wolf Wolf!")
        callBack?.petCallback(getName() + ": Wolf Wolf!")
    }

    override fun defend() {

    }

    override fun jump() {

    }

    override fun heal(): Int {
        return 0
    }

    override fun attack(opponent: ICharacter) {
        val status: String = getName() + ": Biting " + opponent.getName()
        println(status)
        opponent.decreaseHealth(getAttackPower())

        callBack?.petCallback(status)
    }

    override fun cry() {
        bark()
    }
}