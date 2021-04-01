class Die {
    var value: Int = (1..6).random()

    fun roll(){
        value = (1..6).random()
    }
}