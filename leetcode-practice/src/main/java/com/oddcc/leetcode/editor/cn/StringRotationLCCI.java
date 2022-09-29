// 面试题 01.09

package com.oddcc.leetcode.editor.cn;
public class StringRotationLCCI {
    public static void main(String[] args) {
        Solution solution = new StringRotationLCCI().new Solution();
        System.out.println(solution.isFlipedString("waterbottle", "erbottlewat"));
        System.out.println(solution.isFlipedString("aa", "aba"));
        System.out.println(solution.isFlipedString("aaaaa", "aaaaa"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int i1 = 0;
        int i2 = 0;
        while (i1 < s1.length() && i2 < s2.length()) {
            if (s2.charAt(i2++) == s1.charAt(i1)) {
                i1++;
                if (i2 == s2.length()) {
                    break;
                }
                continue;
            }
            i1 = 0;
        }
        // System.out.println(i1);
        return s1.substring(i1).equals(s2.substring(0, s2.length() - i1));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}