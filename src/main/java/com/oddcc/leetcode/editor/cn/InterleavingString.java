// 97

package com.oddcc.leetcode.editor.cn;

public class InterleavingString {
    public static void main(String[] args) {
        Solution solution = new InterleavingString().new Solution();
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(solution.isInterleave("", "", ""));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 条件|n-m|<=1说的就是s1和s2必须交叉选择
    // 思路1，递归
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) return false;
            if (s1.length() == 0) return s2.equals(s3);
            if (s2.length() == 0) return s1.equals(s3);
            boolean ans = false;
            // 选了s1的情况
            if (s1.charAt(0) == s3.charAt(0)) {
                ans = isInterleave(s1.substring(1), s2, s3.substring(1));
            }
            // 选了s2的情况
            // 两种情况只要有一种满足条件就可以
            if (s2.charAt(0) == s3.charAt(0)) {
                ans |= isInterleave(s1, s2.substring(1), s3.substring(1));
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}