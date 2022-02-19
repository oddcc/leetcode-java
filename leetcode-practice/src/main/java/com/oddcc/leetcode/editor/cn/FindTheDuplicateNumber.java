// 287

package com.oddcc.leetcode.editor.cn;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution solution = new FindTheDuplicateNumber().new Solution();
        System.out.println(solution.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(solution.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，数字的范围是确定的，总共有n+1个数，数组index范围是0～n，从头遍历，把[i-1]位标记为负，如果标记的时候发现已经为负，则当前i就是重复的值
        public int findDuplicate(int[] nums) {
            int ans = -1;
            for (int i : nums) {
                int n = Math.abs(i);
                if (nums[n] < 0) return n;
                nums[Math.abs(i)] = -nums[Math.abs(i)];
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}