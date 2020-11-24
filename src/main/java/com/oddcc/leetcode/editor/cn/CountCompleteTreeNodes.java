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
        private int count = 0;

        // 思路1，返回完全二叉树有多少个节点，各种遍历方法
        // 深度优先遍历
        // 深度优先遍历非递归，前序遍历
        // 广度优先遍历
        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            List<TreeNode> nodeList = new ArrayList<>();
            nodeList.add(root);
            while (!nodeList.isEmpty()) {
                List<TreeNode> nextLayer = new ArrayList<>();
                for (TreeNode n: nodeList) {
                    count++;
                    if (n.left != null) nextLayer.add(n.left);
                    if (n.right != null) nextLayer.add(n.right);
                }
                nodeList = nextLayer;
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}