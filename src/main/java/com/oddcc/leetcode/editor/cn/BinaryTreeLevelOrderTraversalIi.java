//Given a binary tree, return the bottom-up level order traversal of its nodes' 
//values. (ie, from left to right, level by level from leaf to root). 
//
// 
//For example: 
//Given binary tree [3,9,20,null,null,15,7], 
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// 
// 
//return its bottom-up level order traversal as: 
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 336 👎 0


package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
        TreeNode n = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
//        TreeNode n = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(solution.levelOrderBottom(n));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            // 遍历的时候就按层次去遍历，每次处理一层，处理完了进入下一层；而不是一股脑的处理，不管层数
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> row = new ArrayList<>();
                // 要把当前层要处理的结点数量记下来
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    // 取出一个结点，就输出，如果结点有子结点，则放入队列
                    TreeNode node = queue.remove();
                    row.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                // 一层处理完了，把输出放到结果里面，再继续处理下一层
                result.add(0, row);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}