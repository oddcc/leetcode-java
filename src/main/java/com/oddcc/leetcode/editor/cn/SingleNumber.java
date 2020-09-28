//Given a non-empty array of integers, every element appears twice except for on
//e. Find that single one. 
//
// Note: 
//
// Your algorithm should have a linear runtime complexity. Could you implement i
//t without using extra memory? 
//
// Example 1: 
//
// 
//Input: [2,2,1]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: [4,1,2,1,2]
//Output: 4
// 
// Related Topics 位运算 哈希表 
// 👍 1507 👎 0


package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
//        System.out.println(solution.singleNumber(new int[]{4,1,2,1,2}));
//        System.out.println(solution.singleNumber(new int[]{2,2,1}));
//        System.out.println(solution.singleNumber(new int[]{2}));
        System.out.println(solution.singleNumber(new int[]{17,12,5,-6,12,4,17,-5,2,-3,2,4,5,16,-3,-4,15,15,-4,-5,-6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 只要求输出单独的那个数，O(n)的时间复杂度，O(1)的空间复杂度
        // 自己写map这种应该都不满足空间复杂度的要求
        // 只能先排序，然后遍历；因为除了一个数之外，其他所有数都出现2次
        public int singleNumber(int[] nums) {
            Arrays.sort(nums);
            int tmp = nums[0];
            boolean found = false;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    continue;
                }
                if (found) {
                    tmp = nums[i];
                    found = false;
                }
                else {
                    if (tmp == nums[i]) {
                        found = true;
                    }
                    else {
                        break;
                    }
                }
            }
            return tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}