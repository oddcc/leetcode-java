// 713

package com.oddcc.leetcode.editor.cn;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        Solution solution = new SubarrayProductLessThanK().new Solution();
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，暴力法+滑动窗口，超时
    // 思路2，滑动窗口，优化思路1
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int ans = 0;
            if (k <= 1) return 0; // 因为nums中范围是o~1000所以乘积不会小于0
            int prod = 1;
            int left = 0;
            // 每一轮遍历,是计算以right为终点的所有符合条件的子串数量
            // 因为right确定时，left向右移动，并不会使乘积变大，所以一旦找到product<k时，之后的所有left位置都是答案，不用再进行计算
            for (int right = 0; right < nums.length; right++) {
                prod *= nums[right];
                while (prod >= k) prod /= nums[left++];
                ans += right - left + 1;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}