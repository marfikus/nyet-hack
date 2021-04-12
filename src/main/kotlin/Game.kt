import kotlin.math.pow

fun main(args: Array<String>) {
    val playerName = "Marginal"
    val playerHealth = 59
    val isBlessed = true
    val isImmortal = false

    val auraVisible = isBlessed && playerHealth > 50 || isImmortal
    val karma = (Math.random().pow((110 - playerHealth) / 100.0) * 20).toInt()
    println(karma)
    val auraColor = if (auraVisible) {
        when (karma) {
            in 0..5 -> "RED"
            in 6..10 -> "ORANGE"
            in 11..15 -> "PURPLE"
            in 16..20 -> "GREEN"
            else -> "NONE"
        }
    } else "NONE"

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