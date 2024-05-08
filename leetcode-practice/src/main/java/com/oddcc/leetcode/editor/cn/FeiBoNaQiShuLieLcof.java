// 剑指 Offer 10- I&&fei-bo-na-qi-shu-lie-lcof

package com.oddcc.leetcode.editor.cn;

public class FeiBoNaQiShuLieLcof {
    public static void main(String[] args) {
        Solution solution = new FeiBoNaQiShuLieLcof().new Solution();
        System.out.println(solution.fib(2));
        System.out.println(solution.fib(5));
        System.out.println(solution.fib(48));
        System.out.println(solution.fib(51));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，动态规划提高效率
        // 思路2，动态规划，但只保存需要的结果
        public int fib(int n) {
            if (n == 0) return 0;
            if (n == 1) return 1;
            int pre2 = 0;
            int pre1 = 1;
            int ans = 0;
            for (int i = 2; i < n + 1; i++) {
                ans = (pre2 + pre1) % 1000000007;
                pre2 = pre1;
                pre1 = ans;

            }
            return ans % 1000000007;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}