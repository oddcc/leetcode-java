// 451

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.StringUtils;

import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        Solution solution = new SortCharactersByFrequency().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，哈希计数再排序
    class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> cache = new HashMap<>();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                int frequency = cache.getOrDefault(c, 0) + 1;
                cache.put(c, frequency);
            }
            List<Character> list = new ArrayList<>(cache.keySet());
            list.sort((a, b) -> cache.get(b) - cache.get(a));
            StringBuilder sb = new StringBuilder();
            for (char c : list) {
                int frequency = cache.get(c);
                sb.append(StringUtils.repeat(String.valueOf(c), Math.max(0, frequency)));
            }
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}