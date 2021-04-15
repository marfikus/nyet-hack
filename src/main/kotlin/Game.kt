
fun main(args: Array<String>) {
    val playerName = "Marginal"
    val playerHealth = 99
    val isBlessed = true
    val isImmortal = false

    val auraColor = auraColor(isBlessed, playerHealth, isImmortal)

    val healthStatus = formatHealthStatus(playerHealth, isBlessed)

    printPlayerStatus(auraColor, isBlessed, playerName, healthStatus)

    castFireball()
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
): String {
    val auraVisible = isBlessed && playerHealth > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
}

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

private fun castFireball(numFireballs: Int = 2) =
    println("A glass of Fireball springs into existence. (x$numFireballs)")
