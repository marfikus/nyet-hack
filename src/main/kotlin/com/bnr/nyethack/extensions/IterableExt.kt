package com.bnr.nyethack.extensions

// добавил своё расширение просто для тренировки, хотя уже есть готовый random в kotlin
fun <T> Iterable<T>.myRandom(): T = this.shuffled().first()