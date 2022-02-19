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
        // 思路2，简单的递归包含很多重复计算，通过缓存计算结果的方式优化
        private int[][][][] cache; // 0表示未知，1表示true，-1表示false

        public boolean isScramble(String s1, String s2) {
            int len = s1.length();
            cache = new int[len][len][len][len];
            return isScramble(s1.toCharArray(), 0, len - 1, s2.toCharArray(), 0, len - 1);
        }

        private boolean isScramble(char[] s1, int begin1, int end1, char[] s2, int begin2, int end2) {
            if (begin1 == end1) return s1[begin1] == s2[begin2];
            if (cache[begin1][end1][begin2][end2] != 0) return cache[begin1][end1][begin2][end2] == 1;
            for (int i = 0; i < end1 - begin1; i++) {
                if ((isScramble(s1, begin1, begin1 + i, s2, begin2, begin2 + i) &&
                        isScramble(s1, begin1 + i + 1, end1, s2, begin2 + i + 1, end2))
                        ||
                        (isScramble(s1, begin1, begin1 + i, s2, end2 - i, end2) &&
                                isScramble(s1, begin1 + i + 1, end1, s2, begin2, end2 - i - 1))
                ) {
                    cache[begin1][end1][begin2][end2] = 1;
                    return true;
                }
            }
            cache[begin1][end1][begin2][end2] = -1;
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}