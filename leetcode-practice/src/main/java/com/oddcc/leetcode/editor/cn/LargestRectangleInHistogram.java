// 84

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        System.out.println(solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(solution.largestRectangleArea(new int[]{2, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，矩形面积=长*宽，我们可以遍历每个值，找到以当前值为高的矩形的面积，留下最大的面积即可，超时
        // 如何求每个矩形面积呢？
        // 比如[2,1,5,6,2,3]中，当index=4，value=2时，高是2，而宽应该是4（2~5）
        // 其中2是左边最后一个大于等于2的值的索引，而5是右边最后一个大于等于2的值的索引，注意这个搜索必须连续，如果中断了就不算
        // 思路2，在确定宽度时，包含了大量的重复计算，如何优化？
        // 连续的找下一个大于等于x的索引，等同于找下一个小于x的索引
        // 如果对heights[i]能快速找到左边第一个小于heights[i]的值的索引left，找到右边第一个小于heights[i]的值的索引right，则问题就好解了
        public int largestRectangleArea(int[] heights) {
            int len = heights.length;
            // towardsRightFirstLower记录heights[i]向右找，第几个元素是小于heights[i]的元素
            int[] towardsRightFirstLower = new int[len];
            Arrays.fill(towardsRightFirstLower, -1);
            Deque<int[]> stack = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                if (!stack.isEmpty()) {
                    int[] n = stack.peek();
                    // 此处n表示还没有找到小于n[0]的元素，heights[i]是新碰到的值
                    // 当heights[i] < n[0]时，n就找到了对应的元素，要出栈
                    while (n != null && heights[i] < n[0] && i > n[1]) {
                        towardsRightFirstLower[n[1]] = i;
                        stack.pop();
                        n = stack.peek();
                    }
                }
                stack.push(new int[]{heights[i], i});
            }
            while (!stack.isEmpty()) towardsRightFirstLower[stack.pop()[1]] = 0;
            // towardsLeftFirstLower记录heights[i]向左找，第几个元素是小于heights[i]的元素
            int[] towardsLeftFirstLower = new int[len];
            Arrays.fill(towardsLeftFirstLower, -1);
            for (int i = len - 1; i >= 0; i--) {
                if (!stack.isEmpty()) {
                    int[] n = stack.peek();
                    while (n != null && heights[i] < n[0] && i < n[1]) {
                        towardsLeftFirstLower[n[1]] = i;
                        stack.pop();
                        n = stack.peek();
                    }
                }
                stack.push(new int[]{heights[i], i});
            }
            while (!stack.isEmpty()) towardsLeftFirstLower[stack.pop()[1]] = 0;
            int ans = 0;
            for (int i = 0; i < len; i++) {
                int h = heights[i];
                int left = towardsLeftFirstLower[i] == -1 ? 0 : towardsLeftFirstLower[i] + 1;
                int right = towardsRightFirstLower[i] == -1 ? len - 1 : towardsRightFirstLower[i] - 1;
                int w = right - left + 1;
                ans = Math.max(ans, h * w);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}