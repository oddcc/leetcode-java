// 205

package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new IsomorphicStrings().new Solution();
        System.out.println(solution.isIsomorphic("egg", "add"));
        System.out.println(solution.isIsomorphic("foo", "bar"));
        System.out.println(solution.isIsomorphic("paper", "title"));
        System.out.println(solution.isIsomorphic("", ""));
        System.out.println(solution.isIsomorphic("a", "b"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，同时遍历两个字符串，如果碰到字符的相对位置不符，则返回false
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Integer> cacheS = new HashMap<>();
            Map<Character, Integer> cacheT = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                int i1 = cacheS.getOrDefault(s.charAt(i), i);
                cacheS.putIfAbsent(s.charAt(i), i);
                int i2 = cacheT.getOrDefault(t.charAt(i), i);
                cacheT.putIfAbsent(t.charAt(i), i);
                if (i1 != i2) return false;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}