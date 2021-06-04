// 268

package com.oddcc.leetcode.editor.cn;

public class MissingNumber {
    public static void main(String[] args) {
        Solution solution = new MissingNumber().new Solution();
        System.out.println(solution.missingNumber(new int[]{3, 0, 1}));
        System.out.println(solution.missingNumber(new int[]{0, 1}));
        System.out.println(solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println(solution.missingNumber(new int[]{0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，维护一个sum，总共只有n个数，但范围是[0,n]，有一个数不存在，可以通过实际的和对比应有的和，来算出到底少了哪个数字
    class Solution {
        public int missingNumber(int[] nums) {
            int len = nums.length;
            int wantSum = 0;
            int sum = 0;
            for (int i = 0; i < len; i++) {
                wantSum += i + 1;
                sum += nums[i];
            }
            return wantSum - sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}