// 115

package com.oddcc.leetcode.editor.cn;

public class DistinctSubsequences {
    public static void main(String[] args) {
        Solution solution = new DistinctSubsequences().new Solution();
        System.out.println(solution.numDistinct("rabbbit", "rabbit"));
        System.out.println(solution.numDistinct("babgbag", "bag"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，如果f(i,j)可以得到s[0...i]和t[0...j]的匹配数，那么我们可以推出以下结果
        // 如果s[i]==t[j]的话，我们有两个选择
        // 匹配s[i]和t[j]这样的话，剩下需要匹配的就是s[0...i-1]和t[0...j-1]，这种情况下f(i,j)=f(i-1,j-1)
        // 不匹配s[i]和t[j]，这种情况下f(i,j)=f(i-1,j)
        // 如果s[i]!=t[j]的话，只有一个选择，f(i,j)=f(i-1,j)
        // 思路2，动态规划，递推公式跟递归的是一个道理
        public int numDistinct(String s, String t) {
            int i = s.length();
            int j = t.length();
            int[][] dp = new int[i + 1][j + 1]; // dp[i][j]表示s[0...i)和t[0...j)的匹配方式数，注意右端点是不包含的
            for (int x = 0; x < i + 1; x++) {
                dp[x][0] = 1; // 因为t为空串时，s总有一种方式来匹配，选择0个字符
            }
            for (int x = 1; x < i + 1; x++) {
                for (int y = 1; y < j + 1; y++) {
                    if (s.charAt(x - 1) == t.charAt(y - 1)) {
                        dp[x][y] = dp[x - 1][y - 1] + dp[x - 1][y];
                    }
                    else {
                        dp[x][y] = dp[x - 1][y];
                    }
                }
            }
            return dp[i][j];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}