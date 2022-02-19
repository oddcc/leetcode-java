// 617

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new MergeTwoBinaryTrees().new Solution();
        TreeNode n1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode n2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
        TreeNode ans = solution.mergeTrees(n1, n2);
        System.out.println("done");
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        // 思路1，递归
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) return null;
            TreeNode ans = new TreeNode(0);
            if (t1 == null) {
                ans.val = t2.val;
                ans.left = mergeTrees(null, t2.left);
                ans.right = mergeTrees(null, t2.right);
            }
            else if (t2 == null) {
                ans.val = t1.val;
                ans.left = mergeTrees(t1.left, null);
                ans.right = mergeTrees(t1.right, null);
            }
            else {
                ans.val = t1.val + t2.val;
                ans.left = mergeTrees(t1.left, t2.left);
                ans.right = mergeTrees(t1.right, t2.right);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}