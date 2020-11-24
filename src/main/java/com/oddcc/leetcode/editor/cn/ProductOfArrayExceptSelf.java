// 238

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new ProductOfArrayExceptSelf().new Solution();
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{1, 2, 0, 4})));
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{1, 2, 0, 0})));
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{0, 0})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，output[i]的值是整个乘积/nums[i]的结果；注意，如果出现一个0，则除了0的位置有结果，其他位置都是0；如果出现2个或以上的0，则所有位置都是0
        public int[] productExceptSelf(int[] nums) {
            int total = 1;
            int countZero = 0;
            for (int i : nums) {
                if (i == 0) {
                    countZero++;
                    continue;
                }
                total *= i;
            }
            int[] ans = new int[nums.length];
            if (countZero >= 2) {
                Arrays.fill(ans, 0);
                return ans;
            }
            for (int i = 0; i < ans.length; i++) {
                if (countZero == 1) {
                    if (nums[i] == 0) {
                        ans[i] = total;
                    }
                    else {
                        ans[i] = 0;
                    }
                }
                else {
                    ans[i] = total / nums[i];
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}