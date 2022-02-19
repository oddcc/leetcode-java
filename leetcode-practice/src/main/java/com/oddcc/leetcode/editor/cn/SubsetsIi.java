// 90

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
        System.out.println(solution.subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(solution.subsetsWithDup(new int[]{0}));
        System.out.println(solution.subsetsWithDup(new int[]{}));
        System.out.println(solution.subsetsWithDup(new int[]{4, 4, 4, 1, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，回溯法遍历所有可能的结果，每个位置都有选或不选两种，整个结果集就是一颗二叉树（Root不含信息，高为nums.length+1），所有符合条件的子集都在叶子节点，但要注意去重
        // 是使用的Set+排序去重
        // 思路2，回溯法，同样是一颗二叉树，Root是空集，每个节点都表示一个子集（跟思路1的区别是思路1只有叶子结点表示子集），是按层遍历二叉树
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            dfs(ans, nums, new ArrayList<>(), 0);
            return ans;
        }

        /**
         *
         * @param ans 答案集合
         * @param nums 原始数据
         * @param path 截止目前的子集（单个）
         * @param start 还没选的区间左边界
         */
        private void dfs(List<List<Integer>> ans, int[] nums, ArrayList<Integer> path, int start) {
            ans.add(new ArrayList<>(path));
            if (start >= nums.length) {
                return;
            }

            Integer pre = null;
            // 对每一个位置i，都有选或不选两种情况
            for (int i = start; i < nums.length; i++) {
                if (pre != null && pre == nums[i]) continue; // 如果上一个数字跟当前的相同，那么就跳过，因为相同的数字前面的循环处理过了
                path.add(nums[i]);
                dfs(ans, nums, path, i + 1); // 选了i的情况
                path.remove(path.size() - 1); // remote了添加的nums[i]，下面的循环中就是没选i的情况
                pre = nums[i];
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}