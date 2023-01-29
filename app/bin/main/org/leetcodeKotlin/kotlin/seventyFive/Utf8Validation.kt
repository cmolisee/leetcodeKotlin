package org.leetcodeKotlin.kotlin.seventyFive
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
class Utf8Validation {
    // 1 <= data.length <= 2 * 104
    // 0 <= data[i] <= 255

    //   Number of Bytes   |        UTF-8 Octet Sequence
    //                     |              (binary)
    // --------------------+-----------------------------------------
    //         1           |   0xxxxxxx
    //         2           |   110xxxxx 10xxxxxx
    //         3           |   1110xxxx 10xxxxxx 10xxxxxx
    //         4           |   11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
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

    operator fun invoke(data: IntArray): Boolean = validUtf8(data)
}