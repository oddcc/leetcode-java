// 279

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new PerfectSquares().new Solution();
        System.out.println(solution.numSquares(12));
        System.out.println(solution.numSquares(1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 1 <= 求和用的平方数肯定 <= n的平方根
        // 通过遍历可以很快求出所有小于n的perfect square numbers
        // 思路1，动态规划，转移方程 f(12) = min(f(12-1), f(12-4), f(12-9)) + 1
        // 其中min之中有几项是动态的，规则是n减小于等于n的perfect square numbers
        public int numSquares(int n) {
            int[] psnArray = getPsns(n);
            System.out.println(Arrays.toString(psnArray));
            int[] dp = new int[n + 1];
            dp[0] = 0;
            for (int i : psnArray) {
                dp[i] = 1;
            }
            for (int i = 2; i <= n; i++) {
                List<Integer> options = new ArrayList<>();
                for (int psn : psnArray) {
                    if ((i - psn) >= 0) options.add(dp[i - psn]);
                }
                dp[i] = options.stream().min(Comparator.comparingInt(a -> a)).get() + 1;
            }
            return dp[n];
        }

        private int[] getPsns(int n) {
            List<Integer> arr = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (i * i <= n) arr.add(i * i);
            }

            int[] ans = new int[arr.size()];
            for (int i = 0; i < arr.size(); i++) {
                ans[i] = arr.get(i);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}