package org.cmolisee.problems

import org.cmolisee.problems.utils.testIsTrue
import org.cmolisee.problems.utils.testIsFalse

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
        testIsFalse(isSubsequence("axc", "ahbgdc"))
        testIsTrue(isSubsequence("abc", "ahbgdc"))
    }
}