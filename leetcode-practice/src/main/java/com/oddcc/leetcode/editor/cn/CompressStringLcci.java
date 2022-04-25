// 面试题 01.06

package com.oddcc.leetcode.editor.cn;

public class CompressStringLcci {
    public static void main(String[] args) {
        Solution solution = new CompressStringLcci().new Solution();
        System.out.println(solution.compressString("aabcccccaaa"));
        System.out.println(solution.compressString("abbccd"));
        System.out.println(solution.compressString("aaabbbc"));
        System.out.println(solution.compressString("a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String compressString(String S) {
            StringBuilder sb = new StringBuilder();
            Character cur = null;
            int cnt = 0;
            for (int i = 0; i < S.length(); i++) {
                if (i == 0) {
                    cur = S.charAt(i);
                    cnt++;
                } else {
                    if (!cur.equals(S.charAt(i))) {
                        sb.append(cur).append(cnt);
                        cur = S.charAt(i);
                        cnt = 1;
                    } else {
                        cnt++;
                    }
                }
                if (i == S.length() - 1) {
                    sb.append(cur).append(cnt);
                }
            }
            if (S.length() > sb.length()) {
                return sb.toString();
            }
            return S;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}