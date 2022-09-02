// 687

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

public class LongestUnivaluePath {
    public static void main(String[] args) {
        Solution solution = new LongestUnivaluePath().new Solution();
        System.out.println(solution.longestUnivaluePath(TreeNode.constructFromArr(5, 4, 5, 1, 1, null, 5)));
        System.out.println(solution.longestUnivaluePath(TreeNode.constructFromArr(1, 4, 5, 4, 4, null, 5)));
        System.out.println(solution.longestUnivaluePath(TreeNode.constructFromArr(1, 1, 1, 1, 1, null, 1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // The important thing is the longest path must go through a root. Maybe not the root of the whole tree, but of a subtree
    class Solution {
        private int max = 0;

        public int longestUnivaluePath(TreeNode root) {
            dfs(root);
            return max;
        }

        private int dfs(TreeNode root) {
            int longestInThisTree = 0;
            if (root == null) {
                return longestInThisTree;
            }

            int l = root.left == null ? 0 : dfs(root.left);
            int r = root.right == null ? 0 : dfs(root.right);

            if (root.left != null && root.left.val == root.val) {
                longestInThisTree += l + 1;
            }
            if (root.right != null && root.right.val == root.val) {
                longestInThisTree += r + 1;
            }
            max = Math.max(longestInThisTree, max);
            int includeL = (root.left != null && root.left.val == root.val) ? l + 1 : 0;
            int includeR = (root.right != null && root.right.val == root.val) ? r + 1 : 0;

            return Math.max(includeL, includeR);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}