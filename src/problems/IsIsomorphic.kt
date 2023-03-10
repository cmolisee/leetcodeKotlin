package org.cmolisee.problems

import org.cmolisee.problems.utils.testIsTrue
import org.cmolisee.problems.utils.testIsFalse

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving 
 * the order of characters. No two characters may map to the same character, but a character 
 * may map to itself.
 */
fun isIsomorphic(s: String, t: String): Boolean {
    var m1: MutableMap<Char, Char> = mutableMapOf()
    var m2: MutableMap<Char, Boolean> = mutableMapOf()

    for (i in s.indices) {
        var c1 = s.get(i)
        var c2 = t.get(i)

        if (m1.containsKey(c1)) {
            if (m1.get(c1) != c2) { // mismatch characters
                return false
            }
        } else {
            if (m2.containsKey(c2)) { // char in t but not s
                return false
            } else {
                m1.put(c1, c2)
                m2.put(c2, true)
            }
        }
    }

    return true
}

fun main() {
    run {
        testIsTrue(isIsomorphic("egg", "add"))
        testIsFalse(isIsomorphic("foo", "bar"))
    }
}