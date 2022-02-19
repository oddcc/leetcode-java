// 1004

package com.oddcc.leetcode.editor.cn;

public class MaxConsecutiveOnesIii {
    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnesIii().new Solution();
        System.out.println(solution.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(solution.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，利用滑动窗口，要求滑动窗口内0的数量count不超过K
        // 当不满足条件时，要通过移动左右边界来使条件得到满足
        // 首先扩展右边界，当count <= K时，右边界就可以向右移动，当count > K时，要收缩左边界，并同时更新count
        // 每次不满足条件时，计算长度right - left + 1
        public int longestOnes(int[] A, int K) {
            int ans = 0;
            int len = A.length;
            int left = 0;
            int right = 0;
            int zeroCount = 0;
            while (right < len) {
                while (right < len) {
                    if (A[right] == 0) zeroCount++;
                    if (zeroCount > K) break;
                    right++;
                }
                if (right == len - 1 && A[right] == 1) {
                    ans = Math.max(right - left + 1, ans);
                }
                else {
                    ans = Math.max(right - left, ans);
                }
                while (zeroCount > K && left < len) {
                    if (A[left] == 0) zeroCount--;
                    left++;
                }
                right++;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}