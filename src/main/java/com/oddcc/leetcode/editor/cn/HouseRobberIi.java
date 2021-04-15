// 213

package com.oddcc.leetcode.editor.cn;

public class HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIi().new Solution();
        // System.out.println(solution.rob(new int[]{2, 3, 2}));
        // System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
        // System.out.println(solution.rob(new int[]{0}));
        System.out.println(solution.rob(new int[]{114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，回溯法找最大值
        public int rob(int[] nums) {
            return maxSum(nums, new boolean[nums.length], 0, 0);
        }

        /**
         *
         * @param nums
         * @param used 记录抢过哪几家
         * @param cur 当前位置，还没抢
         * @param sum 当前的总数，还没抢
         * @return 返回最大值
         */
        private int maxSum(int[] nums, boolean[] used, int cur, int sum) {
            if (cur >= nums.length) return sum; // 如果越界了，直接返回之前的结果
            if (cur == nums.length - 1 && used[0]) return sum; // 如果当前是最后一家，而且抢过第一家，那么不能抢最后一家，返回之前的结果
            // 如果不是第一家，并且上一家抢过了，那么不能抢这一家
            if (cur - 1 >= 0 && used[cur - 1]) {
                used[cur] = false;
                return maxSum(nums, used, cur + 1, sum);
            }
            // 抢了这一家的情况
            used[cur] = true;
            int s1 = maxSum(nums, used, cur + 1, sum + nums[cur]);
            // 没抢这一家的情况
            used[cur] = false;
            int s2 = maxSum(nums, used, cur + 1, sum);
            // 返回结果较大的
            return Math.max(s1, s2);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}