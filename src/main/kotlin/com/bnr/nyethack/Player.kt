package com.bnr.nyethack

class Player {
    var name = "madrigal"
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }

    var playerHealth = 99
    val isBlessed = true
    private val isImmortal = false

    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence. (x$numFireballs)")

    fun auraColor(
    ): String {
        val auraVisible = isBlessed && playerHealth > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }

    fun formatHealthStatus() =
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
}