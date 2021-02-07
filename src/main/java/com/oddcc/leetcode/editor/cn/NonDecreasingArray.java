// 665

package com.oddcc.leetcode.editor.cn;

public class NonDecreasingArray {
    public static void main(String[] args) {
        Solution solution = new NonDecreasingArray().new Solution();
        System.out.println(solution.checkPossibility(new int[]{4, 2, 3}));
        System.out.println(solution.checkPossibility(new int[]{4, 2, 1}));
        System.out.println(solution.checkPossibility(new int[]{3, 4, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，单次遍历
        public boolean checkPossibility(int[] nums) {
            int n = nums.length;
            int count = 0;
            for (int i = 0; i < n - 1; ++i) {
                if (nums[i] > nums[i + 1]) {
                    count++;
                    if (count > 1) {
                        return false;
                    }
                    if (i > 0 && nums[i + 1] < nums[i - 1]) {
                        nums[i + 1] = nums[i];
                    }
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}