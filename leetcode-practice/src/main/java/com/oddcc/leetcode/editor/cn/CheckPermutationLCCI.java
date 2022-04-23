// 面试题 01.02

package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CheckPermutationLCCI {
    public static void main(String[] args) {
        Solution solution = new CheckPermutationLCCI().new Solution();
        System.out.println(solution.CheckPermutation("abc", "bca"));
        System.out.println(solution.CheckPermutation("abc", "bad"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            Map<Character, Integer> m1 = s2Map(s1);
            Map<Character, Integer> m2 = s2Map(s2);
            return Objects.equals(m1, m2);
        }

        private Map<Character, Integer> s2Map(String s) {
            Map<Character, Integer> m = new HashMap<>();
            for (Character c: s.toCharArray()) {
                if (m.containsKey(c)) {
                    m.put(c, m.get(c) + 1);
                } else {
                    m.put(c, 1);
                }
            }
            return m;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}