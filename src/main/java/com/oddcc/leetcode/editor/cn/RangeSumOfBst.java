// 938

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class RangeSumOfBst {
    public static void main(String[] args) {
        Solution solution = new RangeSumOfBst().new Solution();
        System.out.println(solution.rangeSumBST(TreeNode.constructFromArr(10, 5, 15, 3, 7, null, 18), 7, 15));
        System.out.println(solution.rangeSumBST(TreeNode.constructFromArr(10, 5, 15, 3, 7, 13, 18, 1, null, 6), 6, 10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，中序遍历，因为给出的树是BST，而中序遍历的结果是升序的
        public int rangeSumBST(TreeNode root, int low, int high) {
            int ans = 0;
            Deque<TreeNode> stack = new LinkedList<>();
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.val >= low && root.val <= high) {
                    // System.out.println(root.val);
                    ans += root.val;
                }
                root = root.right;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}