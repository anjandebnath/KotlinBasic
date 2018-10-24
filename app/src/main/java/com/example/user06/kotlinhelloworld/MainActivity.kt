package com.example.user06.kotlinhelloworld

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.user06.kotlinhelloworld.concclass.Archer
import com.example.user06.kotlinhelloworld.concclass.Dog
import com.example.user06.kotlinhelloworld.interfaces.ICallback

class MainActivity : AppCompatActivity(), ICallback  {

    override fun petCallback(status: String) {
        showText?.append(status + "\n")
    }

    override fun humanCallback(status: String) {
        showText?.append(status + "\n")
    }


    val TAG = "R :: "
    var showText: TextView? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showText = findViewById(R.id.textV) as TextView

        showText?.text = "\nInitialize Game\n"
        val niceArcher = Archer("Tom", this)
        val modernArcher = Archer("Stacy", this)

        val modernDog = Dog("German Shepherd", modernArcher, this)
        val petDog = Dog("Akita", niceArcher, this)

        showText?.append("\nStart Game\n")

        modernArcher.attack(niceArcher)
        niceArcher.getPet()?.attack(modernArcher)
        modernArcher.attack(niceArcher.getPet()!!)
        modernDog.attack(petDog.getOwner())
        petDog.attack(modernArcher.getPet()!!)


    }






}
