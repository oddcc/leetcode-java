// 87

package com.oddcc.leetcode.editor.cn;

public class ScrambleString {
    public static void main(String[] args) {
        Solution solution = new ScrambleString().new Solution();
        System.out.println(solution.isScramble("great", "rgeat"));
        System.out.println(solution.isScramble("abca", "caba"));
        System.out.println(solution.isScramble("abcde", "caebd"));
        System.out.println(solution.isScramble("a", "a"));
        System.out.println(solution.isScramble("abb", "bba"));
        System.out.println(solution.isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，递归，会超时
        public boolean isScramble(String s1, String s2) {
            if (s1.length() != s2.length()) return false;
            if (s1.equals(s2)) return true;
            for (int i = 1; i < s1.length(); i++) {
                // s1和s2都拆分成[0,i)和[i,len)，对比是否"相等"，这种是拆分之后没交换的情况
                if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                    return true;
                // s1拆成[0,i)和[i,len)，s2拆成[0,len-i)和[len-i,len)，对比是否"相等"，这种情况就是拆分之后交换的情况
                if (isScramble(s1.substring(0, i), s2.substring(s1.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s1.length() - i)))
                    return true;
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}