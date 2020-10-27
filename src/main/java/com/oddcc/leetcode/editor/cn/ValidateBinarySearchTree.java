package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
        System.out.println(solution.isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
        System.out.println(solution.isValidBST(new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，中序遍历，保留上一个数字，如果发现不是递增的，就说明不是二叉搜索树
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            Integer tmp = null;
            boolean valid = true;
            Deque<TreeNode> stack = new LinkedList<>();
            while (root != null || !stack.isEmpty()) {
                // 先把所有的左子节点入栈
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                // 走到这里root==null
                // 所以出栈一个节点进行处理，这里节点可能是最左下的子节点，这种情况下root.right == null
                // 下次出栈的就是父节点了，父节点的右子节点会得到相同的处理
                if (!stack.isEmpty()) {
                    root = stack.pop();
                    if (tmp != null && root.val <= tmp) { // 本来是用MIN_INTEGER，但是有个奇怪的用例，所以只能用null判断了
                        valid = false;
                        break;
                    } else {
                        tmp = root.val;
                    }
                    root = root.right;
                }
            }
            return valid;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}