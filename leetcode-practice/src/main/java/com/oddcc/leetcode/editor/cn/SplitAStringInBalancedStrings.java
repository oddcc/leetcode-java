// 1221

package com.oddcc.leetcode.editor.cn;

public class SplitAStringInBalancedStrings {
    public static void main(String[] args) {
        Solution solution = new SplitAStringInBalancedStrings().new Solution();
        System.out.println(solution.balancedStringSplit("RLRRLLRLRL"));
        System.out.println(solution.balancedStringSplit("RLLLLRRRLR"));
        System.out.println(solution.balancedStringSplit("LLLLRRRR"));
        System.out.println(solution.balancedStringSplit("RLRRRLLRLL"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，贪心
    class Solution {
        public int balancedStringSplit(String s) {
            int len = s.length();
            int ans = 0;
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == 'L') {
                    count++;
                }
                else {
                    count--;
                }
                if (count == 0) {
                    ans++;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}