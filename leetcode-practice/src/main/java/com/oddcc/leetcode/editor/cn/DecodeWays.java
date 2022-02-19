// 91

package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    public static void main(String[] args) {
        Solution solution = new DecodeWays().new Solution();
        System.out.println(solution.numDecodings("12"));
        System.out.println(solution.numDecodings("226"));
        System.out.println(solution.numDecodings("0"));
        System.out.println(solution.numDecodings("06"));
        System.out.println(solution.numDecodings("1"));
        System.out.println(solution.numDecodings("10"));
        System.out.println(solution.numDecodings("1201234"));
        System.out.println(solution.numDecodings("123123"));
        System.out.println(solution.numDecodings("230"));
        System.out.println(solution.numDecodings("111111111111111111111111111111111111111111111"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，递归，超时
        // 思路2，递归+缓存
        public int numDecodings(String s) {
            return numDecodings(s.toCharArray(), 0, new HashMap<>());
        }

        private int numDecodings(char[] chars, int start, Map<Integer, Integer> cache) {
            if (start > chars.length - 1) return 0;
            if (chars[start] == '0') return 0;
            // 剩2个字符时
            if (start == chars.length - 2) {
                if (!cache.containsKey(start + 1)) cache.put(start + 1, numDecodings(chars, start + 1, cache));

                if ((chars[start] == '2' && chars[start + 1] <= '6') || chars[start] == '1') {
                    return 1 + cache.get(start + 1);
                }
                return cache.get(start + 1);
            }
            // 剩1个字符时
            if (start == chars.length - 1) {
                // 如果这个字符是0，没有这种选法，返回0；其他字符返回1
                if (chars[start] == '0') return 0;
                return 1;
            }
            if ((chars[start] == '2' && chars[start + 1] <= '6') || chars[start] == '1') {
                if (!cache.containsKey(start + 1)) cache.put(start + 1, numDecodings(chars, start + 1, cache));
                if (!cache.containsKey(start + 2)) cache.put(start + 2, numDecodings(chars, start + 2, cache));
                return cache.get(start + 1) + cache.get(start + 2);
            }

            if (!cache.containsKey(start + 1)) cache.put(start + 1, numDecodings(chars, start + 1, cache));
            return cache.get(start + 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}