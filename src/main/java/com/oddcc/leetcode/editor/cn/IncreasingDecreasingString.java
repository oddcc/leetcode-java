// 1370

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IncreasingDecreasingString {
    public static void main(String[] args) {
        Solution solution = new IncreasingDecreasingString().new Solution();
        System.out.println(solution.sortString("aaaabbbcccc"));
        System.out.println(solution.sortString("rat"));
        System.out.println(solution.sortString("leetcode"));
        System.out.println(solution.sortString("ggggggg"));
        System.out.println(solution.sortString("spo"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，利用list保存排序后的所有字符，利用map保存字符出现的次数，然后根据描述拼接答案
        public String sortString(String s) {
            List<Character> charList = new ArrayList<>();
            Map<Character, Integer> charCountMap = new HashMap<>();
            for (Character c : s.toCharArray()) {
                if (charCountMap.get(c) == null) {
                    charList.add(c);
                    charCountMap.put(c, 1);
                }
                else {
                    charCountMap.put(c, charCountMap.get(c) + 1);
                }
            }
            charList.sort(Character::compareTo);
            // 开始拼接
            int len = s.length();
            int charCount = charList.size();
            boolean upper = true;
            int current = 0;
            StringBuilder ans = new StringBuilder();
            while (len > 0) {
                // 升
                while (current < charCount) {
                    Character c = charList.get(current);
                    // 说明还可以选
                    if (charCountMap.get(c) > 0) {
                        ans.append(c);
                        charCountMap.put(c, charCountMap.get(c) - 1);
                    }
                    current++;
                }
                // 降
                while (current > 0) {
                    Character c = charList.get(current - 1);
                    // 说明还可以选
                    if (charCountMap.get(c) > 0) {
                        ans.append(c);
                        charCountMap.put(c, charCountMap.get(c) - 1);
                    }
                    current--;
                }
                len--;
            }
            return ans.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}