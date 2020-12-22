// 387

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
        System.out.println(solution.firstUniqChar("leetcode"));
        System.out.println(solution.firstUniqChar("loveleetcode"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 两个哈希表，一个记录出现的次数，一个记录最先出现的位置，然后遍历两个哈希表得到结果
        public int firstUniqChar(String s) {
            Map<Character, Integer> countMap = new HashMap<>();
            Map<Character, Integer> firstIndexMap = new HashMap<>();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                Character c = chars[i];
                int count = countMap.getOrDefault(c, 0);
                countMap.put(c, count + 1);
                if (!firstIndexMap.containsKey(c)) {
                    firstIndexMap.put(c, i);
                }
            }

            List<Character> shownOnce = new ArrayList<>();
            for (Character k : countMap.keySet()) {
                if (countMap.get(k) == 1) shownOnce.add(k);
            }
            if (shownOnce.isEmpty()) return -1;
            int min = Integer.MAX_VALUE;
            for (Character k : shownOnce) {
                if (firstIndexMap.get(k) < min) {
                    min = firstIndexMap.get(k);
                }
            }
            return min;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}