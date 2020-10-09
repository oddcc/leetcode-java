//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1355 👎 0


package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
        System.out.println(solution.generateParenthesis(1));
        System.out.println(solution.generateParenthesis(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 从头开始遍历每一种可能性，当发现当前不满足条件时，尝试另一种方案，失败或完成时返回，完成时把结果加入结果集中
        // 如何判断当前已经不满足条件了？计数
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            generate(ans, "", "(", n);
            return ans;
        }

        private void generate(List<String> result, String current, String insert, int limitCount) {
            // 基准条件1，能插入，插入后长度达到limitCount * 2，加入result，返回
            // 基准条件2，不能插入，直接返回
            if (!valid(current, insert, limitCount)) {
                return;
            }
            if (current.length() == limitCount * 2 - 1) {
                result.add(current + insert);
            }
            else {
                generate(result, current + insert, "(", limitCount);
                generate(result, current + insert, ")", limitCount);
            }
        }

        private boolean valid(String current, String insert, int limitCount) {
            if (current.length() >= limitCount * 2) return false;
            int score = 0;
            int leftCount = 0;
            int rightCount = 0;
            for (Character c : current.toCharArray()) {
                if (c == '(') {
                    score++;
                    leftCount++;
                }
                if (c == ')') {
                    score--;
                    rightCount++;
                }
                if (score < 0) return false;
                if (leftCount > limitCount || rightCount > limitCount) return false;
            }
            if (score == 0) {
                return leftCount < limitCount && insert.equals("(");
            }
            if (score < limitCount) {
                return (leftCount < limitCount && insert.equals("(")) || rightCount < limitCount && insert.equals(")");
            }
            if (score == limitCount) {
                return rightCount < limitCount && insert.equals(")");
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}