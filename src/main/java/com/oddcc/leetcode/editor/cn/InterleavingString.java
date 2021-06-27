// 97

package com.oddcc.leetcode.editor.cn;

public class InterleavingString {
    public static void main(String[] args) {
        Solution solution = new InterleavingString().new Solution();
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(solution.isInterleave("", "", ""));
        System.out.println(solution.isInterleave("ab", "bc", "bcab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 条件|n-m|<=1说的就是s1和s2必须交叉选择
    // 思路1，递归
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            return isInterleave(s1.toCharArray(), 0, s2.toCharArray(), 0, s3.toCharArray(), 0);
        }

        private boolean isInterleave(char[] s1, int i1, char[] s2, int i2, char[] s3, int i3) {
            int l1 = s1.length - i1;
            int l2 = s2.length - i2;
            int l3 = s3.length - i3;
            if (l3 != l1 + l2) return false;
            if (l2 == 0) return equal(s1, i1, s3, i3);
            if (l1 == 0) return equal(s2, i2, s3, i3);
            boolean ans = false;
            if (s1[i1] == s3[i3]) {
                ans = isInterleave(s1, i1 + 1, s2, i2, s3, i3 + 1);
            }
            if (s2[i2] == s3[i3]) {
                ans |= isInterleave(s1, i1, s2, i2 + 1, s3, i3 + 1);
            }
            return ans;
        }

        private boolean equal(char[] s1, int i1, char[] s3, int i3) {
            if (s1.length - i1 != s3.length - i3) return false;
            for (int i = i1; i < s1.length; i++) {
                if (s1[i] != s3[i3++]) return false;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}