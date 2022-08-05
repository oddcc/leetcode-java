// 623

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AddOneRowToTree {
    public static void main(String[] args) {
        Solution solution = new AddOneRowToTree().new Solution();
//        TreeNode t = TreeNode.constructFromArr(4, 2, 6, 3, 1, 5);
//        System.out.println(solution.addOneRow(t, 1, 2));
//        TreeNode t = TreeNode.constructFromArr(4, 2, null, 3, 1);
//        System.out.println(solution.addOneRow(t, 1, 3));
        TreeNode t = TreeNode.constructFromArr(1, 2, 3, 4);
        System.out.println(solution.addOneRow(t, 5, 4));
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

    // 1, 层次遍历
    class Solution {
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if (depth == 1) {
                TreeNode r = new TreeNode(val);
                r.left = root;
                return r;
            }

            List<TreeNode> nodeList = new ArrayList<>();
            nodeList.add(root);
            for (int i = 1; i < depth; i++) {
                if (i == depth - 1) {
                    for (TreeNode node : nodeList) {
                        if (node.left != null) {
                            TreeNode newLeftChild = new TreeNode(val);
                            newLeftChild.left = node.left;
                            node.left = newLeftChild;
                        } else {
                            node.left = new TreeNode(val);
                        }
                        if (node.right != null) {
                            TreeNode newRightChild = new TreeNode(val);
                            newRightChild.right = node.right;
                            node.right = newRightChild;
                        } else {
                            node.right = new TreeNode(val);
                        }
                    }
                } else {
                    List<TreeNode> nodesInThisDepth = new ArrayList<>();
                    for (TreeNode node : nodeList) {
                        if (node.left != null) {
                            nodesInThisDepth.add(node.left);
                        }
                        if (node.right != null) {
                            nodesInThisDepth.add(node.right);
                        }
                    }
                    nodeList = nodesInThisDepth;
                }
            }

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}