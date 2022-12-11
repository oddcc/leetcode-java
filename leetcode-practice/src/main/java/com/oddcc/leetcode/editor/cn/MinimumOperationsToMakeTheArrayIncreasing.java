// 1827

package com.oddcc.leetcode.editor.cn;

public class MinimumOperationsToMakeTheArrayIncreasing {
    public static void main(String[] args) {
        Solution solution = new MinimumOperationsToMakeTheArrayIncreasing().new Solution();
        System.out.println(solution.minOperations(new int[]{1, 1, 1}));
        System.out.println(solution.minOperations(new int[]{1, 5, 2, 4, 1}));
        System.out.println(solution.minOperations(new int[]{8}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums) {
            int ans = 0;
            Integer previous = null;
            for (int i = 0; i < nums.length; i++) {
                int n = nums[i];
                if (previous == null) {
                    previous = n;
                } else {
                    if (previous >= n) {
                        ans += previous - n + 1;
                        previous += 1;
                    } else {
                        previous = n;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}