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
        // 思路3，优化思路2
        public int removeDuplicates(int[] nums) {
            int ans = 2;
            int len = nums.length;
            int r = 0;
            for (int i = 2; i < len; i++) {
                // 遍历每一个位置，如果不符合题意，就跟后面符合题意的元素交换
                // i左侧是已确定的数组
                // nums[i] < nums[i - 1]明显不合要求
                // nums[i] == nums[i - 2]是同样数字重复超过2次的情况
                if (nums[i] < nums[i - 1] || nums[i] == nums[i - 2]) {
                    // 找大于nums[i-2]的值交换
                    while (r < len && nums[r] <= nums[i - 2]) r++;
                    if (r >= len) break; // 当所有元素都找过时，跳出循环
                    exchange(nums, i, r);
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