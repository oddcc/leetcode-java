// 113

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static void main(String[] args) {
        Solution solution = new PathSumII().new Solution();
        System.out.println(solution.pathSum(TreeNode.constructFromArr(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22));
        System.out.println(solution.pathSum(TreeNode.constructFromArr(1, 2, 3), 5));
        System.out.println(solution.pathSum(TreeNode.constructFromArr(-2, null, -3), -5));
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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(root, targetSum, 0, ans, path);
            return ans;
        }

        private void dfs(TreeNode root, int targetSum, int sum, List<List<Integer>> ans, List<Integer> path) {
            if (root == null) {
                return;
            }
            sum += root.val;
            if (sum == targetSum && isLeaf(root)) {
                path.add(root.val);
                ans.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                return;
            }
            path.add(root.val);
            dfs(root.left, targetSum, sum, ans, path);
            dfs(root.right, targetSum, sum, ans, path);
            path.remove(path.size() - 1);
        }

        private boolean isLeaf(TreeNode root) {
            if (root == null) {
                return false;
            }
            return root.left == null && root.right == null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}