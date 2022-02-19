// 485

package com.oddcc.leetcode.editor.cn;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnes().new Solution();
        System.out.println(solution.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
        System.out.println(solution.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 0}));
        System.out.println(solution.findMaxConsecutiveOnes(new int[]{1, 1, 1, 1, 1}));
        System.out.println(solution.findMaxConsecutiveOnes(new int[]{0, 0, 0, 0, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，滑动窗口
        public int findMaxConsecutiveOnes(int[] nums) {
            int ans = 0;
            int len = nums.length;
            int left = 0;
            int right = 0;
            while (right <= len) {
                // 连续的1结束的条件有两个
                // 1、已经到了末尾
                // 2、新加入的元素不是1
                if (right == len || nums[right] == 0) {
                    ans = Math.max(ans, right - left);
                    left = right + 1;
                }
                right++;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}