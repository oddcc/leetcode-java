// 49

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(solution.groupAnagrams(new String[]{""}));
        System.out.println(solution.groupAnagrams(new String[]{"a"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，利用每个字符串的字母计数作为key来判断对应的anagram是否出现过；因为int[]默认的equals方法是比较对地址，所以用ArrayList，并在value中记录对应的位置
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> ans = new ArrayList<>();
            Map<List<Integer>, Integer> cache = new HashMap<>();
            int i = 0;
            for (String str : strs) {
                int[] charCount = new int[26];
                for (char c : str.toCharArray()) {
                    charCount[c - 'a']++;
                }
                List<Integer> charCountList = new ArrayList<>();
                for (int x : charCount) {
                    charCountList.add(x);
                }
                if (cache.containsKey(charCountList)) {
                    ans.get(cache.get(charCountList)).add(str);
                }
                else {
                    List<String> tmp = new ArrayList<>();
                    tmp.add(str);
                    ans.add(tmp);
                    cache.put(charCountList, i++);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}