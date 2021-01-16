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
            if (num == 0) return new int[]{0};
            if (num == 1) return new int[]{0, 1};
            int[] ans = new int[num + 1]; // 存储0~num的bit数量
            ans[0] = 0;
            ans[1] = 1;
            int n = 1; // 记录要复用的元素和当前元素的距离
            int upperBound = 2; // 达到了上界后，距离n要翻倍，如当i是3时，n=2，复用的是1的结果；当i是5时，n=4，复用的还是1的结果
            for (int i = 2; i < num + 1; i++) {
                if (i == upperBound) {
                    upperBound = upperBound * 2;
                    n = n * 2;
                }
                ans[i] = ans[i - n] + 1;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}