// 101

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
        TreeNode n = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(4)
                ),
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(3)
                )
        );
        System.out.println(solution.isSymmetric(n));
//        TreeNode n1 = new TreeNode(1,
//                new TreeNode(2,
//                        null,
//                        new TreeNode(3)
//                ),
//                new TreeNode(2,
//                        null,
//                        new TreeNode(3)
//                )
//        );
//        System.out.println(solution.isSymmetric(n1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return walkAtSameTime(root.left, root.right);
        }

        private boolean walkAtSameTime(TreeNode left, TreeNode right) {
            if (!valid(left, right)) return false;
            if (left == null) return true;
            return (left.val == right.val) && walkAtSameTime(left.left, right.right) && walkAtSameTime(left.right, right.left);
        }

        private void walk(TreeNode root) {
            if (root == null) return;
            System.out.println(root.val);
            walk(root.left);
            walk(root.right);
        }

        private boolean valid(TreeNode left, TreeNode right) {
            if (left == null) return right == null;
            return right != null;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}