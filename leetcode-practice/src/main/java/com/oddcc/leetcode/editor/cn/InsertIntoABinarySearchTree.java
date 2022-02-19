// 701

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