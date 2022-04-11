# Dice Roller App

This is a simple android app that allows the user to roll two 6 sided dice at a time. The dice update to the corresponding rolled number.



 ![Image1](https://github.com/MrThygesen16/DiceRollerAndroidApp/blob/master/images-git/dice1.PNG)



When the user rolls the same number dice for both, they receive a toast/message.

![Image2](https://github.com/MrThygesen16/DiceRollerAndroidApp/blob/master/images-git/dice2.PNG)



-------



The `Dice` class is as follows:

```kotlin
class Dice(
    private val numSides: Int,
    private val resultTextView: TextView,
    private val resultDiceImage: ImageView,
    private var num: Int,
    ) {

    private fun roll(): Int {
        return (1..numSides).random()
    }

    fun checkTheSame(other: Dice): Boolean {
        return this.num == other.num
    }

    fun updateDice() {
        val diceRoll = this.roll()
        this.num = diceRoll


        this.resultTextView.text = diceRoll.toString()

        val drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_6
        }

        this.resultDiceImage.setImageResource(drawableResource)
    }

}
```



This way we can have almost as many dice as we want, all we need to do is call the constructor, and call `updateDice()` whenever we want to have a roll at the dice.



Below is how we would construct/create `Dice` objects.

```kotlin
val dice1 = Dice(6, findViewById(R.id.text_roll_result),findViewById(R.id.image_dice), 1)
val dice2 = Dice(6, findViewById(R.id.text_roll_result2),findViewById(R.id.image_dice2), 2)

dice1.updateDice()
dice2.updateDice()
```

