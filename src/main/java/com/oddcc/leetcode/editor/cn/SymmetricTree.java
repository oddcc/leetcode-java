//Given a binary tree, check whether it is a mirror of itself (ie, symmetric aro
//und its center). 
//
// For example, this binary tree [1,2,2,3,4,4,3] is symmetric: 
//
// 
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// But the following [1,2,2,null,3,null,3] is not: 
//
// 
//    1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// Follow up: Solve it both recursively and iteratively. 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1037 👎 0


package com.oddcc.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}