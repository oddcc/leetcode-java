package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        int[] n1 = new int[]{1, 2, 3};
        solution.nextPermutation(n1);
        System.out.println(Arrays.toString(n1));
        int[] n2 = new int[]{3, 2, 1};
        solution.nextPermutation(n2);
        System.out.println(Arrays.toString(n2));
        int[] n3 = new int[]{1, 5, 1};
        solution.nextPermutation(n3);
        System.out.println(Arrays.toString(n3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 以字典序来说，升序最小，降序最大
        // https://leetcode.com/problems/next-permutation/solution/ 英文的题解要比中文更好理解
        public void nextPermutation(int[] nums) {
            int len = nums.length;
            if (len <= 1) return;
            // 从右端开始找，找到不满足降序的元素
            int i = len - 1;
            while (i > 0 && nums[i - 1] >= nums[i]) {
                i--;
            }
            if (i == 0) {
                reverse(nums, 0, len);
                return;
            }
            // 结束时，i-1指向的就是不满足条件的元素，找i-1右侧仅大于刚大于i-1的第一个数
            int j = i;
            while (j < len && nums[j] > nums[i - 1]) {
                j++;
            }
            swap(nums, i - 1, j - 1);
            // i - 1之后的排序，使之成为升序
            Arrays.sort(nums, i, len);
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        /**
         *
         * @param nums
         * @param x include
         * @param y exclude
         */
        private void reverse(int[] nums, int x, int y) {
            y = y - 1;
            for (int i = 0; i <= (y - x) / 2; i++) {
                swap(nums, x + i, y - i);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}