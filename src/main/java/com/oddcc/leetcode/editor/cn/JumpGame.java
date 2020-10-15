package com.oddcc.leetcode.editor.cn;

public class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        System.out.println(solution.canJump(new int[]{2, 3, 1, 1, 4}));
//        System.out.println(solution.canJump(new int[]{3, 2, 1, 0, 4}));
//        System.out.println(solution.canJump(new int[]{2, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，动态规划
        public boolean canJump(int[] nums) {
            // status[i]的意义是，从这个位置开始，能不能达到终点；0-不知道，1-不能达到终点，2-能达到终点
            int[] status = new int[nums.length];
            return canJumpToEnd(0, nums, status);
        }

        private boolean canJumpToEnd(int start, int[] nums, int[] status) {
            // 如果开始的地方已经超过终点了，肯定不行
            if (start > nums.length - 1) return false;
            // 如果开始的地方就是终点，说明可以
            if (start == nums.length - 1) return true;
            boolean can = false;
            for (int i = 1; i <= nums[start]; i++) {
                int newStart = start + i;
                if (newStart > nums.length - 1) break;
                if (status[newStart] == 0) {
                    can = can || canJumpToEnd(newStart, nums, status);
                    status[newStart] = can ? 2 : 1;
                }
                else {
                    can = can || status[newStart] == 2;
                }
            }
            return can;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}