package org.cmolisee.problems

import org.cmolisee.problems.utils.assertTrueWithMessage
import org.cmolisee.problems.utils.assertFalseWithMessage

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by 
 * deleting some (can be none) of the characters without disturbing the relative positions 
 * of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */
fun isSubsequence(s: String, t: String): Boolean {
    if (s.length > t.length) return false
    if (s.isEmpty()) return true

    var i = s.length - 1
    for (c in t.reversed()) {
        if (i < 0) return true
        if (c == s.get(i)) --i
    }
    
    return i < 0
}

fun main() {
    run {
        val arg1 = "axc"
        val arg2 = "abc"
        val expected1 = "ahbgdc"
        val expected2 = "ahbgdc"
        assertFalseWithMessage(isSubsequence(arg1, expected1), "${arg1} is not a subsequence of ${expected1}")
        assertTrueWithMessage(isSubsequence(arg2, expected2), "${arg2} is a subsequence of ${expected2}")
    }
}