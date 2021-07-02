// 1833

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class MaximumIceCreamBars {
    public static void main(String[] args) {
        Solution solution = new MaximumIceCreamBars().new Solution();
        System.out.println(solution.maxIceCream(new int[]{1, 3, 2, 4, 1}, 7));
        System.out.println(solution.maxIceCream(new int[]{10, 6, 8, 7, 7, 8}, 5));
        System.out.println(solution.maxIceCream(new int[]{1, 6, 3, 1, 2, 5}, 20));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 背包问题
    // 思路1，动态规划
    // 思路2，优化空间占用，递推时，只用到二维数组的上一行的结果
    // 思路3，贪心，反证法，从最便宜的开始买，买了i个雪糕，用了j个硬币。如果替换任意雪糕，花的钱都会更多，所以在只花j个硬币的情况下，i个雪糕就是最优解
    class Solution {
        public int maxIceCream(int[] costs, int coins) {
            Arrays.sort(costs);
            int ans = 0;
            for (int i = 0; i < costs.length; i++) {
                int t = coins - costs[i];
                if (t >= 0) {
                    ans++;
                    coins = t;
                }
                else {
                    break;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}