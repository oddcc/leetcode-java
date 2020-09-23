//Implement next permutation, which rearranges numbers into the lexicographicall
//y next greater permutation of numbers. 
//
// If such arrangement is not possible, it must rearrange it as the lowest possi
//ble order (ie, sorted in ascending order). 
//
// The replacement must be in-place and use only constant extra memory. 
//
// Here are some examples. Inputs are in the left-hand column and its correspond
//ing outputs are in the right-hand column. 
//
// 1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组 
// 👍 670 👎 0


package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        int[] n1 = new int[]{1,2,3};
        solution.nextPermutation(n1);
        System.out.println(Arrays.toString(n1));
        int[] n2 = new int[]{3,2,1};
        solution.nextPermutation(n2);
        System.out.println(Arrays.toString(n2));
        int[] n3 = new int[]{1,1,5};
        solution.nextPermutation(n3);
        System.out.println(Arrays.toString(n3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            if (nums.length <= 1) return;
            // 找一个nums[i] < nums[i - 1]的位置，出现的话，表示把i位置与右侧比它大的数交换，数字都会变得更大
            int found = -1;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    found = i;
                    break;
                }
            }
            // 如果循环完了还没找到，就说明本身是个降序的数组，reverse成升序就可以
            if (found == -1) {
                reverse(nums, 0, nums.length - 1);
                return;
            }
            // 如果找到了，要从found的右侧，找一个大于nums[found]的最小的数，交换之后数字才是最小的
            // 交换之后，found右侧还是降序的，如果变成升序则是最小的
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[found]) {
                    swap(nums, i, found);
                    break;
                }
            }
            reverse(nums, found + 1, nums.length - 1);
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        private void reverse(int[] nums, int x, int y) {
            for (int i = 0; i <= (y - x) / 2; i++) {
                swap(nums, x + i, y - i);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}