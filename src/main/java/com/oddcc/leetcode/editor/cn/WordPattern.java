// 290

package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        public boolean wordPattern(String pattern, String s) {
            Map<Character, Set<Integer>> pIndexMap = new HashMap<>();
            char[] patternArray = pattern.toCharArray();
            for (int i = 0; i < patternArray.length; i++) {
                char c = patternArray[i];
                if (pIndexMap.containsKey(c)) {
                    pIndexMap.get(c).add(i);
                }
                else {
                    Set<Integer> indexSet = new HashSet<>();
                    indexSet.add(i);
                    pIndexMap.put(c, indexSet);
                }
            }
            Map<String, Set<Integer>> sIndexMap = new HashMap<>();
            String[] sArray = s.split(" ");
            for (int i = 0; i < sArray.length; i++) {
                String str = sArray[i];
                if (sIndexMap.containsKey(str)) {
                    sIndexMap.get(str).add(i);
                }
                else {
                    Set<Integer> indexSet = new HashSet<>();
                    indexSet.add(i);
                    sIndexMap.put(str, indexSet);
                }
            }
            if (sIndexMap.size() != pIndexMap.size()) return false;
            for (int i = 0; i < sArray.length; i++) {
                if (!sIndexMap.get(sArray[i]).equals(pIndexMap.get(patternArray[i]))) return false;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}