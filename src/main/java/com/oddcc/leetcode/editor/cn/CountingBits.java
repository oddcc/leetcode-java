// 338

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        Solution solution = new CountingBits().new Solution();
        System.out.println(Arrays.toString(solution.countBits(5)));
        System.out.println(Arrays.toString(solution.countBits(0)));
        System.out.println(Arrays.toString(solution.countBits(7)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 题目要求，时间复杂度O(N)，空间复杂度O(N)；所以采用除2的方式来数某个数的1的数是不可行的
        // 思路1，找规律
        // 000
        // 001
        // 010
        // 011
        // 100
        // 101
        // 110
        // 111
        // 可以看到，规律，比如2~3复用0~1的结果，就是0~1的结果+1，4~7复用0~3，8~15复用0~7
        // 2^n ~ 2^(n+1) - 1  复用  0~2^n - 1 的结果
        public int[] countBits(int num) {
            int[] ans = new int[num + 1];
            ans[0] = 0;
            int sub = 1;
            int count = 1;
            for (int i = 1; i <= num; i++, count++) {
                ans[i] = ans[i - sub] + 1;
                if (count == sub) {
                    sub *= 2;
                    count = 0;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}