package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        Solution solution = new SumRootToLeafNumbers().new Solution();
        System.out.println(solution.sumNumbers(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        System.out.println(solution.sumNumbers(new TreeNode(1)));
        System.out.println(solution.sumNumbers(null));
        System.out.println(solution.sumNumbers(new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int sum = 0;

        // 采用回溯法遍历每条路径，每次进行回溯时，把路径中的值加和放入sum中
        public int sumNumbers(TreeNode root) {
            if (root == null) return 0;
            dfs(root, new ArrayList<>());
            int tmp = sum;
            sum = 0;
            return tmp;
        }

        private void dfs(TreeNode root, List<TreeNode> path) {
            if (root.left == null && root.right == null) {
                path.add(root);
                sum += calcSum(path);
                path.remove(path.size() - 1);
                return;
            }
            path.add(root);
            if (root.left != null) dfs(root.left, path);
            if (root.right != null) dfs(root.right, path);
            path.remove(path.size() - 1);
        }

        private int calcSum(List<TreeNode> path) {
            int sum = 0;
            for (TreeNode node : path) {
                sum = sum * 10 + node.val;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}