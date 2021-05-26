// 1190

package com.oddcc.leetcode.editor.cn;

public class ReverseSubstringsBetweenEachPairOfParentheses {
    public static void main(String[] args) {
        Solution solution = new ReverseSubstringsBetweenEachPairOfParentheses().new Solution();
        System.out.println(solution.reverseParentheses("(abcd)"));
        System.out.println(solution.reverseParentheses("(u(love)i)"));
        System.out.println(solution.reverseParentheses("(ed(et(oc))el)"));
        System.out.println(solution.reverseParentheses("a(bcdefghijkl(mno)p)q"));
        System.out.println(solution.reverseParentheses("yfgnxf"));
        System.out.println(solution.reverseParentheses("((eqk((h))))"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1,递归
    class Solution {
        public String reverseParentheses(String s) {
            if (s.startsWith("(") && s.endsWith(")")) {
                return reverseWithBracket(s);
            }
            return reverseWithOutBracket(s);
        }

        private String reverseWithOutBracket(String s) {
            if (!s.contains("(")) return s;
            int left = s.indexOf("(");
            int right = s.lastIndexOf(")");
            String leftSub = s.substring(0, left);
            String rightSub = s.substring(right + 1);
            return leftSub + reverseParentheses(s.substring(left + 1, right)) + rightSub;
        }

        private String reverseWithBracket(String s) {
            s = s.substring(1, s.length() - 1);
            return reverse(reverseParentheses(s));
        }

        private String reverse(String s) {
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.reverse();
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}