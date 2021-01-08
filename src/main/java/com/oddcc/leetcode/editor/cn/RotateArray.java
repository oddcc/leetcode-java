// 189

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        Solution solution = new RotateArray().new Solution();
        solution.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        solution.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);
        solution.rotate(new int[]{-1, -100, 3, 99}, 2);
        solution.rotate(new int[]{1}, 0);
        solution.rotate(new int[]{1, 2}, 3);
        solution.rotate(new int[]{1}, 1);
        solution.rotate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27}, 38);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，直接用队列，出队+入队k次即可
        // 思路2，不用现成的队列，自己用链表实现
        // =========== 以上方法时间复杂度是O(nums.len + k)，即主要时间花在数组和链表的转换以及出队入队操作
        // =========== 题目要求O(1)的空间复杂度
        // 思路3，直接模拟移动就是O(1)的空间复杂度，但是时间复杂度相当高
        // 思路4，寻找规律，k mod nums.len，直接交换，可以采用分治的方法简化逻辑
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            if (k == 0) {
                System.out.println(Arrays.toString(nums));
                return;
            }
            doRotate(nums, k, 0, nums.length);
            System.out.println(Arrays.toString(nums));
        }

        // 包含start，不包含end，end-start=len
        private void doRotate(int[] nums, int k, int start, int end) {
            int len = end - start;
            if (len <= 1) return;
            if (len <= k) {
                k = k % len;
                if (k == 0) return;
            }
            for (int i = 0; i < k; i++) {
                int tmp = nums[start + i];
                nums[start + i] = nums[start + len - k + i];
                nums[start + len - k + i] = tmp;
            }
            doRotate(nums, k, start + k, end);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}