// 455

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        Solution solution = new AssignCookies().new Solution();
        System.out.println(solution.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(solution.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
        System.out.println(solution.findContentChildren(new int[]{1, 2,3}, new int[]{3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，g和s都是升序的情况下，每次都用可用的最小的s来满足g，直到找不到s为止
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int ans = 0;
            int iG = 0;
            int iS = 0;
            // g或s找完的话，流程就结束
            while (iG < g.length && iS < s.length) {
                int vG = g[iG++]; // 取下一个未被满足的孩子
                // 如果不满足条件，则继续往后找
                while (iS < s.length && s[iS] < vG) {
                    iS++;
                }
                // 如果满足条件了，ans++，且此蛋糕已分配过，要记得iS++
                if (iS < s.length && s[iS] >= vG) {
                    ans++;
                    iS++;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}