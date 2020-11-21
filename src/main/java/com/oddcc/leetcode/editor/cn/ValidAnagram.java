// 242

package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("rat", "car"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 判断是否字母异位词，就是说含有相同的字母，只是位置不同。使用哈希表
        public boolean isAnagram(String s, String t) {
            Map<Character, Integer> cache = new HashMap<>();
            for (Character c: s.toCharArray()) {
                Integer count = cache.getOrDefault(c, 0);
                cache.put(c, count+1);
            }
            for (Character c: t.toCharArray()) {
                Integer count = cache.get(c);
                if (count == null) return false;
                cache.put(c, count - 1);
            }
            return cache.entrySet().stream().allMatch(entry -> entry.getValue() == 0);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}