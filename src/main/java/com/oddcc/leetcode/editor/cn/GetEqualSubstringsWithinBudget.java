// 1208

package com.oddcc.leetcode.editor.cn;

public class GetEqualSubstringsWithinBudget {
    public static void main(String[] args) {
        Solution solution = new GetEqualSubstringsWithinBudget().new Solution();
        System.out.println(solution.equalSubstring("abcd", "bcdf", 3));
        System.out.println(solution.equalSubstring("abcd", "cdef", 3));
        System.out.println(solution.equalSubstring("abcd", "acde", 0));
        System.out.println(solution.equalSubstring("krrgw", "zjxss", 19));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，暴力法，以每个位i为起点，向后移动指针，看看最大子串的长度，并记录下来
        // 思路2，滑动窗口，维护一个总的cost，当前cost小于maxCost时，窗口右边界扩展，当cost超过maxCost时，窗口左边界收缩，直到右边界移动到末尾
        public int equalSubstring(String s, String t, int maxCost) {
            int ans = 0;
            int cost = 0;
            int left = 0;
            int right = 0;
            while (right < s.length()) {
                char cS = s.charAt(right);
                char cT = t.charAt(right);
                int c = Math.abs(cS - cT);
                // right可以算进连续子串之中
                if (cost + c <= maxCost) {
                    ans = Math.max(ans, right - left + 1);
                }
                // right不能算进连续子串之中
                else {
                    if (left >= 0) {
                        cost -= Math.abs(s.charAt(left) - t.charAt(left));
                    }
                    left++;
                }
                cost += c;
                right++;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}