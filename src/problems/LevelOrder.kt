package org.cmolisee.problems

import java.util.*
import org.cmolisee.problems.utils.testIsEqual
import org.cmolisee.problems.utils.TreeNode

/**
 * Given the root of a binary tree, return the level order traversal 
 * of its nodes' values. (i.e., from left to right, level by level).
 * 
 * Constraints:
 *  The number of nodes in the tree is in the range [0, 2000].
 *  -1000 <= Node.val <= 1000
 */
fun levelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) {
        return listOf(emptyList());
    }

    val levelOrderList = mutableListOf<List<Int>>()
    var currentLevel = mutableListOf<TreeNode>()
    var dq = ArrayDeque<TreeNode>()

    dq.offer(root)
    while (dq.isNotEmpty()) {
        while (dq.isNotEmpty()) {
            currentLevel.add(dq.poll())
        }

        levelOrderList.add(currentLevel.map { it.`val` }.toList())
        for (node in currentLevel) {
            if (node.left != null) dq.offer(node.left)
            if (node.right != null) dq.offer(node.right)
        }
        currentLevel.clear()
    }
    return levelOrderList
}

fun main() {
    run {
        print(levelOrder(TreeNode.from(intArrayOf(1,2,2,-1,-1,3,3,4,4,-1,4))));
    }
}
