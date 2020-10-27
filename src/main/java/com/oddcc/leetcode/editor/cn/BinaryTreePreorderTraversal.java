package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
        System.out.println(solution.preorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));
        System.out.println(solution.preorderTraversal(new TreeNode(1, null, new TreeNode(2))));
        System.out.println(solution.preorderTraversal(new TreeNode(1, new TreeNode(2), null)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 前序遍历一棵二叉树，不能用递归方法
        // 遇到一个节点就先输出，然后如果有右子树，就把右子树入栈，然后去遍历左子树，循环往复；如果碰到叶子节点，出栈一个节点，继续遍历，直到遇到叶子节点且栈为空
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) return new ArrayList<>();
            List<Integer> ans = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            while (true) {
                ans.add(root.val);
                if (root.left == null && root.right == null && stack.isEmpty()) break;
                // 是叶子节点，但是栈内还有节点，则出栈一个节点继续
                if (root.left == null && root.right == null) {
                    root = stack.pop();
                    continue;
                }
                if (root.right != null) stack.push(root.right);
                if (root.left != null) {
                    root = root.left;
                }
                // 如果没有左子树，出栈一个节点继续，如果root有右子树，这里就会是最近入栈的右子树，否则就会是之前碰到的
                else {
                    root = stack.pop();
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}