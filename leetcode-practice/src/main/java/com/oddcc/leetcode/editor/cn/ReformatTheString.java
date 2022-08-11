// 1417

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ReformatTheString {
    public static void main(String[] args) {
        Solution solution = new ReformatTheString().new Solution();
        System.out.println(solution.reformat("a0b1c2"));
        System.out.println(solution.reformat("leetcode"));
        System.out.println(solution.reformat("1229857369"));
        System.out.println(solution.reformat("covid2019"));
        System.out.println(solution.reformat("ab123"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reformat(String s) {
            StringBuilder sb = new StringBuilder();
            int len = s.length();
            List<Character> letters = new ArrayList<>();
            List<Character> digits = new ArrayList<>();
            for (Character c : s.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    letters.add(c);
                } else {
                    digits.add(c);
                }
            }

            if (Math.abs(letters.size() - digits.size()) >= 2) {
                return "";
            }

            boolean letterTurn = letters.size() >= digits.size();
            int iL = 0;
            int iD = 0;
            for (int i = 0; i < len; i++) {
                if (letterTurn) {
                    sb.append(letters.get(iL++));
                } else {
                    sb.append(digits.get(iD++));
                }
                letterTurn = !letterTurn;
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}