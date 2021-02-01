// 739

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，遍历
        // 思路2，利用栈来存储还没有确定答案的值，如果碰到下一个更大的数，栈顶元素就出栈
        public int[] dailyTemperatures(int[] T) {
            Deque<int[]> stack = new LinkedList<>();
            int len = T.length;
            int[] ans = new int[len];
            for (int i = 0; i < len; i++) {
                if (!stack.isEmpty()) {
                    int[] n = stack.peek();
                    while (n != null && T[i] > n[0] && i > n[1]) { // 注意这里是个循环，当碰到一个更大的数时，所有比它小的值都要出栈
                        ans[n[1]] = i - n[1];
                        stack.pop();
                        n = stack.peek();
                    }
                }
                stack.push(new int[]{T[i], i});
            }
            while (!stack.isEmpty()) {
                ans[stack.pop()[1]] = 0;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}