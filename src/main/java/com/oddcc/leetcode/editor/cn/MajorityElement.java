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
        System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 3}));
        System.out.println(solution.majorityElement(new int[]{2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 1. 暴力计数法，时间复杂度O(n)空间复杂度O(n)
        // 2. 先排序，再遍历计数，如果碰到了可以提前返回，时间复杂度O(n)空间复杂度O(1)
        // 3. 先排序，然后直接返回，数组⌊ n/2 ⌋位置的数必定是结果，就好像一个滑动窗口
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}