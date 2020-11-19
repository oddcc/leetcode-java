// 283

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        int[] n1 = new int[]{0, 1, 0, 3, 12};
        // int[] n1 = new int[]{};
        solution.moveZeroes(n1);
        System.out.println(Arrays.toString(n1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 题目要求in-place操作，想到双指针a和b，其中a指向0，b指向非0；a从前往后遍历，b每次从a的位置向后找，找到就交换，当a到达末尾时流程结束
        public void moveZeroes(int[] nums) {
            for (int zero = 0; zero < nums.length; zero++) {
                if (nums[zero] == 0) {
                    int nonZero = zero + 1;
                    while (nonZero < nums.length) {
                        if (nums[nonZero] != 0) {
                            swap(nums, zero, nonZero);
                            break;
                        }
                        else {
                            nonZero++;
                        }
                    }
                }
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