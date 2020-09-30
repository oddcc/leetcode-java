//Given the root node of a binary search tree (BST) and a value to be inserted i
//nto the tree, insert the value into the BST. Return the root node of the BST aft
//er the insertion. It is guaranteed that the new value does not exist in the orig
//inal BST. 
//
// Note that there may exist multiple valid ways for the insertion, as long as t
//he tree remains a BST after insertion. You can return any of them. 
//
// For example, 
//
// 
//Given the tree:
//        4
//       / \
//      2   7
//     / \
//    1   3
//And the value to insert: 5
// 
//
// You can return this binary search tree: 
//
// 
//         4
//       /   \
//      2     7
//     / \   /
//    1   3 5
// 
//
// This tree is also valid: 
//
// 
//         5
//       /   \
//      2     7
//     / \   
//    1   3
//         \
//          4
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the given tree will be between 0 and 10^4. 
// Each node will have a unique integer value from 0 to -10^8, inclusive. 
// -10^8 <= val <= 10^8 
// It's guaranteed that val does not exist in the original BST. 
// 
// Related Topics 树 
// 👍 122 👎 0


package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

public class InsertIntoABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new InsertIntoABinarySearchTree().new Solution();
//        TreeNode n = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
//        solution.insertIntoBST(n, 5);
        TreeNode n2 = new TreeNode(5, null, new TreeNode(14, new TreeNode(10), new TreeNode(77, null, new TreeNode(95))));
        solution.insertIntoBST(n2, 4);
        System.out.println(n2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 不要求平衡，且插入的一定是个新值，且对二叉树形状没有要求，那么返回的总可以是原来的根
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) return new TreeNode(val);
            insert(root, val);
            return root;
        }

        private void insert(TreeNode root, int val) {
            TreeNode current = root;
            while (current.left != null || current.right != null) {
                if (val > current.val) {
                    if (current.right == null) {
                        current.right = new TreeNode(val);
                        return;
                    }
                    current = current.right;
                } else {
                    if (current.left == null) {
                        current.left = new TreeNode(val);
                        return;
                    }
                    current = current.left;
                }
            }
            TreeNode newNode = new TreeNode(val);
            if (val > current.val) {
                current.right = newNode;
            } else {
                current.left = newNode;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}