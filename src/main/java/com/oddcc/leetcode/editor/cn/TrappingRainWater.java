// 42

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(solution.trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，对每一个较低的值height[i]，我们要找到左右两边大于height[i]的位置，那么能接的水，就是对应矩形的面积
        // 类似84题，不同的是，此题中要避免重复计算
        public int trap(int[] height) {
            int len = height.length;
            int[] towardsRight = new int[len];
            Arrays.fill(towardsRight, -1);
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                if (!stack.isEmpty()) {
                    Integer n = stack.peek();
                    while (n != null && height[n] < height[i] && n < i) {
                        towardsRight[n] = i;
                        stack.pop();
                        n = stack.peek();
                    }
                }
                stack.push(i);
            }
            int[] towardsLeft = new int[len];
            Arrays.fill(towardsLeft, -1);
            for (int i = len - 1; i >= 0; i--) {
                if (!stack.isEmpty()) {
                    Integer n = stack.peek();
                    while (n != null && height[n] < height[i] && n > i) {
                        towardsLeft[n] = i;
                        stack.pop();
                        n = stack.peek();
                    }
                }
                stack.push(i);
            }

            boolean[] used = new boolean[len];
            int ans = 0;
            // 从左侧遍历height，如果对于i，towardsLeft[i]和towardsRight[i]都有值（不是-1），就可以计算面积并加到最终答案中
            // 同时把对应的所有used[i]标为true，以避免重复计算
            // 如果遇到used[i] == true的情况，直接跳过
            for (int i = 0; i < len; i++) {
                if (used[i]) continue;
                int left = towardsLeft[i];
                int right = towardsRight[i];
                if (left != -1 && right != -1) {
                    int h = Math.min(height[left], height[right]) - height[i];
                    int w = (right - 1) - (left + 1) + 1;
                    ans += h * w;
                    for (int n = left + 1; n <= right - 1; n++) {
                        if (height[n] >= height[i]) used[n] = true; // 比height[i]更低的不应该被标记，因为之后还会进行计算
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}