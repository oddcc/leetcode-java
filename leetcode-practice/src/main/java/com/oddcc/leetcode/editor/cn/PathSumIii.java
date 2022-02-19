// 437

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

public class PathSumIii {
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
        TreeNode t1 = new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))), new TreeNode(-3, null, new TreeNode(11)));
        System.out.println(solution.pathSum(t1, 8));
        TreeNode t2 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5)))));
        System.out.println(solution.pathSum(t2, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，递归

        /**
         * @param root
         * @param sum
         * @return 以root为根，和为sum的路径数量，有路径中包含root的情况，也有路径中不包含root的情况
         */
        public int pathSum(TreeNode root, int sum) {
            if (root == null) return 0;
            return pathSumFrom(root, sum) // 求路径中包含root时，有多少路径
                    + pathSum(root.left, sum) // 不包含root时，左子树的路径数量
                    + pathSum(root.right, sum); // 不包含root时，右子树的路径数量
        }

        /**
         *
         * @param root
         * @param sum
         * @return 以root为根，和为sum的路径数量，路径中包含root
         */
        private int pathSumFrom(TreeNode root, int sum) {
            if (root == null) return 0;
            int ans = 0;
            if (root.val == sum) ans++;
            ans += pathSumFrom(root.left, sum - root.val);
            ans += pathSumFrom(root.right, sum - root.val);
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}