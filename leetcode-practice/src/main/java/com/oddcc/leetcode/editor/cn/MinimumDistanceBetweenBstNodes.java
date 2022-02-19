// 783

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumDistanceBetweenBstNodes {
    public static void main(String[] args) {
        Solution solution = new MinimumDistanceBetweenBstNodes().new Solution();
        System.out.println(solution.minDiffInBST(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6))));
        System.out.println(solution.minDiffInBST(new TreeNode(1, new TreeNode(0), new TreeNode(48, new TreeNode(12), new TreeNode(49)))));
        System.out.println(solution.minDiffInBST(new TreeNode(27, null, new TreeNode(34, null, new TreeNode(58, new TreeNode(50, new TreeNode(44), null), null)))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，对于root来说，如果知道左子树中的最大值，右子树中的最小值，就能算出最小距离
        // 因为右子树中都大于root，除了最小值之外，其他值的距离都会更大
        // 左子树中都小于root，除了最大值之外，其他值的距离都会更大
        // 一颗BST中，最大值为最右子节点，最小值为最左子节点
        // 思路2，中序遍历可以以递增的顺序遍历BST，那么最小距离只可能出现在相邻（遍历顺序）的两个节点中
        public int minDiffInBST(TreeNode root) {
            int ans = Integer.MAX_VALUE;
            Integer pre = null;
            Deque<TreeNode> stack = new LinkedList<>();
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                if (!stack.isEmpty()) {
                    root = stack.pop();
                    if (pre != null) {
                        ans = Math.min(ans, Math.abs(pre - root.val));
                    }
                    pre = root.val;
                    root = root.right;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}