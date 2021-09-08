// 502

package com.oddcc.leetcode.editor.cn;

public class Ipo {
    public static void main(String[] args) {
        Solution solution = new Ipo().new Solution();
        System.out.println(solution.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
        System.out.println(solution.findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，DFS回溯暴搜，超时
    class Solution {
        private int ans = 0;

        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            dfs(k, w, profits, capital, 0, 0);
            return ans;
        }

        private void dfs(int k, int w, int[] profits, int[] capital, int i, int currentK) {
            ans = Math.max(w, ans);
            if (i >= profits.length) return;
            if (currentK >= k) return;
            int profit = profits[i];
            int cap = capital[i];
            // 选第i个项目
            if (cap <= w) {
                w += profit;
                currentK++;
                dfs(k, w, profits, capital, i + 1, currentK);
                w -= profit;
                currentK--;
            }
            // 不选第i个项目
            dfs(k, w, profits, capital, i + 1, currentK);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}