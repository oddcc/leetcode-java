// 640

package com.oddcc.leetcode.editor.cn;

public class SolveTheEquation {
    public static void main(String[] args) {
        Solution solution = new SolveTheEquation().new Solution();
        System.out.println(solution.solveEquation("x+5-3+x=6+x-2"));
        System.out.println(solution.solveEquation("x=x"));
        System.out.println(solution.solveEquation("2x=x"));
        System.out.println(solution.solveEquation("0x=0"));
        System.out.println(solution.solveEquation("x=x+1"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String solveEquation(String equation) {
            String[] statements = equation.split("=");
            int lXCount = getXCount(statements[0]);
            int lSum = getSum(statements[0]);
            int rXCount = getXCount(statements[1]);
            int rSum = getSum(statements[1]);
            int xCount = lXCount - rXCount;
            int sum = rSum - lSum;
            if (xCount == 0 && sum != 0) {
                return "No solution";
            }
            if (xCount == 0) {
                return "Infinite solutions";
            }
            if (xCount == 1) {
                return "x=" + sum;
            }
            if (sum % xCount != 0) {
                return "Infinite solutions";
            }
            return "x=" + (sum / xCount);
        }

        private int getSum(String statement) {
            int sum = 0;
            int factor = 1;
            StringBuilder sb = new StringBuilder();
            for (Character c : statement.toCharArray()) {
                if (c == '+' || c == '-') {
                    if (sb.length() != 0) {
                        sum += (Integer.parseInt(sb.toString())) * factor;
                    }
                    sb = new StringBuilder();
                    if (c == '+') {
                        factor = 1;
                    } else {
                        factor = -1;
                    }
                    continue;
                }
                if (c == 'x') {
                    sb = new StringBuilder();
                    continue;
                }
                sb.append(c);
            }
            if (sb.length() != 0) {
                sum += (Integer.parseInt(sb.toString())) * factor;
            }
            return sum;
        }

        private int getXCount(String statement) {
            int count = 0;
            int factor = 1;
            StringBuilder sb = new StringBuilder();
            for (Character c : statement.toCharArray()) {
                if (c == '+' || c == '-') {
                    sb = new StringBuilder();
                    if (c == '+') {
                        factor = 1;
                    } else {
                        factor = -1;
                    }
                    continue;
                }
                if (c != 'x') {
                    sb.append(c);
                    continue;
                }
                count += (sb.length() == 0 ? 1 : Integer.parseInt(sb.toString())) * factor;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}