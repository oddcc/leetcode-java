// 222

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new CountCompleteTreeNodes().new Solution();
        System.out.println(solution.countNodes(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int count = 0;

        // 思路1，返回完全二叉树有多少个节点，用深度遍历或广度遍历计数
        public int countNodes(TreeNode root) {
            dfs(root);
            return count;
        }

        private void dfs(TreeNode root) {
            if (root == null) return;
            count++;
            if (root.left != null) dfs(root.left);
            if (root.right != null) dfs(root.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}