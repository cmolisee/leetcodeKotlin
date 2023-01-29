package org.leetcodeKotlin.kotlin.seventyFive
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
class IsIsomorphic {
    // 1 <= s.length <= 5 * 104
    // t.length == s.length
    // s and t consist of any valid ascii character.
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

    operator fun invoke(s: String, t: String): Boolean = isIsomorphic(s, t)
}