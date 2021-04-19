// 27

package com.oddcc.leetcode.editor.cn;

public class RemoveElement {
    public static void main(String[] args) {
        Solution solution = new RemoveElement().new Solution();
        System.out.println(solution.removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(solution.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，双指针，一个指向要交换的值，一个指向要找的值
        public int removeElement(int[] nums, int val) {
            int len = nums.length;
            int slow = 0;
            int fast = 0;
            while (slow < len && fast < len) {
                // 找==val的值，这些值是要交换到后面去的
                while (slow < len && nums[slow] != val) slow++;
                if (slow >= fast) fast = slow + 1; // 只往后进行交换，所以只往后找
                // 找不等于val的值
                while (fast < len && nums[fast] == val) fast++;
                if (slow < len && fast < len) {
                    int tmp = nums[fast];
                    nums[fast] = nums[slow];
                    nums[slow] = tmp;
                }
            }
            return slow;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}