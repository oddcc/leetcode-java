// 337

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

public class HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();
        TreeNode t1 = new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)));
        System.out.println(solution.rob(t1));
        TreeNode t2 = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(3)), new TreeNode(5, null, new TreeNode(1)));
        System.out.println(solution.rob(t2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 使用递归
        public int rob(TreeNode root) {
            return Math.max(doRub(root, true), doRub(root, false));
        }

        private int doRub(TreeNode root, boolean rub) {
            if (root == null) {
                return 0;
            }
            int ans = 0;
            if (rub) {
                // 抢这家的情况，左右子树就不能抢了
                ans += root.val;
                ans += doRub(root.left, false);
                ans += doRub(root.right, false);
            }
            else {
                // 不抢这家的话，左右子树的选择要取收益最大的
                ans += Math.max(doRub(root.left, false), doRub(root.left, true));
                ans += Math.max(doRub(root.right, false), doRub(root.right, true));
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}