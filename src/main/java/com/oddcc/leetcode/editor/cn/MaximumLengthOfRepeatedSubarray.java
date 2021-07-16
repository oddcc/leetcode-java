// 718

package com.oddcc.leetcode.editor.cn;

public class MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfRepeatedSubarray().new Solution();
        System.out.println(solution.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        System.out.println(solution.findLength(new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，动态规划
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int l1 = nums1.length;
            int l2 = nums2.length;
            // dp[i][j]表示以i和结尾的两个subarray中，最长的公共部分的长度
            int[][] dp = new int[l1][l2];
            int ans = 0;
            for (int i = 0; i < l1; i++) {
                for (int j = 0; j < l2; j++) {
                    if (nums1[i] == nums2[j]) {
                        if (i > 0 && j > 0) {
                            dp[i][j] = dp[i - 1][j - 1] + 1;
                        }
                        else {
                            dp[i][j] = 1;
                        }

                    }
                    else {
                        dp[i][j] = 0;
                    }
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}