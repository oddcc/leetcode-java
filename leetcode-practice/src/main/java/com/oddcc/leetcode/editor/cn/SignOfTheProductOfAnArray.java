// 1822

package com.oddcc.leetcode.editor.cn;

public class SignOfTheProductOfAnArray {
    public static void main(String[] args) {
        Solution solution = new SignOfTheProductOfAnArray().new Solution();
        System.out.println(solution.arraySign(new int[]{-1, -2, -3, -4, 3, 2, 1}));
        System.out.println(solution.arraySign(new int[]{1, 5, 0, 2, -3}));
        System.out.println(solution.arraySign(new int[]{-1, 1, -1, 1, -1}));
        System.out.println(solution.arraySign(new int[]{41, 65, 14, 80, 20, 10, 55, 58, 24, 56, 28, 86, 96, 10, 3, 84, 4, 41, 13, 32, 42, 43, 83, 78, 82, 70, 15, -41}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，直接计算，因为最终结果只跟正负有关，所以可以压缩数值，避免溢出
        public int arraySign(int[] nums) {
            int product = 1;
            for (int i : nums) {
                product *= i;
                if (product > 0) product = 1;
                else if (product < 0) product = -1;
                else return 0;
            }
            if (product > 0) return 1;
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}