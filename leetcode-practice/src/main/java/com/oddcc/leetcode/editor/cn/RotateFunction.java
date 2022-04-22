// 396

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class RotateFunction {
    public static void main(String[] args) {
        Solution solution = new RotateFunction().new Solution();
        System.out.println(solution.maxRotateFunction(new int[]{4, 3, 2, 6}));
        System.out.println(solution.maxRotateFunction(new int[]{100}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxRotateFunction(int[] nums) {
            int fSum = 0;
            int len = nums.length;
            int sum = Arrays.stream(nums).sum();
            for (int i = 0; i < len; i++) {
                fSum += i * nums[i];
            }
            int res = fSum;
            for (int i = len - 1; i > 0; i--) {
                fSum += sum - len * nums[i];
                res = Math.max(res, fSum);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}