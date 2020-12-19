// 235

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinarySearchTree().new Solution();
        TreeNode n1 = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))), new TreeNode(8, new TreeNode(7), new TreeNode(9)));
        System.out.println(solution.lowestCommonAncestor(n1, new TreeNode(2), new TreeNode(8)));
        System.out.println(solution.lowestCommonAncestor(n1, new TreeNode(2), new TreeNode(4)));
        TreeNode n2 = new TreeNode(2, new TreeNode(1), null);
        System.out.println(solution.lowestCommonAncestor(n2, new TreeNode(2), new TreeNode(1)));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，两个节点向上遍历
        // 思路2，利用二叉搜索树的性质，通过比较大小，可以确定在遍历过程中遍历的顺序
        // 如果是p, root, q那共同肯定是root
        // 如果是p, q在同一侧则从根节点向所在侧遍历，如果节点n在q、p之间，则答案是n，否则继续判断向哪个方向遍历
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (isMid(root, p, q)) return root;
            // 因为遍历的时候都判断过方向，所以遇到相同p或q就可以可以
            if (root.val == p.val) return p;
            if (root.val == q.val) return q;
            // 在左侧
            if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            // 在右侧
            return lowestCommonAncestor(root.right, p, q);
        }

        private boolean isMid(TreeNode root, TreeNode p, TreeNode q) {
            return (p.val < root.val && root.val < q.val) || (q.val < root.val && root.val < p.val);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}