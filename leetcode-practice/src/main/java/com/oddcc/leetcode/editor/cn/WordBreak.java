// 139

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();
        System.out.println(solution.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(solution.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int[] dp = new int[s.length()]; // dp[i]表示字符串s中，[0,i]的子串是否能被拆分 0-不知道，1-能，2-不能
            return dfs(s, s.length() - 1, dp, wordDict);
        }

        private boolean dfs(String s, int i, int[] dp, List<String> wordDict) {
            if (i < 0) return false; // 是上层调用的结果；如果i==0，说明正好拆分完，如果i<0，说明剩余长度不够拆分
            if (dp[i] != 0) return dp[i] == 1; // 如果计算过，直接返回
            s = s.substring(0, i + 1); // 把字符串按需求截短，方便后续计算
            List<Boolean> valid = new ArrayList<>(); // 存放计算结果
            for (String word : wordDict) {
                // 尝试每一个word，如果是以word结尾的，则把word去掉继续尝试拆分
                if (s.endsWith(word)) {
                    int newI = i - word.length(); // 去掉word后，剩余子串的末尾索引
                    // 正好拆分完，newI应该是-1
                    if (newI < 0) {
                        valid.add(true);
                        continue;
                    }
                    if (dp[newI] != 0) {
                        valid.add(dp[newI] == 1);
                        continue;
                    }
                    dp[newI] = dfs(s, newI, dp, wordDict) ? 1 : 2;
                    valid.add(dp[newI] == 1);
                }
                else {
                    valid.add(false);
                }
            }
            return valid.stream().reduce(false, (b1, b2) -> b1 || b2); // 有一个true就说明能完成拆分
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}