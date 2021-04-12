
fun main(args: Array<String>) {
    val playerName = "Marginal"
    val playerHealth = 99
    val isBlessed = true
    val isImmortal = false

    val auraVisible = isBlessed && playerHealth > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
//    println(auraColor)

    val healthStatus = when (playerHealth) {
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

    println("(Aura: $auraColor)" +
            "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$playerName $healthStatus")
}