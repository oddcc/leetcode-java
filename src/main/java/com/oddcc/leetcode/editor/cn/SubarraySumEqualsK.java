// 560

package com.oddcc.leetcode.editor.cn;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
        System.out.println(solution.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(solution.subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(solution.subarraySum(new int[]{5, 5, -10, 10, -10, 10}, 10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 题目没说nums是有序的
        // 思路1，暴力枚举
        public int subarraySum(int[] nums, int k) {
            int ans = 0;
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                int tmpSum = 0; // 这里要利用现有已有的值，否则复杂度会变成O(n^3)
                for (int j = i; j < len; j++) {
                    if (j == i) {
                        tmpSum = nums[i];
                    }
                    else {
                        tmpSum = tmpSum + nums[j];
                    }
                    if (tmpSum == k) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}