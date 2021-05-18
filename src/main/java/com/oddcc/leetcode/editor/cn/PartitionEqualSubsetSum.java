// 416

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(solution.canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(solution.canPartition(new int[]{9, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1,超时，dfs+剪枝,我们求出总和total,然后对于每个值n,有选或不选两种选择,我们用dfs的方式遍历加和,如果碰到sum==total-sum,那么就有解,否则就无解
    // 当sum > total/2之后,因为都是正数,sum不可能减小了,所以后续不可能有答案,这里可以剪枝
    // 思路2,问题可以转化成,是否可以选n个数字,使得n个数字的和加起来等于total/2
    class Solution {
        public boolean canPartition(int[] nums) {
            int len = nums.length;
            if (len < 2) return false;
            int total = Arrays.stream(nums).sum();
            if (total % 2 != 0) return false;
            int tar = total / 2;
            // dp[i][j]表示,选完第i个数后,加和是否是j
            boolean[][] dp = new boolean[len][tar + 1];
            if (nums[0] < tar) dp[0][nums[0]] = true;
            dp[0][0] = true;
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < tar + 1; j++) {
                    // 能达成是3种情况
                    // 1,nums[i] == j，自己就可以加和到j，不需要其他元素
                    // 2,dp[i-1][j-nums[i]]，前面i-1个元素可以加和为j-nums[i]
                    // 3,不选i,dp[i-1][j]可以满足
                    dp[i][j] = (j - nums[i] > 0 && dp[i - 1][j - nums[i]]) || nums[i] == j || dp[i - 1][j];
                }
            }

            return dp[len - 1][tar];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}