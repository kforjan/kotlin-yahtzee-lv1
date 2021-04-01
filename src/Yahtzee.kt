import Die

class Yahtzee {
    private val dice = listOf<Die>(Die(), Die(), Die(), Die(), Die(), Die())
    private val lockedDice : MutableList<Boolean> = mutableListOf(false, false, false, false, false, false)
    private var rollCounter : Int = 0


    fun rollDice(){
        increaseRollCountAndCheckLimitReach()
        for((index, die) in dice.withIndex()){
            if(!lockedDice[index]){
                die.roll()
            }
        }
    }

    fun printDice() {
        println("${dice[0].value}, ${dice[1].value}, ${dice[2].value}, ${dice[3].value}, ${dice[4].value}, ${dice[5].value}")
    }

    fun toggleDiceLockStatusByIndex(targetDieIndexes: List<Int>){
        for(dieIndex in targetDieIndexes){
            lockedDice[dieIndex] = !lockedDice[dieIndex]
        }
    }

    private fun increaseRollCountAndCheckLimitReach(){
        rollCounter++
        if(rollCounter > 3){
            rollCounter = 0
            lockedDice.replaceAll{_ -> false}
        }
    }

    fun getLockedDiceString():String{
        var lockedDiceString : String = ""
        for((dieIndex, lockedStatus) in lockedDice.withIndex()){
            if(lockedStatus){
                lockedDiceString += (dieIndex + 1)
                lockedDiceString += ", "
            }
        }
        return lockedDiceString
    }

    fun getRollCounter():Int{
        return rollCounter
    }

    fun getYahtzeeVerificationString():String{
        if(
            dice.count { (it.value == 1)} == 5 ||
            dice.count { (it.value == 2)} == 5 ||
            dice.count { (it.value == 3)} == 5 ||
            dice.count { (it.value == 4)} == 5 ||
            dice.count { (it.value == 5)} == 5 ||
            dice.count { (it.value == 6)} == 5
        ){
            return "Yahtzee!!! "
        }
        else if(
            dice.count { (it.value == 1)} == 4 ||
            dice.count { (it.value == 2)} == 4 ||
            dice.count { (it.value == 3)} == 4 ||
            dice.count { (it.value == 4)} == 4 ||
            dice.count { (it.value == 5)} == 4 ||
            dice.count { (it.value == 6)} == 4
        ){
            return "Four of a kind! "
        }
        else if(
            dice.count { (it.value == 1)} == 3 ||
            dice.count { (it.value == 2)} == 3 ||
            dice.count { (it.value == 3)} == 3 ||
            dice.count { (it.value == 4)} == 3 ||
            dice.count { (it.value == 5)} == 3 ||
            dice.count { (it.value == 6)} == 3
        ){
            return "Three of a kind! "
        }
        else if(
            dice.count { (it.value == 1)} == 1 &&
            dice.count { (it.value == 2)} == 1 &&
            dice.count { (it.value == 3)} == 1 &&
            dice.count { (it.value == 4)} == 1 &&
            dice.count { (it.value == 5)} == 1
        ){
            return "Small straight! "
        }
        else if(

            dice.count { (it.value == 2)} == 1 &&
            dice.count { (it.value == 3)} == 1 &&
            dice.count { (it.value == 4)} == 1 &&
            dice.count { (it.value == 5)} == 1 &&
            dice.count { (it.value == 6)} == 1
        ){
            return "Large straight! "
        }
        return ""
    }
}