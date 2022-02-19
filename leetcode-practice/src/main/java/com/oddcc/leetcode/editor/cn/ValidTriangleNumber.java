// 611

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class ValidTriangleNumber {
    public static void main(String[] args) {
        Solution solution = new ValidTriangleNumber().new Solution();
        // System.out.println(solution.triangleNumber(new int[]{2, 2, 3, 4}));
        // System.out.println(solution.triangleNumber(new int[]{4, 2, 3, 4}));
        System.out.println(solution.triangleNumber(new int[]{1,2,3,4,5,6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 三角形的三条边，任意两边长度之和大于第三边的长度
    // 思路1，排序+二分查找
    class Solution {
        public int triangleNumber(int[] nums) {
            int len = nums.length;
            Arrays.sort(nums);
            int ans = 0;
            for (int i = 0; i < len - 2; i++) {
                for (int j = i + 1; j < len - 1; j++) {
                    int target = nums[i] + nums[j];
                    int index = searchFirstLower(nums, j + 1, len - 1, target);
                    if (index == -1) continue;
                    ans += index - j;
                }
            }
            return ans;
        }

        private int searchFirstLower(int[] nums, int left, int right, int target) {
            if (right <= left) {
                if (nums[left] < target) return left;
                return -1;
            }
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target) {
                return searchFirstLower(nums, left, mid - 1, target);
            }
            else {
                if (mid + 1 <= right && nums[mid + 1] < target) {
                    return searchFirstLower(nums, mid + 1, right, target);
                }
                else {
                    return mid;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}