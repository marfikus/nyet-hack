package com.bnr.nyethack
fun main(args: Array<String>) {
//    val player = Player("Madrigal", 100, true, false)
    val player = Player("Madrigal")
    printPlayerStatus(player)
    player.castFireball()
}

private fun printPlayerStatus(player: Player) {
    println(
        "(Aura: ${player.auraColor()})" +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
    )
    println("${player.name} ${player.formatHealthStatus()}")
}
