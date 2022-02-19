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
        // 思路2，除了i元素之外的乘积 = i左边所有元素的乘积 * i右边所有元素的乘积，利用类似前缀和数组的方式来解
        public int[] productExceptSelf(int[] nums) {
            int len = nums.length;
            int[] ans = new int[len];
            int tmpProduct = 1;
            // 这里得到的是左边的前缀积，ans[i]表示的是i左边所有元素的乘积
            for (int i = 0; i < len; i++) {
                ans[i] = tmpProduct;
                tmpProduct *= nums[i];
            }
            tmpProduct = 1;
            for (int i = len - 1; i >= 0; i--) {
                // 这里tmpProduct表示的是右边的前缀积，ans[i]是左边的前缀积
                ans[i] = tmpProduct * ans[i];
                tmpProduct *= nums[i];
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}