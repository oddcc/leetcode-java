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
            generate(ans, "", '(', n);
            return ans;
        }

        private void generate(List<String> result, String current, Character insert, int limitCount) {
            // 基准条件1，能插入，插入后长度达到limitCount * 2，加入result，返回
            // 基准条件2，不能插入，直接返回
            if (!valid(current.toCharArray(), insert, limitCount)) {
                return;
            }
            if (current.length() == limitCount * 2 - 1) {
                result.add(current + insert);
            }
            else {
                generate(result, current + insert, '(', limitCount);
                generate(result, current + insert, ')', limitCount);
            }
        }

        /**
         * @param current    当前的字符串
         * @param insert     要插入的字符串
         * @param limitCount 限制的括号数量
         * @return 是否可以插入这个字符
         */
        private boolean valid(char[] current, Character insert, int limitCount) {
            // 如果当前已经满足长度了，则不能插入
            if (current.length >= limitCount * 2) return false;
            int rightRemain = 0; // 还可以插入右括号的数量（未完成的括号数量）
            int leftCount = 0;
            int rightCount = 0;
            for (Character c : current) {
                if (c == '(') {
                    rightRemain++;
                    leftCount++;
                }
                if (c == ')') {
                    rightRemain--;
                    rightCount++;
                }
                // 说明在current中，左括号已经多余右括号了，本身就非法，当然不能插入
                if (rightRemain < 0) return false;
                // 虽然左括号没有多余右括号，但单个括号已经多过限制了，也是非法的，如((((((这样的
                if (leftCount > limitCount || rightCount > limitCount) return false;
            }
            // 上面的循环结束后，知道了current中，有几个左括号，有几个右括号，还能插入几个右括号
            // 如果没有未完成的括号了，则下一个插入的只能是左括号
            if (rightRemain == 0) {
                return leftCount < limitCount && insert == '(';
            }
            // rightRemain 大于0，小于上限的情况下，插入左\右括号都可以，但要在限制内
            if (rightRemain < limitCount) {
                return (leftCount < limitCount && insert == '(') || (rightCount < limitCount && insert == ')');
            }
            // 这种情况说明当前都是左括号，只能在限制内插入右括号
            if (rightRemain == limitCount) {
                return rightCount < limitCount && insert == ')';
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}