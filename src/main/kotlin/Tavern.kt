import java.io.File
import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10

val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("/home/alex/IdeaProjects/NyetHack/src/data/tavern-menu-data.txt")
    .readText()
    .split("\n")

fun main(args: Array<String>) {
    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back playing cards.")
    } else {
        println("The tavern master says: Eli isn't here.")
    }

    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    } else {
        println("The tavern master says: Nay, they departed hour ago.")
    }

//    placeOrder("elixir, Shirleys's Temple, 4.12")

    (0..9).forEach {
        val first = patronList.random()
        val last = lastName.random()
        val name = "$first $last"
//        println(name)
        uniquePatrons.add(name)
    }
    println(uniquePatrons)


    var orderCount = 0
    while (orderCount < 10) {
        placeOrder(uniquePatrons.random(), menuList.random())
        orderCount++
    }

    displayMenu()
}

fun performPurcase(price: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")

    val remainingBalance = totalPurse - price
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}

private fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold, Silver: $playerSilver")
}

private fun displayMenu() {
    val header = "*** Welcome to $TAVERN_NAME ***\n"
    var shandy = "${decorAndAlignCaption(header, "shandy")}\n"
    var elixir = "${decorAndAlignCaption(header, "elixir")}\n"
    var meal = "${decorAndAlignCaption(header, "meal")}\n"
    var desert = "${decorAndAlignCaption(header, "desert dessert")}\n"

    println(header)
    menuList.forEach { menuItem ->
        var (type, name, price) = menuItem.split(",")
        var dotsLength = header.length - (name.length + price.length) - 1

        if (dotsLength < 2) {
            if (name.length < header.length) {
                dotsLength = header.length - price.length - 1
                val dotsForCurrent = createCharString('.', header.length - name.length - 1)
                name += "$dotsForCurrent\n"
            } else { // если имя очень длинное, то разбиваем его на строки
                val splittedName = name.split(" ")
                var nameList = mutableListOf<String>()
                var str = ""
                var index = -1
                splittedName.forEach {
                    index ++
                    if ("$str $it".trimStart().length < header.length) {
                        str = "$str $it".trimStart()
                    } else {
                        nameList.add(str)
                        str = it
                    }
                    if (index == splittedName.size - 1){
                        nameList.add(str)
                    }
                }
                // правим последнюю строку списка
                var lastStr = nameList.last()
                dotsLength = header.length - (lastStr.length + price.length) - 1
                if (dotsLength < 2) {
                    dotsLength = header.length - price.length - 1
                    val dotsForCurrent = createCharString('.', header.length - lastStr.length - 1)
                    lastStr += "$dotsForCurrent\n"
                    nameList[nameList.size - 1] = lastStr
                }
                // соединяем список обратно в одну строку
                name = ""
                index = -1
                nameList.forEach {
                    index ++
                    name += it
                    if (index != nameList.size - 1){
                        name += "\n"
                    }
                }
            }
        }

        val dots = createCharString('.', dotsLength)
//        println("%s%s%s".format(name.capitalize(), dots, price))

        when (type) {
            "shandy" -> shandy += "%s%s%s\n".format(name.capitalize(), dots, price)
            "elixir" -> elixir += "%s%s%s\n".format(name.capitalize(), dots, price)
            "meal" -> meal += "%s%s%s\n".format(name.capitalize(), dots, price)
            "desert dessert" -> desert += "%s%s%s\n".format(name.capitalize(), dots, price)
        }
    }

    println(shandy.trimEnd('\n'))
    println(elixir.trimEnd('\n'))
    println(meal.trimEnd('\n'))
    println(desert.trimEnd('\n'))
}

private fun createCharString(char: Char, dotsLength: Int): String {
    var dots = ""
    (1..dotsLength).forEach {
        dots += char
    }
    return dots
}

private fun decorAndAlignCaption(mainCaption: String, subCaption: String): String {
    val subCaptionDecorated = "~[$subCaption]~"
    val spacesLength = (mainCaption.length - subCaptionDecorated.length) / 2
    val spaces = createCharString(' ', spacesLength)
    return "$spaces$subCaptionDecorated$spaces"
}

private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf("\'")
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(",")
    println("$patronName buys a $name ($type) for $price")

//    performPurcase(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "$patronName says: Thanks for the $name."
    }
    println(phrase)
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