package org.leetcodeKotlin.kotlin.seventyFive
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
class IsSubsequence {
    // 0 <= s.length <= 100
    // 0 <= t.length <= 104
    // s and t consist only of lowercase English letters.
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

    // Less efficient
    fun isSubsequenceRecursive(s: String, t: String): Boolean {
        if (s.length > t.length) return false
        if (s.isEmpty()) return true 
        if (!t.contains(s.first())) return false

        return isSubsequence(s.substring(1), t.substring(t.indexOf(s.first()) + 1))
    }

    operator fun invoke(s: String, t: String): Boolean = isSubsequence(s, t)
}