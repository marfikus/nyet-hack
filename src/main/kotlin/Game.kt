
fun main(args: Array<String>) {
    val playerName = "Marginal"
    val playerHealth = 99
    val isBlessed = true
    val isImmortal = false
    var drinkLevel = 0
    val MAX_DRINK_LEVEL = 50

    val auraColor = auraColor(isBlessed, playerHealth, isImmortal)

    val healthStatus = formatHealthStatus(playerHealth, isBlessed)

    printPlayerStatus(auraColor, isBlessed, playerName, healthStatus)

    val drinkDiff = castFireball()
    drinkLevel = incDrinkLevel(drinkLevel, MAX_DRINK_LEVEL, drinkDiff)
    showDrinkLevel(drinkLevel)
}

private fun incDrinkLevel(drinkLevel: Int, maxDrinkLevel: Int, newDiff: Int): Int {
    var newDrinkLevel = drinkLevel + newDiff
    if (newDrinkLevel >= maxDrinkLevel) {
       newDrinkLevel = maxDrinkLevel
    }
    return newDrinkLevel
}

private fun showDrinkLevel(drinkLevel: Int) {
//    println("drinkLevel: $drinkLevel")
    val drinkState = when (drinkLevel) {
        in 1..10 -> "Tipsy"
        in 11..20 -> "Sloshed"
        in 21..30 -> "Soused"
        in 31..40 -> "Stewed"
        in 41..50 -> "Toasted"
        else -> "undefined state"
    }
    println("drinkState: $drinkState")
}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    playerName: String,
    healthStatus: String
) {
    println(
        "(Aura: $auraColor)" +
                "(Blessed: ${if (isBlessed) "YES" else "NO"})"
    )
    println("$playerName $healthStatus")
}

private fun auraColor(
    isBlessed: Boolean,
    playerHealth: Int,
    isImmortal: Boolean
) = if (isBlessed && playerHealth > 50 || isImmortal) "GREEN" else "NONE"

private fun formatHealthStatus(playerHealth: Int, isBlessed: Boolean) =
    when (playerHealth) {
        100 -> "is in excellent condition"
        in 90..99 -> "has a few scratches"
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly"
        } else {
            "has some minor wounds"
        }
        in 15..74 -> "looks pretty hurt"
        else -> "is awful"
    }

private fun castFireball(numFireballs: Int = 2): Int {
    println("A glass of Fireball springs into existence. (x$numFireballs)")
    return numFireballs * 4
}
