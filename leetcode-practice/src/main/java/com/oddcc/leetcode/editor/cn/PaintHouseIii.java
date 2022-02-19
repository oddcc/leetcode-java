// 1473

package com.oddcc.leetcode.editor.cn;

public class PaintHouseIii {
    public static void main(String[] args) {
        Solution solution = new PaintHouseIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，只要最终结果，考虑动态规划
    class Solution {
        // INF最大值，/2 是为了防止越界
        int INF = Integer.MAX_VALUE / 2;
        public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
            //三个维度分别对应房子编号，颜色编号，分区编号
            int[][][] dp = new int[m + 1][n + 1][target + 1];

            // 将每一个位置初始化
            for(int i = 0; i < m; i++) {
                for(int j = 1; j <= n; j++) {
                    for(int k = 0; k <= target; k++) {
                        dp[i][j][k] = (i == 0 && k == 0) ? 0 : INF;
                    }
                }
            }

            // 遍历每个房子
            for(int i = 1; i <= m; i++){
                // 获取房子对应颜色，其中-1表示未上色
                int color = houses[i - 1];

                // 遍历每种可能的颜色
                for(int j = 1; j <= n; j++){
                    // 遍历每种分区，分区必然从1开始
                    for (int k = 1; k <= i && k <= target; k++){

                        // 第 i 间房子已经上色
                        if (color != 0) {
                            //「本来的颜色」已经固定，不能再刷，不允许状态转移，置为INF
                            if (j != color) {
                                dp[i][j][k] = INF;
                            }
                            // 与「本来的颜色」相同，允许被转移
                            else {
                                // 1. 当前颜色为新分区，前后房子颜色不同
                                // 即，从「上一分区」「不同颜色」房子中找「花费最少」的情况
                                int tmp1 = INF;
                                for (int p = 1; p <= n; p++) {
                                    if (p != j) {
                                        tmp1 = Math.min(tmp1, dp[i - 1][p][k - 1]);
                                    }
                                }

                                // 2. 不形成新分区，前后房子颜色相同
                                // 即，「上一分区」「相同颜色」的房子
                                int tmp2 = dp[i - 1][j][k];


                                // 两者情况中找花费最少的进行状态转移
                                dp[i][j][k] = Math.min(tmp1, tmp2);
                            }

                            // 第 i 间房子尚未上色
                        }
                        else {
                            // 1. 给当前颜色设立新分区，前后房子颜色不同
                            // 即，从「上一分区」中，「不同颜色」房子中找「花费最少」的情况
                            int tmp1 = INF;
                            for (int p = 1; p <= n; p++) {
                                if (p != j) {
                                    tmp1 = Math.min(tmp1, dp[i - 1][p][k - 1]);
                                }
                            }
                            // 2. 不形成新分区，前后房子颜色相同
                            // 即，「上一分区」「相同颜色」的房子
                            int tmp2 = dp[i - 1][j][k];

                            // 两者情况中找花费最少的进行状态转移，同时要加上刷新漆要用的金额
                            dp[i][j][k] = Math.min(tmp1, tmp2) + cost[i - 1][j - 1];
                        }
                    }
                }
            }


            // 从「考虑所有房间，并且形成分区数量为 target」的所有方案中找答案
            int ans = INF;
            for (int i = 1; i <= n; i++) {
                ans = Math.min(ans, dp[m][i][target]);
            }

            return ans == INF ? -1 : ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}