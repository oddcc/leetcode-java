// 897

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class IncreasingOrderSearchTree {
    public static void main(String[] args) {
        Solution solution = new IncreasingOrderSearchTree().new Solution();
        solution.increasingBST(TreeNode.constructFromArr(5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9));
        solution.increasingBST(TreeNode.constructFromArr(2, 1, 4, null, null, 3));
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
                // System.out.println(c);
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