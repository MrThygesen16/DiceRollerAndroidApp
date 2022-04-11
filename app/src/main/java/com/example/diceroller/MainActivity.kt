package com.example.diceroller

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

        // create a toast if the dice's values are the same
        if (dice1.checkTheSame(dice2)) {
            Toast.makeText(this@MainActivity, "The Dice have the same value!", Toast.LENGTH_SHORT).show()
        }

    }

}

// class dice, holds number of sides, a textview (for handling text on screen),
// and an imageview, for holding images on the screen
class Dice(
    private val numSides: Int,
    private val resultTextView: TextView,
    private val resultDiceImage: ImageView,
    private var num: Int,
    ) {

    // generates a random number between 1 and numsides
    private fun roll(): Int {
        return (1..numSides).random()
    }

    fun checkTheSame(other: Dice): Boolean {
        return this.num == other.num
    }

    fun updateDice() {
        val diceRoll = this.roll()
        this.num = diceRoll

        // updates the textView on screen
        this.resultTextView.text = diceRoll.toString()

        // similar to scala pattern matching
        val drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_6
        }

        // here we update the dice's image (corresponding to 1-6)...
        this.resultDiceImage.setImageResource(drawableResource)
    }

}
