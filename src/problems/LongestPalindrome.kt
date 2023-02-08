package org.cmolisee.problems

import org.cmolisee.problems.utils.testIsEqual

/**
 * Given a string s which consists of lowercase or uppercase letters, return the 
 * length of the longest palindrome that can be built with those letters.
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 */
fun longestPalindrome(s: String): Int {
    if (s.length <= 1) return s.length

    var chars = IntArray('z' - 'A' + 1)
    s.forEach { c -> 
        chars[c - 'A']++
    }
    
    return chars.fold(0) { acc, nxt -> 
            acc + nxt - (nxt % 2) 
        }.also {
            return if (it < s.length) it + 1 else it
        }
}

fun main() {
    run {
        testIsEqual(9, longestPalindrome("abccccddeee"))
    }
}
