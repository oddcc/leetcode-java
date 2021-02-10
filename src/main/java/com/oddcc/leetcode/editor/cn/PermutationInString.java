// 567

package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
        System.out.println(solution.checkInclusion("adc", "dcda"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，暴力法，如果s1的长度为l1，s2的长度为s2，则需要遍历s2-s1个子字符串，看看子串是否是s1的排列
        // 思路2，优化思路1，关键在于，如何快速的判断一个子串是否是s1的排列，而不是每次都重新数一遍
        // 使用滑动窗口+哈希计数
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) return false; // 题目没说s1一定短于s2
            int right = 0;
            Map<Character, Integer> s1Count = new HashMap<>();
            for (Character c : s1.toCharArray()) {
                s1Count.put(c, s1Count.getOrDefault(c, 0) + 1);
            }
            Map<Character, Integer> arrCount = new HashMap<>();
            while (right < s2.length()) {
                // 第一次迭代时
                while (right < s1.length()) {
                    char c = s2.charAt(right);
                    arrCount.put(c, arrCount.getOrDefault(c, 0) + 1);
                    right++;
                }
                if (valid(s1Count, arrCount)) return true;
                int left = right - s1.length();
                arrCount.put(s2.charAt(left), arrCount.getOrDefault(s2.charAt(left), 0) - 1);
                if (arrCount.get(s2.charAt(left)) == 0) arrCount.remove(s2.charAt(left));
                if (right < s2.length()) arrCount.put(s2.charAt(right), arrCount.getOrDefault(s2.charAt(right), 0) + 1);
                right++;
            }
            if (valid(s1Count, arrCount)) return true;
            return false;
        }

        private boolean valid(Map<Character, Integer> s1Count, Map<Character, Integer> arrCount) {
            for (Character k : s1Count.keySet()) {
                if (!s1Count.get(k).equals(arrCount.get(k))) return false;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}