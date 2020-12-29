// 543

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
        TreeNode n1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(solution.diameterOfBinaryTree(n1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    // 思路1，一条路径，必定是通过某个节点的路径，如果以这个节点为根，则路径长度就是左子树的高加上右子树的高
    class Solution {
        int ans = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            getDepth(root, 0);
            return ans;
        }

        private int getDepth(TreeNode root, int depth) {
            if (root == null) {
                return depth;
            }
            int leftDepth = getDepth(root.left, depth);
            int rightDepth = getDepth(root.right, depth);
            ans = Math.max(ans, leftDepth + rightDepth);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}