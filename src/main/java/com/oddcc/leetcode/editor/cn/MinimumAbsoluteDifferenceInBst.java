package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifferenceInBst().new Solution();
//        TreeNode n1 = new TreeNode(1, null, new TreeNode(3, new TreeNode(2), null));
//        System.out.println(solution.getMinimumDifference(n1));
        TreeNode n2 = new TreeNode(543, new TreeNode(384, null, new TreeNode(445)), new TreeNode(652, null, new TreeNode(699)));
        System.out.println(solution.getMinimumDifference(n2));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getMinimumDifference(TreeNode root) {
            List<Integer> array = new ArrayList<>();
            walk(root, array);
            array.sort(Comparator.comparingInt(a -> a));
            if (array.size() == 2) return Math.abs(array.get(0) - array.get(1));
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < array.size() - 1; i++) {
                int abs = Math.abs(array.get(i) - array.get(i + 1));
                if (abs < ans) {
                    ans = abs;
                }
            }
            return ans;
        }

        private void walk(TreeNode root, List<Integer> array) {
            if (root == null) return;
            array.add(root.val);
            walk(root.left, array);
            walk(root.right, array);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}