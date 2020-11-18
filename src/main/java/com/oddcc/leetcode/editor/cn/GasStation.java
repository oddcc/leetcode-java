// 134

package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class GasStation {
    public static void main(String[] args) {
        Solution solution = new GasStation().new Solution();
        System.out.println(solution.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(solution.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
        System.out.println(solution.canCompleteCircuit(new int[]{3, 3, 4}, new int[]{3, 4, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，遍历所有可能的起点，直接模拟+剪枝
        // 思路2，思路1包含很多重复计算，比如，从i点出发，走到了j点，油箱余量为r，这个过程是不变的
        // 不用重复计算，假设到底i点时候有油r1，那么我们可以直接得出，可以走到j点且余量为r + r1
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int ans = -1;
            int[][] cache = new int[gas.length][2]; // {终点,余量}
            for (int i = 0; i < gas.length; i++) {
                cache[i] = new int[]{-1, 0};
            }
            for (int i = 0; i < gas.length; i++) {
                int remain = 0;
                int start = i;
                boolean found = false;
                while (true) {
                    int[] c = cache[start];
                    if (c[0] != -1) {
                        start = c[0];
                        remain += c[1];
                    }
                    // 表示从start点不能走到start+1
                    if (gas[start] + remain < cost[start]) {
                        cache[i] = new int[]{start, remain};
                        break;
                    }
                    // 如果能走到下一个点，更新油箱余量，移动start
                    remain = gas[start] + remain - cost[start];
                    start = getNext(start, gas);
                    // 如果已经回到了起点，则结束流程
                    if (start == i) {
                        found = true;
                        ans = start;
                        break;
                    }
                }
                if (found) break;
            }
            return ans;
        }

        private int getNext(int i, int[] gas) {
            return (i + 1) % gas.length;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}