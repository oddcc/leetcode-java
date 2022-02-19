// 395

package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，分治法
        public int longestSubstring(String s, int k) {
            // 如果s.length < k则不可能满足条件，返回0
            if (s.length() < k) return 0;
            HashMap<Character, Integer> charCountMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                charCountMap.put(s.charAt(i), charCountMap.getOrDefault(s.charAt(i), 0) + 1);
            }
            for (char c : charCountMap.keySet()) {
                // 如果c出现的次数不到k，则所有包含c的子数组都不可能是答案，所以要对所有不包含c的子数组进行计算
                if (charCountMap.get(c) < k) {
                    int maxLen = 0;
                    for (String t : s.split(String.valueOf(c))) {
                        maxLen = Math.max(maxLen, longestSubstring(t, k));
                    }
                    return maxLen;
                }
            }
            // 说明所有的c出现次数都<=k
            return s.length();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}