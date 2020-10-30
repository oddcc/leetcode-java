package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
        TreeNode n1 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        solution.flatten(n1);
        System.out.println("done");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 连接的顺序是前序遍历（根左右）的顺序，每次连接的时候，都连接到右子树
        public void flatten(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            List<TreeNode> cache = new ArrayList<>();
            while (root != null || !stack.isEmpty()) {
                if (root == null) {
                    root = stack.pop();

                }
                cache.add(root);
                if (root.right != null) stack.push(root.right);
                root = root.left;
            }
            TreeNode tmp = null;
            for (TreeNode n : cache) {
                if (tmp != null) {
                    tmp.right = n;
                    tmp.left = null;
                }
                tmp = n;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}