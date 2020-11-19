// 283

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        int[] n1 = new int[]{0, 1, 0, 3, 12};
        // int[] n1 = new int[]{1, 0};
        solution.moveZeroes(n1);
        System.out.println(Arrays.toString(n1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，题目要求in-place操作，想到双指针a和b，其中a指向0，b指向非0；a从前往后遍历，b每次从a的位置向后找，找到就交换，当a到达末尾时流程结束
        // 时间复杂度可能达到O(N^2)
        // 思路2，每次交换之后，b指针不用从a的地方从新开始，因为b之前都是0，不然b就不会指向当前的位置
        public void moveZeroes(int[] nums) {
            int left = 0;
            int right = 0;
            while (left < nums.length) {
                if (nums[left] == 0) {
                    while (right < nums.length) {
                        // 只有right在left右边时才交换
                        if (nums[right] != 0 && left < right) {
                            swap(nums, left, right);
                            break;
                        }
                        else {
                            right++;
                        }
                    }
                }
                left++;
            }
        }

        private void swap(int[] nums, int a, int b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}