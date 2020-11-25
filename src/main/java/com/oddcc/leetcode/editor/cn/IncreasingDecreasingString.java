// 1370

package com.oddcc.leetcode.editor.cn;

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
        // 思路2，思路1其实是桶排序，因为只包含小写英文字母，所以桶数就是26
        public String sortString(String s) {
            int[] charCount = new int[26];
            for (Character c : s.toCharArray()) {
                charCount[c - 'a']++;
            }
            // 开始拼接
            int len = s.length();
            StringBuilder ans = new StringBuilder();
            while (len > 0) {
                for (int i = 0; i < charCount.length; i++) {
                    if (charCount[i] > 0) {
                        ans.append((char) ('a' + i));
                        charCount[i]--;
                        len--;
                    }
                }
                for (int i = charCount.length - 1; i >= 0; i--) {
                    if (charCount[i] > 0) {
                        ans.append((char) ('a' + i));
                        charCount[i]--;
                        len--;
                    }
                }
            }
            return ans.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}