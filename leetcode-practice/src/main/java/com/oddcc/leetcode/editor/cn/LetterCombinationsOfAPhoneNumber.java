// 17

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("2"));
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinations(""));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Character, List<String>> mapping = init();

        private Map<Character, List<String>> init() {
            Map<Character, List<String>> m = new HashMap<>();
            m.put('2', Arrays.asList("a", "b", "c"));
            m.put('3', Arrays.asList("d", "e", "f"));
            m.put('4', Arrays.asList("g", "h", "i"));
            m.put('5', Arrays.asList("j", "k", "l"));
            m.put('6', Arrays.asList("m", "n", "o"));
            m.put('7', Arrays.asList("p", "q", "r", "s"));
            m.put('8', Arrays.asList("t", "u", "v"));
            m.put('9', Arrays.asList("w", "x", "y", "z"));
            return m;
        }

        // 思路是直接模拟笛卡尔积
        public List<String> letterCombinations(String digits) {
            init();
            List<String> ans = new ArrayList<>();
            for (Character c: digits.toCharArray()) {
                ans = descartes(ans, mapping.get(c));
            }
            return ans;
        }

        private List<String> descartes(List<String> l1, List<String> l2) {
            if (l1.isEmpty()) return l2;
            List<String> ans = new ArrayList<>();
            for (String i : l1) {
                for (String j : l2) {
                    ans.add(i + j);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}