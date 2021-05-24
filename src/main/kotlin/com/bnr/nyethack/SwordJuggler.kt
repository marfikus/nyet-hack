package com.bnr.nyethack

import java.lang.Exception
import java.lang.IllegalStateException

fun main(args: Array<String>) {
    var swordJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3

    if (isJugglingProficient) {
        swordJuggling = 2
    }

    try {
        proficiencyCheck(swordJuggling)
        swordJuggling = swordJuggling!!.plus(1)
    } catch (e: Exception) {
        println(e)
    }

    println("You juggle $swordJuggling swords!")
}


fun proficiencyCheck(swordJuggling: Int?) {
//    swordJuggling ?: throw com.bnr.nyethack.UnskilledSwordJugglerException()
    checkNotNull(swordJuggling, { "com.bnr.nyethack.Player can not juggle swords!" })
}


class UnskilledSwordJugglerException() :
    IllegalStateException("com.bnr.nyethack.Player can not juggle swords!")
