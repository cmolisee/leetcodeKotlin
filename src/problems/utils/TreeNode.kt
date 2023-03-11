package org.cmolisee.problems.utils

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    companion object {
        fun from(arr: IntArray): TreeNode {
            var root = insertNode(arr, 0, 1)
            
            if (root == null) return TreeNode(-1)
            return root
        }

        private fun insertNode(arr: IntArray, index: Int, level: Int): TreeNode? {
            val maxLevelIndex = (1 shl level) - 1
            val offset = if (maxLevelIndex > arr.size - 1) (maxLevelIndex - arr.size) else 0
            val i = index - offset
            
            if (offset > level) return null
            if (i != 1 && (i >= arr.size || arr[i] < 0)) return null

            val node = TreeNode(arr[i])

            node.left = insertNode(arr, (index * 2 + 1), level + 1)
            node.right = insertNode(arr, (index * 2 + 2), level + 1)
            return node
        }
    }

    // override fun toString(): String {
    //     // implment toString()
    // }
}