// 131

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        System.out.println(solution.partition("aa"));
        System.out.println(solution.partition("aab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，要求所有可能的结果，考虑回溯法
        public List<List<String>> partition(String s) {
            List<List<String>> ans = new ArrayList<>();
            List<String> path = new ArrayList<>();
            dfs(s, path, ans, 0, s.length());
            return ans;
        }

        // 包含start，不包含end
        private void dfs(String s, List<String> path, List<List<String>> ans, int start, int end) {
            if (start == end) {
                ans.add(new ArrayList<>(path));
                return;
            }

            for (int i = start; i < end; i++) {
                if (!isPalindrome(s, start, i)) {
                    continue;
                }
                path.add(s.substring(start, i + 1));
                dfs(s, path, ans, i + 1, end);
                path.remove(path.size() - 1);
            }

        }

        private boolean isPalindrome(String s, int l, int r) {
            while (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
                if (l >= r) {
                    return true;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}