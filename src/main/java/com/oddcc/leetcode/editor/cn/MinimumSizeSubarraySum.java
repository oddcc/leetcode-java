// 209

package com.oddcc.leetcode.editor.cn;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(solution.minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(solution.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，滑动窗口
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int len = nums.length;
            int left = 0;
            int right = 0; // right指向还未计算过的值
            int ans = 0;
            int sum = 0;
            boolean expend = true; // 记录窗口是否应该向右扩展
            while (left < len && right < len) {
                if (expend) sum += nums[right];
                // 当和小于目标时，需要扩展窗口
                if (sum < target) {
                    expend = true;
                    right++;
                }
                // 当和大于目标时，说明满足题意了，因为数组中都是正数，求的是最小子数组长，所以继续扩展没有意义
                // 这也说明，以当前left为起点的满足条件的最小子数组已经找到
                // 接下来应该以left+1为起点开始寻找
                // 为什么right不用移动，但并不会错过正确答案呢？
                // 因为如果答案是[left+1,right]，那么我们的算法不会错过
                // 如果答案在[left+1,right-1]中，是不可能出现的，因为我们已经计算过[left,right-1]并不是答案，意味着和没有超过目标值
                // 因为数组都是正数，[left+1,right-1]的和一定小于[left,right-1]的和
                else {
                    int subLen = right - left + 1;
                    if (ans == 0) {
                        ans = subLen;
                    }
                    else {
                        ans = Math.min(ans, subLen);
                    }
                    expend = false;
                    sum -= nums[left];
                    left++;
                }
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}