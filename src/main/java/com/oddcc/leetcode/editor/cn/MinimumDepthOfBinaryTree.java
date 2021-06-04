// 111
package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
        TreeNode n1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(solution.minDepth(n1));
        TreeNode n2 = new TreeNode(1, new TreeNode(2), null);
        System.out.println(solution.minDepth(n2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        int min = Integer.MAX_VALUE;

        public int minDepth(TreeNode root) {
            // 主要是题意不清楚，空结点应该返回0，没有子树的话，返回1，以此类推
            if (root == null) return 0;
            walk(root, 1);
            return min;
        }

        private void walk(TreeNode node, int depth) {
            // 每次向下访问都带上当前的深度，当到叶子结点时，比较一下记录结果
            if (node.left == null && node.right == null) {
//                System.out.println("到底啦！" + node.val + " " + depth);
                if (depth < min) {
                    min = depth;
                }
                return;
            }
            if (node.left != null) {
                walk(node.left, depth + 1);
            }
            if (node.right != null) {
                walk(node.right, depth + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}