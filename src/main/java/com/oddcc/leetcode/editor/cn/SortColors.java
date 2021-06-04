// 75

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