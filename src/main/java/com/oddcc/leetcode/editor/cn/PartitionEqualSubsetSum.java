// 416

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(solution.canPartition(new int[]{1, 2, 3, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1,超时，dfs+剪枝,我们求出总和total,然后对于每个值n,有选或不选两种选择,我们用dfs的方式遍历加和,如果碰到sum==total-sum,那么就有解,否则就无解
    // 当sum > total/2之后,因为都是正数,sum不可能减小了,所以后续不可能有答案,这里可以剪枝
    class Solution {
        public boolean canPartition(int[] nums) {
            int total = Arrays.stream(nums).sum();
            return dfs(nums, 0, 0, total) != -1;
        }

        // 有解时返回解,返回值应该等于total/2，无解时返回-1
        private int dfs(int[] nums, int i, int sum, int total) {
            if (i >= nums.length) return -1;
            if (sum > total / 2) return -1;
            if (sum == total - sum) return sum;
            int ans1 = dfs(nums, i + 1, sum + nums[i], total);
            if (ans1 != -1) return ans1;
            return dfs(nums, i + 1, sum, total);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}