// 897

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class IncreasingOrderSearchTree {
    public static void main(String[] args) {
        Solution solution = new IncreasingOrderSearchTree().new Solution();
        solution.increasingBST(new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6, null, new TreeNode(8, new TreeNode(7), new TreeNode(9)))));
        solution.increasingBST(new TreeNode(2, new TreeNode(1), new TreeNode(4, new TreeNode(3), null)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，非递归中序遍历，维护pre节点，并在遍历之中更新
    class Solution {
        public TreeNode increasingBST(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode pre = null;
            TreeNode ans = null;
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                TreeNode c = stack.pop();
                System.out.println(c);
                if (pre != null) {
                    pre.right = c;
                }
                else {
                    ans = c;
                }
                pre = c;
                pre.left = null;
                if (c.right != null) {
                    root = c.right;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}