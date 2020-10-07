//Given an array nums with n objects colored red, white, or blue, sort them in-p
//lace so that objects of the same color are adjacent, with the colors in the orde
//r red, white, and blue. 
//
// Here, we will use the integers 0, 1, and 2 to represent the color red, white,
// and blue respectively. 
//
// Follow up: 
//
// 
// Could you solve this problem without using the library's sort function? 
// Could you come up with a one-pass algorithm using only O(1) constant space? 
// 
//
// 
// Example 1: 
// Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
// Example 2: 
// Input: nums = [2,0,1]
//Output: [0,1,2]
// Example 3: 
// Input: nums = [0]
//Output: [0]
// Example 4: 
// Input: nums = [1]
//Output: [1]
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] is 0, 1, or 2. 
// 
// Related Topics 排序 数组 双指针 
// 👍 642 👎 0


package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        int[] n1 = new int[]{2, 0, 2, 1, 1, 0};
        solution.sortColors(n1);
        System.out.println(Arrays.toString(n1));
        int[] n2 = new int[]{2,0,1};
        solution.sortColors(n2);
        System.out.println(Arrays.toString(n2));
        int[] n3 = new int[]{0};
        solution.sortColors(n3);
        System.out.println(Arrays.toString(n3));
        System.out.println("done");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 交换元素，因为题目中只有0、1、2，遍历时，遇到0就交换到开头，遇到1就交换到0之后的位置，需要遍历两次
        public void sortColors(int[] nums) {
            int insert = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) exchange(nums, i, insert++);
            }
            for (int i = insert; i < nums.length; i++) {
                if (nums[i] == 1) exchange(nums, i, insert++);
            }
        }

        private void exchange(int[] nums, int a, int b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}