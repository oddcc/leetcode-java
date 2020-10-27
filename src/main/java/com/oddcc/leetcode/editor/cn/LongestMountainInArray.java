package com.oddcc.leetcode.editor.cn;

public class LongestMountainInArray {
    public static void main(String[] args) {
        Solution solution = new LongestMountainInArray().new Solution();
        System.out.println(solution.longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
        System.out.println(solution.longestMountain(new int[]{2, 2, 2}));
        System.out.println(solution.longestMountain(new int[]{1, 3, 8, 2, 3, 4, 5, 4, 3, 2, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 遍历一遍，以每个点为mountain的顶点向两边遍历，如果发现不符则放弃，发现符合则记录长度并比较
        public int longestMountain(int[] A) {
            int maxLen = 0;
            for (int i = 0; i < A.length; i++) {
                int len = getMountainLen(i, A);
                if (len >= 3 && len >= maxLen) {
                    maxLen = len;
                }
            }
            return maxLen;
        }

        private int getMountainLen(int top, int[] nums) {
            int left = top - 1;
            int leftTmp = nums[top];
            boolean leftDown = false;
            int right = top + 1;
            int rightTmp = nums[top];
            boolean rightDown = false;
            int len = 1;
            while (left >= 0 && left < nums.length && nums[left] < leftTmp) {
                if (!leftDown) leftDown = true;
                leftTmp = nums[left];
                left--;
                len++;
            }
            while (right >= 0 && right < nums.length && nums[right] < rightTmp) {
                if (!rightDown) rightDown = true;
                rightTmp = nums[right];
                right++;
                len++;
            }
            if (rightDown && leftDown) {
                return len;
            } else {
                return 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}