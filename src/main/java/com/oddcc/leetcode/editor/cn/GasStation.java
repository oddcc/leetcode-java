// 134

package com.oddcc.leetcode.editor.cn;

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
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int ans = -1;
            for (int i = 0; i < gas.length; i++) {
                int remain = 0;
                int start = i;
                boolean found = false;
                while (true) {
                    // 表示从start点不能走到start+1
                    if (gas[start] + remain < cost[start]) {
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