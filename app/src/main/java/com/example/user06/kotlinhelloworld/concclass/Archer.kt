package com.example.user06.kotlinhelloworld.concclass

import com.example.user06.kotlinhelloworld.absclass.Human
import com.example.user06.kotlinhelloworld.interfaces.ICallback
import com.example.user06.kotlinhelloworld.interfaces.ICharacter
import java.util.*


/**
 * Created by Anjan Debnath on 10/24/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
class Archer(name: String,
             callback: ICallback) : Human(name, callback), ICharacter{

    private var numArrows : Int? = null
    private var callback: ICallback?= null

    val random =  Random()


    fun findArrows(){
      var numArrowsFound : Int = random.nextInt(10) + 1
        var status : String = "${getName()} : Found ${numArrowsFound} arrows ..."
        println(status)
        numArrows = numArrows?.plus(numArrowsFound)
        callback?.humanCallback(status)


    }

    override fun attack(opponent: ICharacter) {
        val callBack = (getName() + ": Attacking " + opponent.getName()
                + " with my arrows!")
        println(callBack)
        opponent.decreaseHealth(getAttackPower())
        callback?.humanCallback(callBack)
    }

    override fun defend() {

    }

    override fun jump() {

    }

    override fun heal(): Int {
        return 0
    }


}