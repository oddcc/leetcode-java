// 剑指 Offer 21

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    public static void main(String[] args) {
        Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        System.out.println(Arrays.toString(solution.exchange(new int[]{1, 2, 3, 4})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，双指针分别找奇数和偶数，然后交换，类似快排的交换阶段
        public int[] exchange(int[] nums) {
            int len = nums.length;
            int left = 0;
            int right = len - 1;
            while (left < right) {
                while (left < len && nums[left] % 2 != 0) left++;
                while (right >= 0 && nums[right] % 2 == 0) right--;
                if (left < len && right >= 0 && left < right) {
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                }
            }
            return nums;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}