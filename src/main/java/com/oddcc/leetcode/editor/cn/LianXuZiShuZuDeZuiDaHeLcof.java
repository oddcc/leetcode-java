// 剑指 Offer 42

package com.oddcc.leetcode.editor.cn;

public class LianXuZiShuZuDeZuiDaHeLcof {
    public static void main(String[] args) {
        Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solution.maxSubArray(new int[]{1, 7, -2, -5, 10, -1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，贪心+分治
        public int maxSubArray(int[] nums) {
            int ans, tmpMax;
            ans = nums[0];
            tmpMax = nums[0];
            for (int i = 1; i < nums.length; i++) {
                // 要求是连续数组，tmpMax < 0，对当前的nums[i]来说，就是没用的，所以要抛弃
                if (tmpMax < 0) {
                    tmpMax = Math.max(tmpMax, nums[i]);
                }
                // 如果tmpMax >= 0，则还可以跟当前的nums[i]组成结果
                else {
                    tmpMax += nums[i];
                }
                ans = Math.max(ans, tmpMax);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}