package org.cmolisee.problems

import org.cmolisee.problems.utils.testContentIsEqual

/**
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 * 
 * Return the running sum of nums.
 */
fun runningSum(nums: IntArray): IntArray {
    var runningSum: Int = 0
    var res: IntArray = IntArray(nums.size)
    for ((i, v) in nums.withIndex()) {
        runningSum += v
        res[i] = runningSum
    }
    return res
}

fun main() {
    run {
        testContentIsEqual(intArrayOf(1,3,6,10), runningSum(intArrayOf(1,2,3,4)))
        testContentIsEqual(intArrayOf(1,2,3,4,5), runningSum(intArrayOf(1,1,1,1,1)))
    }
}