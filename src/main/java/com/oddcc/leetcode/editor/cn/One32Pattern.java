// 456

package com.oddcc.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class One32Pattern {
    public static void main(String[] args) {
        Solution solution = new One32Pattern().new Solution();
        System.out.println(solution.find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(solution.find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(solution.find132pattern(new int[]{-1, 3, 2, 0}));
        System.out.println(solution.find132pattern(new int[]{3, 5, 0, 3, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，贪心+单调栈
        public boolean find132pattern(int[] nums) {
            int len = nums.length;
            int[] minimum = new int[len]; // minimum[i]表示[0...i)的最小值
            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    minimum[i] = Integer.MAX_VALUE;
                    continue;
                }
                minimum[i] = Math.min(minimum[i - 1], nums[i - 1]);
            }
            Deque<Integer> stack = new LinkedList<>();
            // 这里是贪心，在我们遍历时，需要i的左边值尽量小，i的右边值在小于nums[i]的情况下尽量大
            // i的左边尽量小没有问题，左边的最小值可以通过minimum[i]来得到
            // 右边的值尽量大，利用一个单调栈来实现
            // 当nums[i]大于栈顶元素时，所有小于nums[i]的栈顶元素出栈，最后一个出栈的就是小于nums[i]的最大值m，并把nums[i]入栈
            // 这时候判断是否有minimum[i] < m，如果有的话，就返回true了
            // 如果上面判断不满足，则继续，主要探讨跟上一次的变化，这一次判断的元素是nums[i-1]
            // nums[i-1] > nums[i]的情况下，小于nums[i-1]的最大值就是nums[i]，也就是当前的栈顶元素
            // nums[i-1] == nums[i]的情况下，跟刚才的情况一样，虽然这时拿不到右边的值（nums[i-1]已经是最大的了），但刚才已判断过不是答案，所以这里跳过没关系
            // nums[i-1] < nums[i]的情况下
            // 如果nums[i-1]就是最小值，那么minimum[i-1]是MAX，不是答案
            // 如果nums[i-1]不是最小值，那么应该有minimum[i-1] == minimum[i]；
            // 这时对nums[i-1]来说，是拿不到小于nums[i-1]的最大值的
            // 但从逻辑上来说应该有小于nums[i-1]的最大值 <= 小于nums[i]的最大值，答案要求是minimum[i] < nextLarger，如果大一些的nextLarger都已经不符合条件了，那么更小的nextLarger就更加不符合条件
            // 所以不会错过答案，这是重要的贪心的逻辑
            for (int i = len - 1; i >= 0; i--) {
                if (stack.isEmpty()) {
                    stack.push(nums[i]);
                    continue;
                }
                int nextLarger = Integer.MIN_VALUE;
                while (!stack.isEmpty() && stack.peek() < nums[i]) {
                    nextLarger = Math.max(stack.pop(), nextLarger);
                }
                if (minimum[i] < nextLarger) return true;
                stack.push(nums[i]);
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}