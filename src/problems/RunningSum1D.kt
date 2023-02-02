package org.cmolisee.problems

import org.cmolisee.problems.utils.assertContentEqualsWithMessage

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
        val arg1 = intArrayOf(1,2,3,4)
        val arg2 = intArrayOf(1,1,1,1,1)
        val expected1 = intArrayOf(1,3,6,10)
        val expected2 = intArrayOf(1,2,3,4,5)
        
        assertContentEqualsWithMessage(expected1, runningSum(arg1), "Running sum of [${arg1.joinToString()}] is [${expected1.joinToString()}]")
        assertContentEqualsWithMessage(expected2, runningSum(arg2), "Running sum of [${arg2.joinToString()}] is [${expected2.joinToString()}]")
    }
}