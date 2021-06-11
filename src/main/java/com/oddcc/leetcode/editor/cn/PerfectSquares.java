// 279

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new PerfectSquares().new Solution();
        System.out.println(solution.numSquares(12));
        System.out.println(solution.numSquares(13));
        System.out.println(solution.numSquares(1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 可选的perfect square可以事先求出
    // 思路1，动态规划
    class Solution {
        public int numSquares(int n) {
            int[] psnArray = getPerfectSquares(n);
            // dp[i]表示构成i需要最少多少个perfect square
            int[] dp = new int[n + 1];
            dp[0] = 0;
            // 赋初始值，避免后续在array里反复查询
            for (int i : psnArray) {
                dp[i] = 1;
            }
            // dp[i] = min{dp[i-v] for f in psnArray}
            // 对于构成i来说，尝试所有可能的perfect square，把问题转化为更小的问题，并求其中最小的结果
            for (int i = 2; i <= n; i++) {
                List<Integer> options = new ArrayList<>();
                for (int psn : psnArray) {
                    if ((i - psn) >= 0) options.add(dp[i - psn]);
                }
                dp[i] = options.stream().min(Comparator.comparingInt(Integer::intValue)).get() + 1;
            }
            return dp[n];
        }

        private int[] getPerfectSquares(int n) {
            List<Integer> nums = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (i * i <= n) nums.add(i * i);
                else break;
            }

            int[] ans = new int[nums.size()];
            for (int i = 0; i < nums.size(); i++) {
                ans[i] = nums.get(i);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}