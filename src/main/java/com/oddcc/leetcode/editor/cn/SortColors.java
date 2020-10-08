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
        // 直接排序，多种排序方法中，必有快速排序比较符合需求
        public void sortColors(int[] nums) {
            sort(nums, 0, nums.length - 1);
        }

        private void sort(int[] nums, int low, int high) {
            if (low >= high) return;
            int i = low;
            int j = high + 1;
            int pivot = nums[low];
            while (true) {
                while (nums[++i] < pivot) {
                    if (i == high) {
                        break;
                    }
                }
                while (nums[--j] > pivot) {
                    if (j == low) {
                        break;
                    }
                }
                if (i >= j) break;
                exchange(nums, i, j);
            }
            exchange(nums, low, j);
            sort(nums, low, j - 1);
            sort(nums, j + 1, high);
        }

        private void exchange(int[] nums, int a, int b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}