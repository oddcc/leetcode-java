// 740

package com.oddcc.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class DeleteAndEarn {
    public static void main(String[] args) {
        Solution solution = new DeleteAndEarn().new Solution();
        System.out.println(solution.deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(solution.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
        System.out.println(solution.deleteAndEarn(new int[]{1, 8, 5, 9, 6, 9, 4, 1, 7, 3, 3, 6, 3, 3, 8, 2, 6, 3, 2, 2, 1, 2, 9, 8, 7, 1, 1, 10, 6, 7, 3, 9, 6, 10, 5, 4, 10, 1, 6, 7, 4, 7, 4, 1, 9, 5, 1, 5, 7, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，暴力法+回溯，超时
    class Solution {
        public int deleteAndEarn(int[] nums) {
            Set<Integer> needRemove = new HashSet<>();
            return dfs(nums, needRemove, 0, 0);
        }

        /**
         * 返回最大的points
         * @param nums
         * @param needRemove 需要删除的数，如果当前数包含在里面则不能选
         * @param i 当前处理到的位置 i>=0 i<nums.length
         * @param points 当前的points
         * @return
         */
        private int dfs(int[] nums, Set<Integer> needRemove, int i, int points) {
            if (i >= nums.length) {
                return points;
            }
            int n = nums[i];
            if (needRemove.contains(n)) {
                return dfs(nums, needRemove, i + 1, points);
            }
            boolean p1 = needRemove.contains(n + 1);
            boolean s1 = needRemove.contains(n - 1);
            // 选n
            needRemove.add(n + 1);
            needRemove.add(n - 1);
            int a = dfs(nums, needRemove, i + 1, points + n);
            // 不选n
            if (!p1) needRemove.remove(n + 1);
            if (!s1) needRemove.remove(n - 1);
            int b = dfs(nums, needRemove, i + 1, points);
            return Math.max(a, b);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}