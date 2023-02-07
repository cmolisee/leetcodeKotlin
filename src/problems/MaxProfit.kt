package org.cmolisee.problems

import org.cmolisee.problems.utils.testIsEqual

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a 
 * different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, 
 * return 0.
 */
fun maxProfit(prices: IntArray): Int {
    var low  = Int.MAX_VALUE
    var maxProfit = 0
    
    // dependent on buying at the lowest possible value
    for (i in 0..prices.size - 1) { 
        low = minOf(low, prices.get(i))
        maxProfit = maxOf(maxProfit, prices.get(i) - low)
    }

    return maxProfit
}

fun main() {
    run {
        testIsEqual(5, maxProfit(intArrayOf(7,1,5,3,6,4)))
    }
}
