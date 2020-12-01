package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{1}, 1)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{0, 0, 2, 3, 4, 4, 4, 5}, 5)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，O(N)的解法
        public int[] searchRange(int[] nums, int target) {
            int start = -1;
            int end = -1;
            for (int i = 0; i < nums.length; i++) {
                // 先找左边
                if (start == -1) {
                    if (nums[i] != target) continue;
                    start = i;
                    end = i;
                }
                else {
                    // 再找右边
                    if (nums[i] == target) {
                        end = i;
                        continue;
                    }
                    break;
                }
            }
            return start != -1 ? new int[]{start, end} : new int[]{-1, -1};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}