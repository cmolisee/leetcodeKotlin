package org.leetcodeKotlin.kotlin.seventyFive
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
class RunningSum1D {
    fun runningSum(nums: IntArray): IntArray {
        var runningSum: Int = 0
        var res: IntArray = IntArray(nums.size)
        for ((i, v) in nums.withIndex()) {
            runningSum += v
            res[i] = runningSum
        }
        return res
    }

    operator fun invoke(nums: IntArray): IntArray = runningSum(nums)
}