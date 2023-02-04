package org.cmolisee.problems.utils

import kotlin.test.assertTrue
import kotlin.test.assertFalse
import kotlin.test.assertEquals
import kotlin.test.assertContentEquals

private val ansiGreen = "\u001B[32m"
private val ansiRed = "\u001B[31m"
val ansiWhite = "\u001B[37m"

fun assertTrueWithMessage(actual: Boolean, successMessage: String?) {
    try {
        assertTrue(actual, "$ansiRed assertTrueWithMessage Failed $ansiWhite")
    } catch(e: Exception) {
        println(e.message)
        throw e
    }

    println("$ansiGreen PASS: " + (successMessage ?: "Success") + "$ansiWhite")
}

fun assertFalseWithMessage(actual: Boolean, successMessage: String?) {
    try {
        assertFalse(actual, "$ansiRed assertFalseWithMessage Failed $ansiWhite")
    } catch(e: Exception) {
        println(e.message)
        throw e
    }

    println("$ansiGreen PASS: " + (successMessage ?: "Success") + "$ansiWhite")
}

fun <T> assertEqualsWithMessage(expected: T, actual: T, successMessage: String?) {
    try {
        assertEquals(expected, actual, "$ansiRed assertEqualsWithMessage Failed $ansiWhite")
    } catch (e: Exception) {
        println(e.message)
        throw e
    }

    println("$ansiGreen PASS: " + (successMessage ?: "Success") + "$ansiWhite")
}

fun assertContentEqualsWithMessage(expected: IntArray, actual: IntArray, successMessage: String?) {
    try {
        assertContentEquals(expected, actual, "$ansiRed assertContentEqualsWithMessage Failed $ansiWhite")
    } catch (e: Exception) {
        println(e.message)
        throw e
    }

    println("$ansiGreen PASS: " + (successMessage ?: "Success") + "$ansiWhite")
}

fun assertLinkedListEquals(expected: ListNode?, actual: ListNode?): String {
    assertEquals(expected?.`val`, actual?.`val`, "$ansiRed ${expected?.`val`} DNE ${actual?.`val`} $ansiWhite")

    if (
        actual?.next == null && expected?.next != null ||
        actual?.next != null && expected?.next == null
    ) {
        throw Exception("$ansiRed Failed: Linked Lists do not have the same size $ansiWhite \n") 
    }

    if (actual?.next != null && expected?.next != null) {
        assertLinkedListEquals(expected.next, actual.next)
    }
    
    return "$ansiGreen PASS: Expected ListNode is equal too Actual ListNode $ansiWhite"
}

fun assertLinkedList(expected: ListNode?, actual: ListNode?) {
    // println(expected?.`val`)
    // println(actual?.`val`)
    assertEquals(expected?.`val`, actual?.`val`)

    if (
        actual?.next == null && expected?.next != null ||
        actual?.next != null && expected?.next == null
    ) {
        throw Exception("$ansiRed Failed: Linked Lists do not have the same size $ansiWhite \n") 
    }

    if (expected?.next != null && actual?.next != null) {
        assertLinkedList(expected.next, actual.next)
    }

    return
}