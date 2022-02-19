// 114
package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

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
            TreeNode tmp = null;
            while (root != null || !stack.isEmpty()) {
                if (root == null) {
                    root = stack.pop();
                }
                if (root.right != null) stack.push(root.right);
                if (tmp == null) {
                    tmp = root;
                }
                else {
                    tmp.left = null;
                    tmp.right = root;
                    tmp = root;
                }
                root = root.left;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}