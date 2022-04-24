// 面试题 01.05

package com.oddcc.leetcode.editor.cn;

public class OneAwayLCCI {
    public static void main(String[] args) {
        Solution solution = new OneAwayLCCI().new Solution();
        System.out.println(solution.oneEditAway("pale", "ple"));
        System.out.println(solution.oneEditAway("pales", "ple"));
        System.out.println(solution.oneEditAway("ab", "bc"));
        System.out.println(solution.oneEditAway("a", "b"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean oneEditAway(String first, String second) {
            int l1 = first.length();
            int l2 = second.length();
            if (Math.abs(l1 - l2) >= 2) return false;
            boolean flag = l1 >= l2;
            int i1 = 0;
            int i2 = 0;
            boolean removeOne = false;
            boolean replaceOne = false;
            while (i1 < l1 && i2 < l2) {
                if (first.charAt(i1) == second.charAt(i2)) {
                    i1++;
                    i2++;
                    continue;
                }
                if (l1 == l2) {
                    if (replaceOne) {
                        return false;
                    }
                    replaceOne = true;
                    i1++;
                    i2++;
                    continue;
                }
                if (flag) {
                    i1++;
                } else {
                    i2++;
                }
                if (removeOne) {
                    return false;
                }
                removeOne = true;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}