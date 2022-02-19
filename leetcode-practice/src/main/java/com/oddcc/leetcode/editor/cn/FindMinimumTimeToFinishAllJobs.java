// 1723

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;

public class FindMinimumTimeToFinishAllJobs {
    public static void main(String[] args) {
        Solution solution = new FindMinimumTimeToFinishAllJobs().new Solution();
        // System.out.println(solution.minimumTimeRequired(new int[]{3, 2, 3}, 3));
        System.out.println(solution.minimumTimeRequired(new int[]{1, 2, 4, 7, 8}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1,暴力法,如果jobs.length为n,则每个工作有k种分配方式,时间复杂度为O(n^k),所有答案中取取小值
    // 思路2,动态规划
    class Solution {
        public int minimumTimeRequired(int[] jobs, int k) {
            int allmask = (1 << jobs.length) - 1;
            memo = new int[k][allmask + 1];
            return dp(0, 0, allmask, jobs, k);
        }

        void generateSubmasks(ArrayList<int[]> ret, int mask, int i, int n, int time, int[] arr) {
            if (i >= n)
                ret.add(new int[]{mask, time});
            else {
                generateSubmasks(ret, mask, i + 1, n, time, arr);
                if ((mask & (1 << i)) == 0)
                    generateSubmasks(ret, mask | 1 << i, i + 1, n, time + arr[i], arr);
            }
        }

        int[][] memo;

        int dp(int i, int mask, int allmask, int[] arr, int k) {
            if (mask == allmask)
                return 0;
            else if (i >= k)
                return Integer.MAX_VALUE;
            else if (memo[i][mask] != 0)
                return memo[i][mask];
            else {
                int q = Integer.MAX_VALUE;
                ArrayList<int[]> temp = new ArrayList<int[]>();
                generateSubmasks(temp, mask, 0, arr.length, 0, arr);
                for (int[] x : temp)
                    q = Math.min(q, Math.max(x[1], dp(i + 1, x[0], allmask, arr, k)));
                return memo[i][mask] = q;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}