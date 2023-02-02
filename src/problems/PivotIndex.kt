package org.cmolisee.problems

import org.cmolisee.problems.utils.assertTrueWithMessage
import org.cmolisee.problems.utils.assertEqualsWithMessage

/**
 * Given an array of integers nums, calculate the pivot index of this array.
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
 * Return the leftmost pivot index. If no such index exists, return -1.
 */
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

fun main() {
    run {
        val a = intArrayOf(1,2,3)
        val b = intArrayOf(2,1,-1)
        assertEqualsWithMessage(-1, pivotIndex(a), "Pivot index of [${a.joinToString()}] is -1")
        assertEqualsWithMessage(0, pivotIndex(b), "Pivot index of [${b.joinToString()}] is 0")
    }
}