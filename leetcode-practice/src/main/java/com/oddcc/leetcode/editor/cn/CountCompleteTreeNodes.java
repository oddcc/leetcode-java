// 222

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.*;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new CountCompleteTreeNodes().new Solution();
        System.out.println(solution.countNodes(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，返回完全二叉树有多少个节点，各种遍历方法
        // 深度优先遍历
        // 深度优先遍历非递归，前序遍历
        // 广度优先遍历
        // 思路2，利用完全二叉树的特性，如果是一颗满二叉树的话，假设高度为h，则节点数为2^h - 1个
        // 如何求一颗完全二叉树的高度呢？一路顺着左子树走，走到底就是完全二叉树的高度
        // 如果左子树的高度为left，右子树的高度为right，当left==right时，左子树是一颗高度为left的满二叉树
        // 当left>right时，右子树是一颗高度为right的满二叉树
        // 从上面可以观察到，总是可以求出某一边子树的节点数量，而剩下的不是满二叉树的一边，可以递归进行上述计算
        public int countNodes(TreeNode root) {
            return count(root);
        }

        private int count(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return 1;
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            if (leftHeight == rightHeight) {
                int lH = (int) (Math.pow(2, leftHeight) - 1);
                return lH + count(root.right) + 1;
            }
            int rH = (int) (Math.pow(2, rightHeight) - 1);
            return count(root.left) + rH + 1;
        }

        private int getHeight(TreeNode node) {
            int h = 0;
            while (node != null) {
                node = node.left;
                h++;
            }
            return h;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}