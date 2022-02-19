// 1002
package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters {
    public static void main(String[] args) {
        Solution solution = new FindCommonCharacters().new Solution();
        System.out.println(solution.commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(solution.commonChars(new String[]{"cool", "lock", "cook"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 生成结果需要知道两个信息：1，字符是否在所有字符串中都出现过；2，在所有字符串中出现的最小次数是多少（不包括0）
        public List<String> commonChars(String[] A) {
            Map<Character, Integer> appearCount = new HashMap<>();
            Map<Character, Integer> minAppearInOneString = new HashMap<>();
            for (int i = 0; i < A.length; i++) {
                Map<Character, Integer> times = new HashMap<>();
                for (char c : A[i].toCharArray()) {
                    int appear = appearCount.getOrDefault(c, 0);
                    if (appear == i) {
                        appearCount.put(c, appear + 1);
                    }
                    times.put(c, times.getOrDefault(c, 0) + 1);
                }
                for (Map.Entry<Character, Integer> entry : times.entrySet()) {
                    if (entry.getValue() < minAppearInOneString.getOrDefault(entry.getKey(), Integer.MAX_VALUE)) {
                        minAppearInOneString.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            List<String> ans = new ArrayList<>();
            for (Character c : minAppearInOneString.keySet()) {
                if (appearCount.getOrDefault(c, 0) == A.length) {
                    for (int i = 0; i < minAppearInOneString.getOrDefault(c, 0); i++) {
                        ans.add(String.valueOf(c));
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}