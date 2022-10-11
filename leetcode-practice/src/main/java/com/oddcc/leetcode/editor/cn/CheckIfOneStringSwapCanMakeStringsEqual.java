// 1790

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CheckIfOneStringSwapCanMakeStringsEqual {
    public static void main(String[] args) {
        Solution solution = new CheckIfOneStringSwapCanMakeStringsEqual().new Solution();
        System.out.println(solution.areAlmostEqual("bank", "kanb"));
        System.out.println(solution.areAlmostEqual("attack", "defend"));
        System.out.println(solution.areAlmostEqual("kelb", "kelb"));
        System.out.println(solution.areAlmostEqual("aa", "ac"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            if (s1.equals(s2)) {
                return true;
            }
            if (s1.length() != s2.length()) {
                return false;
            }
            List<Integer> differentIndex = new ArrayList<>();
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    differentIndex.add(i);
                }
                if (differentIndex.size() > 2) {
                    return false;
                }
            }
            if (differentIndex.size() < 2) {
                return false;
            }

            return s1.charAt(differentIndex.get(0)) == s2.charAt(differentIndex.get(1)) &&
                    s1.charAt(differentIndex.get(1)) == s2.charAt(differentIndex.get(0));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}