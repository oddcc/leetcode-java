// 1137

package com.oddcc.leetcode.editor.cn;

public class NThTribonacciNumber {
    public static void main(String[] args) {
        Solution solution = new NThTribonacciNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tribonacci(int n) {
            int[] nums = new int[n+1];
            if (n == 0) return 0;
            if (n == 1) return 1;
            if (n == 2) return 1;
            nums[0] = 0;
            nums[1] = 1;
            nums[2] = 1;
            for (int i = 3; i <= n; i++) {
                nums[i] = nums[i-3] + nums[i-2] + nums[i-1];
            }
            return nums[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}