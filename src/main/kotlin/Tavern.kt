import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

//var playerGold = 10
//var playerSilver = 10

var playerDracoin = 5.00
val dracoinKurs = 1.43

var remainingDragonBreath = 40

fun main(args: Array<String>) {
    placeOrder("shandy, Dragon's Breath, 5.91")
    placeOrder("shandy, Dragon's Breath, 5.91")
    placeOrder("elixir, Shirleys's Temple, 4.12")
}

fun performPurcase(price: Double) {
    displayBalance()
//    val totalPurse = playerGold + (playerSilver / 100.0)
    val totalPurse = playerDracoin * dracoinKurs
    println("Total purse: ${"%.4f".format(totalPurse)}")
    println("Purchasing item for $price")

    val remainingBalance = totalPurse - price
//    println("Remaining balance: ${"%.2f".format(remainingBalance)}")
    println("Remaining balance: ${"%.4f".format(remainingBalance)}")

//    val remainingGold = remainingBalance.toInt()
//    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
//    playerGold = remainingGold
//    playerSilver = remainingSilver
    val remainingDracoin = remainingBalance / dracoinKurs
    playerDracoin = remainingDracoin
    displayBalance()
}

private fun displayBalance() {
//    println("Player's purse balance: Gold: $playerGold, Silver: $playerSilver")
    println("Player's purse balance: Dracoin: ${"%.4f".format(playerDracoin)}")
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf("\'")
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(", ")

    if (!sufficientMoney(price.toDouble())) {
        println("Not sufficient money for the order!")
        return
    }

    println("Madrigal buys a $name ($type) for $price")

    performPurcase(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
        "Madrigal exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "Madrigal says: Thanks for the $name."
    }
    println(phrase)

    if (name == "Dragon's Breath") {
        remainingDragonBreath -= 1
        println("Remaining Dragon's Breath: $remainingDragonBreath")
    }
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }

private fun sufficientMoney(price: Double): Boolean {
//    val totalPurse = playerGold + (playerSilver / 100.0)
    val totalPurse = playerDracoin * dracoinKurs
    return (totalPurse >= price)
}