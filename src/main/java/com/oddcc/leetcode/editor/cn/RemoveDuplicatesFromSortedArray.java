// 26

package com.oddcc.leetcode.editor.cn;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
        System.out.println(solution.removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(solution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，双指针，一个指向要交换的位置，另一个指向要寻找的值，当后一个指针到数组末尾时，流程结束
        public int removeDuplicates(int[] nums) {
            int len = nums.length;
            if (len < 2) return len;
            int slow = 1;
            int fast = 1;
            int cur = nums[0];
            while (fast < nums.length) {
                if (nums[fast] > cur) {
                    int tmp = nums[fast];
                    nums[fast] = nums[slow];
                    nums[slow] = tmp;
                    cur = nums[slow];
                    slow++;
                }
                fast++;
            }
            return slow;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}