// 3
package com.oddcc.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring(""));
        System.out.println(solution.lengthOfLongestSubstring("aab"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() <= 1) return s.length();
            Set<Character> cache = new HashSet<>();
            int ans = 0;
            int start = 0;
            int end = 0;
            while (start < s.length() && end < s.length()) {
                if (cache.contains(s.charAt(end))) {
                    cache.clear();
                    start++;
                    end = start;
                }
                else {
                    if (end - start + 1 > ans) {
                        ans = end - start + 1;
                    }
                    cache.add(s.charAt(end));
                    end++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}