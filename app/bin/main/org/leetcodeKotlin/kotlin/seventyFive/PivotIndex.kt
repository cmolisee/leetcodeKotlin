package org.leetcodeKotlin.kotlin.seventyFive
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
class PivotIndex {
    fun pivotIndex(nums: IntArray): Int {
        var sum = nums.sum()
        var leftSum = 0
        for ((i, v) in nums.withIndex()) {
            if (leftSum == sum - leftSum - v) {
                return i
            }

            leftSum += v
        }
        
        return -1
    }

    operator fun invoke(nums: IntArray): Int = pivotIndex(nums)

}