// 205

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new IsomorphicStrings().new Solution();
        System.out.println(solution.isIsomorphic("foo", "egg"));
        System.out.println(solution.isIsomorphic("foo", "bar"));
        System.out.println(solution.isIsomorphic("paper", "title"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 字符的对应位置应该相同，但字符可以不同
        public boolean isIsomorphic(String s, String t) {
            boolean ans = true;
            Map<Character, Integer> sCache = new HashMap<>();
            Map<Character, Integer> tCache = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char sC = s.charAt(i);
                sCache.putIfAbsent(sC, i);
                int iS = sCache.get(sC);
                char tC = t.charAt(i);
                tCache.putIfAbsent(tC, i);
                int iT = tCache.get(tC);
                if (iS != iT) return false;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}