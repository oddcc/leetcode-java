//Given an array of size n, find the majority element. The majority element is t
//he element that appears more than ⌊ n/2 ⌋ times. 
//
// You may assume that the array is non-empty and the majority element always ex
//ist in the array. 
//
// Example 1: 
//
// 
//Input: [3,2,3]
//Output: 3 
//
// Example 2: 
//
// 
//Input: [2,2,1,1,1,2,2]
//Output: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 753 👎 0


package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
        System.out.println(solution.majorityElement(new int[]{3, 2, 3}));
        System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(solution.majorityElement(new int[]{2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 1. 暴力计数法，时间复杂度O(n)空间复杂度O(n)
        // 2. 先排序，再遍历计数，如果碰到了可以提前返回，时间复杂度O(n)空间复杂度O(1)
        public int majorityElement(int[] nums) {
            if (nums.length == 1) return nums[0];
            Arrays.sort(nums);
            int majorityCount = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1;
            int last = 0;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    last = nums[i];
                    count++;
                }
                else {
                    if (nums[i] == last) {
                        count++;
                        if (count >= majorityCount) {
                            return nums[i];
                        }
                    }
                    else {
                        last = nums[i];
                        count = 1;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}