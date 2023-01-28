package com.test.presentation.fakes

import java.util.*
import kotlin.random.Random

object FakeValueFactory {


    fun randomString(): String {
        return UUID.randomUUID().toString()
    }

    fun randomInt(): Int {
        return Random.nextInt()
    }

    fun randomInt(until: Int): Int {
        return Random.nextInt(until)
    }

    fun randomLong(): Long {
        return Random.nextLong()
    }

    fun randomDouble(): Double {
        return Random.nextDouble()
    }

    fun randomBoolean(): Boolean {
        return Random.nextBoolean()
    }


}