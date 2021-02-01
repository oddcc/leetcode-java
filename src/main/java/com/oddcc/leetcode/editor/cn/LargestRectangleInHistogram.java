// 84

package com.oddcc.leetcode.editor.cn;

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
        public int largestRectangleArea(int[] heights) {
            int ans = 0;
            for (int i = 0; i < heights.length; i++) {
                ans = Math.max(ans, calArea(heights, i));
            }
            return ans;
        }

        // 以索引i为中心，求对应矩形面积
        private int calArea(int[] heights, int i) {
            int h = heights[i];
            int left = i - 1;
            while (left >= 0 && heights[left] >= heights[i]) left--;
            int right = i + 1;
            while (right < heights.length && heights[right] >= heights[i]) right++;
            // 如果left停留在0的左边，说明0的位置都大于等于heights[i]
            if (left < 0) {
                left = 0;
            }
            // left停留的位置是最后一个符合条件的值的左边，需要右移一位
            else {
                left++;
            }
            // 如果right停留在len - 1的右边，说明len-1的位置都大于等于heights[i]
            if (right >= heights.length) {
                right = heights.length - 1;
            }
            // right停留的位置是最后一个符合条件的值的右边，需要左移一位
            else {
                right--;
            }
            return h * (right - left + 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}