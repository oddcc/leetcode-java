// 2044

package com.oddcc.leetcode.editor.cn;

public class CountNumberOfMaximumBitwiseOrSubsets {
    public static void main(String[] args) {
        Solution solution = new CountNumberOfMaximumBitwiseOrSubsets().new Solution();
        System.out.println(solution.countMaxOrSubsets(new int[]{1, 3}));
        System.out.println(solution.countMaxOrSubsets(new int[]{2, 2, 2}));
        System.out.println(solution.countMaxOrSubsets(new int[]{3, 2, 1, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int ans;

        public int countMaxOrSubsets(int[] nums) {
            ans = 0;
            int target = 0;
            for (int n : nums) {
                target |= n;
            }
            dfs(0, 0, nums, target);
            return ans;
        }

        private void dfs(int current, int i, int[] nums, int target) {
            if (i >= nums.length) {
                if (current == target) {
                    ans++;
                }
                return;
            }
            dfs(current, i + 1, nums, target);
            int n = nums[i];
            current |= n;
            dfs(current, i + 1, nums, target);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}