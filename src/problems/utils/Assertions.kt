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

fun assertLinkedListWithMessage(actual: ListNode?, expected: ListNode?, successMessage: String?) {
    try {
        assertEquals(expected, actual, "$ansiRed assertLinkedListWithMessage Failed $ansiWhite")

        if (actual?.next != null && expected?.next != null) {
            assertLinkedListWithMessage(expected.next, actual.next, successMessage)
        } else if (actual?.next != null || expected?.next != null) {
            throw Exception("$ansiRed assertLinkedListWithMessage Failed $ansiWhite")
        }
    } catch (e: Exception) {
        println(e.message)
        throw e
    }

    println("$ansiGreen PASS: " + (successMessage ?: "Success") + "$ansiWhite")
}