// 680

package com.oddcc.leetcode.editor.cn;

public class ValidPalindromeII {
    public static void main(String[] args) {
        Solution solution = new ValidPalindromeII().new Solution();
        System.out.println(solution.validPalindrome("aba"));
        System.out.println(solution.validPalindrome("abca"));
        System.out.println(solution.validPalindrome("abc"));
        System.out.println(solution.validPalindrome("eeccccbebaeeabebccceea"));
        System.out.println(solution.validPalindrome("eddboebddcaacddkbebdde"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            int l = 0;
            int r = s.length() - 1;
            boolean deleted = false;
            boolean lFailure = false;
            // left first
            while (l <= s.length() - 1 && r >= 0 && l <= r) {
                if (s.charAt(l) == s.charAt(r)) {
                    l++;
                    r--;
                } else {
                    if (deleted) {
                        lFailure = true;
                        break;
                    }
                    if (l + 1 <= s.length() - 1 && l + 1 <= r) {
                        if (s.charAt(l + 1) == s.charAt(r)) {
                            l += 2;
                            r--;
                        } else {
                            lFailure = true;
                            break;
                        }
                    }
                    deleted = true;
                }
            }
            if (!lFailure) {
                return true;
            }

            deleted = false;
            l = 0;
            r = s.length() - 1;
            // right
            while (l <= s.length() - 1 && r >= 0 && l <= r) {
                if (s.charAt(l) == s.charAt(r)) {
                    l++;
                    r--;
                } else {
                    if (deleted) {
                        return false;
                    }
                    if (r - 1 >= 0 && l <= r - 1) {
                        if (s.charAt(l) == s.charAt(r - 1)) {
                            l++;
                            r-=2;
                        } else {
                            return false;
                        }
                    }
                    deleted = true;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}