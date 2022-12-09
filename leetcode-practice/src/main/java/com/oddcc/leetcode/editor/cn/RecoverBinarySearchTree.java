// 99

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.Arrays;

public class RecoverBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new RecoverBinarySearchTree().new Solution();
        solution.recoverTree(TreeNode.constructFromArr(1, 3, null, null, 2));
        solution.recoverTree(TreeNode.constructFromArr(3, 1, 4, null, null, 2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    /**
     * When inorder traversal a BST, the values should be ascending order
     * if we found the values are not ascending, we know something is wrong
     * we marked there wrong nodes
     * because the question says there are exactly two nodes are with wrong value
     * when there are more than 2 nodes marked wrong, we only need to switch the max value node and the min value node
     * to recover the BST
     */
    class Solution {
        private TreeNode current = null;

        private TreeNode maxNode = null;

        private TreeNode minNode = null;

        public void recoverTree(TreeNode root) {
            current = null;
            maxNode = null;
            minNode = null;
            dfs(root);
            int tmp = maxNode.val;
            maxNode.val = minNode.val;
            minNode.val = tmp;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            if (current != null) {
                if (root.val <= current.val) {
                    if (minNode == null) {
                        minNode = root;
                    } else {
                        if (root.val < minNode.val) {
                            minNode = root;
                        }
                    }
                    if (maxNode == null) {
                        maxNode = current;
                    } else {
                        if (current.val > maxNode.val) {
                            maxNode = current;
                        }
                    }
                }
            }
            current = root;
            dfs(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}