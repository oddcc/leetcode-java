// 713

package com.oddcc.leetcode.editor.cn;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        Solution solution = new SubarrayProductLessThanK().new Solution();
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，滑动窗口，超时
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int ans = 0;
            int len = nums.length;
            int left = 0;
            // 每一轮遍历,是计算以left为起点的所有符合条件的子串数量
            while (left < len) {
                int right = left;
                int product = 1;
                // 当product<k时，说明找到了一个答案，计数增加；当product>=k时，再扩展窗口没有意义，要进行下一轮遍历
                while (right < len) {
                    product *= nums[right++];
                    if (product >= k) break;
                    ans++;
                }
                left++;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}