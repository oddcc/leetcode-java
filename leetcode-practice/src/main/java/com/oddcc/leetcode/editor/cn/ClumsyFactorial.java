// 1006

package com.oddcc.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class ClumsyFactorial {
    public static void main(String[] args) {
        Solution solution = new ClumsyFactorial().new Solution();
        System.out.println(solution.clumsy(0));
        System.out.println(solution.clumsy(4));
        System.out.println(solution.clumsy(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，初步观察，clumsy(i)和clumsy(i-1)没有关系，考虑直接计算，要注意计算顺序和溢出的问题，利用栈来计算
        public int clumsy(int N) {
            Deque<Object> stack = new LinkedList<>();
            int opCount = 0;
            for (int i = 2 * N; i >= 2; i--) {
                if (i % 2 == 0) {
                    if (!stack.isEmpty() && stack.peek() instanceof String && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                        String op = (String) stack.pop();
                        int a = (Integer) stack.pop();
                        int b = i / 2;
                        if (op.equals("*")) {
                            stack.push(a * b);
                        }
                        else {
                            stack.push(a / b);
                        }
                    }
                    else {
                        stack.push(i / 2);
                    }
                }
                else {
                    if (opCount == 3) {
                        stack.push("-");
                        opCount = 0;
                    }
                    else {
                        if (opCount == 0) stack.push("*");
                        else if (opCount == 1) stack.push("/");
                        else if (opCount == 2) stack.push("+");
                        opCount++;
                    }
                }
            }
            int ans = 0;
            while (!stack.isEmpty()) {
                if (stack.size() == 1) ans = (Integer) stack.pollFirst();
                else {
                    int a = (Integer) stack.pollLast();
                    String op = (String) stack.pollLast();
                    int b = (Integer) stack.pollLast();
                    if (op.equals("+")) {
                        stack.addLast(a + b);
                    }
                    else {
                        stack.addLast(a - b);
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}