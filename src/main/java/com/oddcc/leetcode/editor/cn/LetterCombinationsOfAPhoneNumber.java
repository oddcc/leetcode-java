//Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
//elow. Note that 1 does not map to any letters. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
// Related Topics 字符串 回溯算法 
// 👍 942 👎 0


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