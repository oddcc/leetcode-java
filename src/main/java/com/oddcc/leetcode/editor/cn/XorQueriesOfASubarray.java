// 1310

package com.oddcc.leetcode.editor.cn;

import com.oddcc.leetcode.editor.cn.common.ArrayListUtils;

import java.util.Arrays;

public class XorQueriesOfASubarray {
    public static void main(String[] args) {
        Solution solution = new XorQueriesOfASubarray().new Solution();
        System.out.println(Arrays.toString(solution.xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}})));
        System.out.println(Arrays.toString(solution.xorQueries(new int[]{4, 8, 2, 10}, new int[][]{{2, 3}, {1, 3}, {0, 0}, {0, 3}})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1,类似前缀和数组
    class Solution {
        public int[] xorQueries(int[] arr, int[][] queries) {
            int len = arr.length;
            int[] pre = new int[len];
            for (int i = 0; i < len; i++) {
                if (i == 0) pre[i] = arr[i];
                else pre[i] = arr[i] ^ pre[i - 1];
            }
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int l = queries[i][0];
                int r = queries[i][1];
                if (l == 0) {
                    ans[i] = pre[r];
                }
                else {
                    ans[i] = pre[l - 1] ^ pre[r];
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}