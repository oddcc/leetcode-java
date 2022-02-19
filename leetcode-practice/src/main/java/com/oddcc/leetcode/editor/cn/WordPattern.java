// 290

package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        Solution solution = new WordPattern().new Solution();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
        System.out.println(solution.wordPattern("abba", "dog cat cat fish"));
        System.out.println(solution.wordPattern("abba", "dog dog dog dog"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，有多少个元素出现，元素的位置是什么；都求出来之后再进行比较
        // 思路2，题目中提到了bijection，双射
        public boolean wordPattern(String pattern, String s) {
            Map<String, Character> strChar = new HashMap<>();
            Map<Character, String> charStr = new HashMap<>();
            char[] chars = pattern.toCharArray();
            String[] strs = s.split(" ");
            if (strs.length != chars.length) return false;
            for (int i = 0; i < chars.length; i++) {
                // 对应关系建立了就不能修改，一旦不符则说明有问题
                if (strChar.get(strs[i]) == null) {
                    strChar.put(strs[i], chars[i]);
                }
                if (charStr.get(chars[i]) == null) {
                    charStr.put(chars[i], strs[i]);
                }
                if (!strChar.get(strs[i]).equals(chars[i])) return false;
                if (!charStr.get(chars[i]).equals(strs[i])) return false;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}