// 1046

package com.oddcc.leetcode.editor.cn;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        Solution solution = new LastStoneWeight().new Solution();
        System.out.println(solution.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，直接模拟，按题意，需要一个最大堆，然后每次取两个石头进行碰撞，剩余的入堆，直到堆中只剩一个元素
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> maxStack = new PriorityQueue<>((x, y) -> y - x);
            for (int i : stones) maxStack.add(i);
            while (maxStack.size() >= 2) {
                int x = maxStack.poll();
                int y = maxStack.poll();
                if (x == y) continue;
                maxStack.add(Math.abs(x - y));
            }
            return maxStack.size() == 0 ? 0 : maxStack.poll();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}