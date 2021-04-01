import Yahtzee

fun main(){
    val yahtzee: Yahtzee = Yahtzee()
    var lockIndexes : String
    println("-------------------------")
    println("Press Enter to roll dice. \n3 rolls left")
    readLine()
    yahtzee.rollDice()
    yahtzee.printDice()
    while (true){
        println(( 3 - yahtzee.getRollCounter()).toString() + " roll/s left")
        println("Enter the ordinal numbers of the cubes you wish to lock / unlock. Separate the numbers with a space. Example 1 3 4.")
        if (yahtzee.getLockedDiceString() == "") println("Currently there are no locked dice.")
        else  println(yahtzee.getYahtzeeVerificationString() + "Currently locked dice are: ${yahtzee.getLockedDiceString()}")
        lockIndexes = readLine() ?: ""
        yahtzee.toggleDiceLockStatusByIndex(convertStringToList(lockIndexes))
        println("Press Enter to roll dice.")
        readLine()
        yahtzee.rollDice()
        yahtzee.printDice()
    }
}

fun convertStringToList(string: String): List<Int> {
    if(string == "") return emptyList<Int>()
    return string.split(" ").map { it.toInt() - 1 }
}



