// 80

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArrayIi().new Solution();
        System.out.println(solution.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(solution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，类似冒泡排序，每次发现一个重复的，就移到最尾端，并把末尾指针前移，时间复杂度O(n^2)
        // 思路2，双指针一次遍历，指针l指向重复的位置，需要交换；指针r指向需要的数的位置
        // l每右移一次，数组长度就+1，l左边都是已经确定的结果
        // r永远向右边找
        public int removeDuplicates(int[] nums) {
            int ans = 1;
            int len = nums.length;
            int count = 1;
            int r = 0;
            for (int i = 1; i < len; i++) {
                if (nums[i - 1] == nums[i]) {
                    if (count < 2) {
                        count++;
                    }
                    else {
                        // 找大于nums[i-1]的值交换
                        if (r <= i) r = i + 1;
                        while (r < len && nums[r] <= nums[i - 1]) r++;
                        if (r >= len) break;
                        exchange(nums, i, r);
                        count = 1;
                    }
                }
                else if (nums[i - 1] > nums[i]) {
                    if (count < 2) {
                        // 找大于等于nums[i-1]的值交换
                        if (r <= i) r = i + 1;
                        while (r < len && nums[r] < nums[i - 1]) r++;
                        if (r >= len) break;
                        exchange(nums, i, r);
                        if (nums[i] > nums[i - 1]) {
                            count = 1;
                        }
                        else {
                            count++;
                        }
                    }
                    else {
                        // 找大于nums[i-1]的值交换
                        if (r <= i) r = i + 1;
                        if (r >= len) break;
                        while (r < len && nums[r] <= nums[i - 1]) r++;
                        if (r >= len) break;
                        exchange(nums, i, r);
                        count = 1;
                    }
                }
                else {
                    count = 1;
                }
                ans++;
            }

            System.out.println(Arrays.toString(nums));
            return ans;
        }

        private void exchange(int[] nums, int l, int r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}