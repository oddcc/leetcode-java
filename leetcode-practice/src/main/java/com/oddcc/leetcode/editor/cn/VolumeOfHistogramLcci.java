// 面试题 17.21

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class VolumeOfHistogramLcci {
    public static void main(String[] args) {
        Solution solution = new VolumeOfHistogramLcci().new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，通过单调栈，可以得到对于位置i来说，左边和右边大于height[i]的元素在什么位置，这样就能确定有多宽的位置可以存水
        // 如果左边是l，右边是r，那么可以存水的位置就是(r - 1) - (l + 1) + 1
        // 通过计算min(height[l], height[r]) - height[i]，可以知道可存水的高度是多少
        // 按上面的方式遍历每个位置i，就可以得到总共存的水
        // 为了避免遍历过程中的重复计算，需要记录对于height[i]来说，已经计算过的位置，如果后续计算过的，则跳过
        public int trap(int[] height) {
            int len = height.length;
            int[] rightHigher = new int[len];
            Arrays.fill(rightHigher, -1); // -1表示不存在
            Deque<Integer> rightHigherStack = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                while (!rightHigherStack.isEmpty() && height[rightHigherStack.peek()] < height[i]) {
                    rightHigher[rightHigherStack.pop()] = i;
                }
                rightHigherStack.push(i);
            }
            int[] leftHigher = new int[len];
            Arrays.fill(leftHigher, -1);
            Deque<Integer> leftHigherStack = new LinkedList<>();
            for (int i = len - 1; i >= 0; i--) {
                while (!leftHigherStack.isEmpty() && height[leftHigherStack.peek()] < height[i]) {
                    leftHigher[leftHigherStack.pop()] = i;
                }
                leftHigherStack.push(i);
            }
            Map<Integer, Set<int[]>> cache = new HashMap<>(); // key-计算的高度，value-计算过的区间
            int ans = 0;
            for (int i = 0; i < len; i++) {
                if (leftHigher[i] == -1 || rightHigher[i] == -1) continue; // 如果左边或右边没封闭，就跳过
                if (calculated(height[i], i, cache)) continue; // 如果当前位置已计算过，就跳过
                int w = (rightHigher[i] - 1) - (leftHigher[i] + 1) + 1;
                int h = Math.min(height[leftHigher[i]], height[rightHigher[i]]) - height[i];
                ans += w * h;
                Set<int[]> s = cache.getOrDefault(height[i], new HashSet<>());
                s.add(new int[]{leftHigher[i] + 1, rightHigher[i] - 1});
                cache.put(height[i], s);
            }
            return ans;
        }

        // 看看i是否已经计算过了
        private boolean calculated(int value, int i, Map<Integer, Set<int[]>> cache) {
            Set<int[]> s = cache.getOrDefault(value, new HashSet<>());
            for (int[] range : s) {
                if (i >= range[0] && i <= range[1]) return true;
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}