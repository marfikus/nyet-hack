package com.bnr.nyethack
fun main(args: Array<String>) {
//    val player = Player("Madrigal", 100, true, false)
    val player = Player("Madrigal")
    printPlayerStatus(player)
    player.castFireball()

//    var currentRoom = Room("Foyer")
    var currentRoom = TownSquare()

    println(currentRoom.description())
    println(currentRoom.load())
}

private fun printPlayerStatus(player: Player) {
    println(
        "(Aura: ${player.auraColor()})" +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
    )
    println("${player.name} ${player.formatHealthStatus()}")
}
