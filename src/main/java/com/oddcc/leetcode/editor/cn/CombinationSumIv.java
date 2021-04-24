// 377

package com.oddcc.leetcode.editor.cn;

public class CombinationSumIv {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIv().new Solution();
        System.out.println(solution.combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(solution.combinationSum4(new int[]{9}, 3));
        System.out.println(solution.combinationSum4(new int[]{2, 1, 3}, 35));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，回溯法，超时
        private int ans;

        public int combinationSum4(int[] nums, int target) {
            ans = 0;
            dfs(nums, target, 0);
            return ans;
        }

        private void dfs(int[] nums, int target, int sum) {
            if (sum >= target) {
                if (sum == target) ans++;
                return;
            }
            for (int i : nums) {
                dfs(nums, target, sum + i);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}