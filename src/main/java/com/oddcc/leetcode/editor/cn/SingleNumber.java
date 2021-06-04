// 136
package com.oddcc.leetcode.editor.cn;

public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
        //        System.out.println(solution.singleNumber(new int[]{4,1,2,1,2}));
        //        System.out.println(solution.singleNumber(new int[]{2,2,1}));
        //        System.out.println(solution.singleNumber(new int[]{2}));
        System.out.println(solution.singleNumber(new int[]{17, 12, 5, -6, 12, 4, 17, -5, 2, -3, 2, 4, 5, 16, -3, -4, 15, 15, -4, -5, -6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 只要求输出单独的那个数，O(n)的时间复杂度，O(1)的空间复杂度
        // 自己写map这种应该都不满足空间复杂度的要求
        // 1. 只能先排序，然后遍历；因为除了一个数之外，其他所有数都出现2次
        // 2. 利用异或性质
        // 任何数和 00 做异或运算，结果仍然是原来的数，即 a⊕0=a a⊕0=a。
        //任何数和其自身做异或运算，结果是 00，即 a⊕a=0 a⊕a=0。
        //异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
        public int singleNumber(int[] nums) {
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                result = nums[i] ^ result;
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}