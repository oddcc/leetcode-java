// 100

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

public class SameTree {
    public static void main(String[] args) {
        Solution solution = new SameTree().new Solution();
        TreeNode n = new TreeNode(1,
                new TreeNode(3,
                        new TreeNode(5,
                                null,
                                new TreeNode(8)
                        ),
                        new TreeNode(6)
                ),
                new TreeNode(2,
                        null,
                        new TreeNode(7,
                                new TreeNode(9),
                                new TreeNode(10)
                        )
                )
        );

        TreeNode t1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode t2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(solution.isSameTree(t1, t2));

        TreeNode t3 = new TreeNode(1, new TreeNode(2), null);
        TreeNode t4 = new TreeNode(1, null, new TreeNode(2));
        System.out.println(solution.isSameTree(t3, t4));

        TreeNode t5 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode t6 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        System.out.println(solution.isSameTree(t5, t6));
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
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (!valid(p, q)) return false;
            if (p == null) return true;
            return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        private boolean valid(TreeNode t1, TreeNode t2) {
            if (t1 == null) return t2 == null;
            return t2 != null;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}