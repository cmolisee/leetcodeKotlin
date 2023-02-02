package org.cmolisee.problems

import org.cmolisee.problems.utils.assertTrueWithMessage
import org.cmolisee.problems.utils.assertFalseWithMessage

/**
 * Given an integer array data representing the data, return whether it is a valid UTF-8 
 * encoding (i.e. it translates to a sequence of valid UTF-8 encoded characters).
 * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
 * For a 1-byte character, the first bit is a 0, followed by its Unicode code.
 * For an n-bytes character, the first n bits are all one's, the n + 1 bit is 0, followed 
 * by n - 1 bytes with the most significant 2 bits being 10.
 * This is how the UTF-8 encoding would work:
 * 
 * Number of Bytes     |        UTF-8 Octet Sequence
 *                     |              (binary)
 * --------------------+-----------------------------------------
 *         1           |   0xxxxxxx
 *         2           |   110xxxxx 10xxxxxx
 *         3           |   1110xxxx 10xxxxxx 10xxxxxx
 *         4           |   11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 */
fun validUtf8(data: IntArray): Boolean {
    var bitCounter = 0
    for (v in data) {
        if (bitCounter > 0) {
            if (v < 128 || v >= 192) return false // not 10xxxxxx
            --bitCounter
        } else {
            if (v >= 128 && v < 192) return false // 10xxxxxx
            if (v >= 248) return false // 11111xxx
            if (v >= 192 && v < 224) bitCounter = 1 // 110xxxxx
            if (v >= 224 && v < 240) bitCounter = 2 // 1110xxxx
            if (v >= 240 && v < 248) bitCounter = 3 // 11110xxx
        }
    }
    return bitCounter == 0
}

fun main() {
    run {
        val arg1 = intArrayOf(197,130,1)
        val arg2 = intArrayOf(235,140,4)
        assertTrueWithMessage(validUtf8(arg1), "[${arg1.joinToString()}] is valid UTF-8")
        assertFalseWithMessage(validUtf8(arg2), "[${arg2.joinToString()}] is valid UTF-8")
    }
}