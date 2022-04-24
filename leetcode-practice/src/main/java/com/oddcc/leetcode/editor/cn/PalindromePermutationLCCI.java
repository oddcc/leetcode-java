// 面试题 01.04

package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutationLCCI {
    public static void main(String[] args) {
        Solution solution = new PalindromePermutationLCCI().new Solution();
        System.out.println(solution.canPermutePalindrome("tactcoa"));
        System.out.println(solution.canPermutePalindrome("tactcoad"));
        System.out.println(solution.canPermutePalindrome("a"));
        System.out.println(solution.canPermutePalindrome(""));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPermutePalindrome(String s) {
            Map<Character, Integer> charCnt = new HashMap<>();
            for (Character c: s.toCharArray()) {
                if (charCnt.containsKey(c)) {
                    charCnt.put(c, charCnt.get(c) + 1);
                } else {
                    charCnt.put(c, 1);
                }
            }
            boolean foundOdd = false;
            for (Character c: charCnt.keySet()) {
                if (charCnt.get(c) % 2 == 0) continue;
                if (foundOdd) return false;
                foundOdd = true;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}