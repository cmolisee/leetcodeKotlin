package org.cmolisee.problems.utils

import kotlin.test.assertTrue
import kotlin.test.assertFalse
import kotlin.test.assertEquals
import kotlin.test.assertContentEquals

private val ansiGreen = "\u001B[32m"
private val ansiRed = "\u001B[31m"
val ansiWhite = "\u001B[37m"

fun testIsTrue(actual: Boolean) {
    try {
        assertTrue(actual, "$ansiRed Failed: expected (true), actual ($actual) $ansiWhite")
    } catch(e: Exception) {
        println(e.message)
        throw e
    }

    println("$ansiGreen PASS: expected (true), actual ($actual) $ansiWhite")
}

fun testIsFalse(actual: Boolean) {
    try {
        assertFalse(actual, "$ansiRed Failed: expected (false), actual ($actual) $ansiWhite")
    } catch(e: Exception) {
        println(e.message)
        throw e
    }

    println("$ansiGreen PASS: expected (false), actual ($actual) $ansiWhite")
}

fun <T> testIsEqual(expected: T, actual: T) {
    try {
        assertEquals(expected, actual, "$ansiRed Failed: expected ($expected), actual ($actual) $ansiWhite")
    } catch (e: Exception) {
        println(e.message)
        throw e
    }

    println("$ansiGreen PASS: expected ($expected), actual ($actual) $ansiWhite")
}

fun testContentIsEqual(expected: IntArray, actual: IntArray) {
    try {
        assertContentEquals(expected, actual, "$ansiRed Failed: expected [ ${expected.joinToString()} ], actual [ ${actual.joinToString()} ] $ansiWhite")
    } catch (e: Exception) {
        println(e.message)
        throw e
    }

    println("$ansiGreen PASS: expected [ ${expected.joinToString()} ], actual [ ${actual.joinToString()} ] $ansiWhite")
}

fun testLinkedListIsEqual(expected: ListNode?, actual: ListNode?) {
    try {
        _testLinkedListIsEqual(expected, actual)
    } catch(e: Exception) {
        println(e.message)
        return
    }
    println("$ansiGreen PASS: expected [ $expected ], actual [ $actual ] $ansiWhite")
}

private fun _testLinkedListIsEqual(expected: ListNode?, actual: ListNode?) {
    val errorMessage: String = "$ansiRed Failed: expected [ $expected ], actual [ $actual ] $ansiWhite"
    assertEquals(expected?.`val`, actual?.`val`,  errorMessage)

    if (
        actual?.next == null && expected?.next != null ||
        actual?.next != null && expected?.next == null
    ) {
        throw Exception(errorMessage) 
    }

    if (expected?.next != null && actual?.next != null) {
        _testLinkedListIsEqual(expected.next, actual.next)
    }
}