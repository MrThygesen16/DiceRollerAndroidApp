package com.example.diceroller

import Dice
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ABOVE HERE IS DEFAULT CODE

        // this creates a value for referencing our button
        val rollButton: Button = findViewById(R.id.button_roll)


        // this function tells us what to do when the rollButton is clicked
        // calls the rollDice function, defined below
        rollButton.setOnClickListener { rollDice() }

        // call rollDice() here so that the screen isn't blank when first opening the app
        rollDice()

    }

    private fun rollDice(){

        // create a dice object with x number of sides
        val dice1 = Dice(6, findViewById(R.id.text_roll_result),findViewById(R.id.image_dice), 1)
        val dice2 = Dice(6, findViewById(R.id.text_roll_result2),findViewById(R.id.image_dice2), 2)

        // here we roll the dice by calling the Dice object's method 'updateDice'
        dice1.updateDice()
        dice2.updateDice()

        // create a toast if the dices values are the same
        if (dice1.checkTheSame(dice2)) {
            Toast.makeText(this@MainActivity, "The Dice have the same value!", Toast.LENGTH_SHORT).show()
        }

    }

}

