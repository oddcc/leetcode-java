// 692

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentWords().new Solution();
        System.out.println(solution.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(solution.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 1));
        System.out.println(solution.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 题目要求O(n log k) time and O(n) extra space.
    // 思路1,哈希计数+排序
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> countMap = new HashMap<>();
            for (String word : words) {
                countMap.put(word, countMap.getOrDefault(word, 0) + 1);
            }
            List<String> ans = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                ans.add(entry.getKey());
            }
            ans.sort((word1, word2) -> countMap.get(word1).equals(countMap.get(word2)) ? word1.compareTo(word2) : countMap.get(word2) - countMap.get(word1));
            return ans.subList(0, k);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}