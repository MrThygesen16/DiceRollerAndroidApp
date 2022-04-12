import android.widget.ImageView
import android.widget.TextView
import com.example.diceroller.R

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