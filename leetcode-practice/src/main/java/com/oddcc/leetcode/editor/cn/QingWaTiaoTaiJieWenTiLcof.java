// 剑指 Offer 10- II

package com.oddcc.leetcode.editor.cn;

public class QingWaTiaoTaiJieWenTiLcof {
    public static void main(String[] args) {
        Solution solution = new QingWaTiaoTaiJieWenTiLcof().new Solution();
        System.out.println(solution.numWays(2));
        System.out.println(solution.numWays(7));
        System.out.println(solution.numWays(0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，动态规划
        // 思路2，优化动态规划，只存必要的值
        public int numWays(int n) {
            if (n == 0 || n == 1) return 1;
            int from2ahead = 1;
            int from1ahead = 1;
            int ans = 0;
            for (int i = 2; i < n + 1; i++) {
                ans = (from2ahead + from1ahead) % 1000000007;
                from2ahead = from1ahead;
                from1ahead = ans;
            }
            return ans % 1000000007;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}