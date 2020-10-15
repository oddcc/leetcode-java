package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
//        System.out.println(solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(solution.groupAnagrams(new String[]{"",""}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，暴力法，扫描并用哈希表存储（排序后作为key），时间复杂度O(n)，空间复杂度O(n)
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0) return new ArrayList<>();
            Map<String, List<String>> cache = new HashMap<>();
            for (String s: strs) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String key = String.copyValueOf(chars);
                if (!cache.containsKey(key)) {
                    cache.put(key, new ArrayList<>());
                }
                cache.get(key).add(s);
            }
            List<List<String>> ans = new ArrayList<>();
            for (String key: cache.keySet()) {
                ans.add(new ArrayList<>(cache.get(key)));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}