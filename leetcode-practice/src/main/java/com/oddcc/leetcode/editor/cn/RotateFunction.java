// 396

package com.oddcc.leetcode.editor.cn;

public class RotateFunction {
    public static void main(String[] args) {
        Solution solution = new RotateFunction().new Solution();
        System.out.println(solution.maxRotateFunction(new int[]{4, 3, 2, 6}));
        System.out.println(solution.maxRotateFunction(new int[]{100}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxRotateFunction(int[] nums) {
            int len = nums.length;
            if (len == 1) return 0;
            int ans;
            int[] dp = new int[len];
            for (int i = 1; i < len; i++) {
                dp[0] += nums[i] * i;
            }
            ans = dp[0];
            int[] preSum = new int[len];
            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    preSum[i] = nums[i];
                } else {
                    preSum[i] = preSum[i - 1] + nums[i];
                }
            }
            for (int i = 1; i < len; i++) {
                dp[i] = dp[i - 1] + rotateSum(i - 1, 0, len - 2, len, preSum) - nums[getMapIndex(i - 1, len - 1, len)] * (len - 1);
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }

        private int getMapIndex(int rotateCount, int i, int len) {
            rotateCount %= len;
            int start = len - rotateCount;
            return (i + start) % len;
        }

        private int rotateSum(int rotateCount, int start, int end, int len, int[] preSum) {
            int mapStart = getMapIndex(rotateCount, start, len);
            int mapEnd = getMapIndex(rotateCount, end, len);
            if (mapEnd >= mapStart) {
                return preSum[mapEnd] - (mapStart >= 1 ? preSum[mapStart - 1] : 0);
            }
            return preSum[mapEnd] + preSum[len - 1] - preSum[mapStart - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}