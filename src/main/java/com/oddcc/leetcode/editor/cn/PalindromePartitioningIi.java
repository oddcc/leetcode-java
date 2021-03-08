// 132

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningIi {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioningIi().new Solution();
        // System.out.println(solution.minCut("aab"));
        // System.out.println(solution.minCut("a"));
        // System.out.println(solution.minCut("ab"));
        System.out.println(solution.minCut("ababababababababababababcbabababababababababababa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，遍历+回溯，就是在131的基础上加上计数，在所有答案中取最短的

        private int ans;
        public int minCut(String s) {
            ans = 2000;
            List<String> path = new ArrayList<>();
            dfs(s, 0, s.length(), path);
            return ans;
        }

        private void dfs(String s, int start, int end, List<String> path) {
            if (start >= end) {
                ans = Math.min(ans, path.size() - 1);
                return;
            }
            for (int i = start; i < end; i++) {
                if (!isPalindrome(s, start, i)) {
                    continue;
                }
                path.add(s.substring(start, i + 1));
                dfs(s, i + 1, end, path);
                path.remove(path.size() - 1);
            }
        }

        private boolean isPalindrome(String s, int l, int r) {
            while (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
                if (l >= r) return true;
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}