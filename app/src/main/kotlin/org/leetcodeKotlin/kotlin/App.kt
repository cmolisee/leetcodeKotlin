package org.leetcodeKotlin.kotlin

import mu.KotlinLogging
import org.leetcodeKotlin.kotlin.seventyFive.PivotIndex

private val logger = KotlinLogging.logger {} 
class App {
    val greeting: String
        get() {
            logger.info("hello world")
            return "Hello World!"
        }
}

fun main() {
    println(App().greeting)
    PivotIndex().pivotIndex(intArrayOf(-1,-1,0,0,-1,-1))
}
