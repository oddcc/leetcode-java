// 13

package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        Solution solution = new RomanToInteger().new Solution();
        System.out.println(solution.convertRomeToInt("III"));
        System.out.println(solution.convertRomeToInt("IV"));
        System.out.println(solution.convertRomeToInt("IX"));
        System.out.println(solution.convertRomeToInt("LVIII"));
        System.out.println(solution.convertRomeToInt("MCMXCIV"));
        System.out.println(solution.convertRomeToInt("DCXXI"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，贪心
    class Solution {
        private final Map<String, Integer> romeMap = new HashMap<String, Integer>() {{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
            put("IV", 4);
            put("IX", 9);
            put("XL", 40);
            put("XC", 90);
            put("CD", 400);
            put("CM", 900);
        }};

        public int romanToInt(String s) {
            // 如果传入的是map中的情况，直接返回
            if (romeMap.get(s) != null) return romeMap.get(s);
            if (s.length() == 0 || s.length() == 1) return 0;
            return convertRomeToInt(s);
        }

        private int convertRomeToInt(String s) {
            int start = 0;
            int result = 0;
            while (start < s.length()) {
                if (start + 2 > s.length()) {
                    result += romeMap.get(s.substring(start, start + 1));
                    start += 1;
                }
                else {
                    String tmp = s.substring(start, start + 2);
                    if (romeMap.get(tmp) != null) {
                        result += romeMap.get(tmp);
                        start += 2;
                    }
                    else {
                        result += romeMap.get(s.substring(start, start + 1));
                        start += 1;
                    }
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}