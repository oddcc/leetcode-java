// 1128

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class NumberOfEquivalentDominoPairs {
    public static void main(String[] args) {
        Solution solution = new NumberOfEquivalentDominoPairs().new Solution();
        System.out.println(solution.numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6},{2,1}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，暴力法，利用二重循环进行遍历，遇到相等的就增加计数，O(n^2)的时间复杂度
        // 找规律，如果我们用f(i)表示i个相等的牌之中的符合题意的pair数量，那么可以得到下面的
        // f(1) == 0
        // f(2) == 1
        // f(3) == 2 + 1 == 3 因为第3个骨牌加进来后，跟之前的2个骨牌会形成2个新的pair，加上之前的1个，就是3
        // f(4) == 3 + 3 == 6 同上，之前3个，新增加3个
        // f(5) == 4 + 6 == 10 之前6个，新增加4个
        // f(i) == f(i-1) + i - 1
        // 思路2，哈希表，我们把相同的骨牌视为同种骨牌，在知道每种骨牌数量后，就可以按上面的公示直接求出结果
        public int numEquivDominoPairs(int[][] dominoes) {
            int[] count = new int[100]; // 数字是1~9，用12表示[1,2]的话，可以用11~99表示所有骨牌
            for (int[] domino : dominoes) {
                int key = getKey(domino);
                count[key]++;
            }
            int ans = 0;
            int[] dp = new int[Arrays.stream(count).max().getAsInt() + 1];
            dp[1] = 0;
            for (int i = 2; i < dp.length; i++) {
                dp[i] = dp[i - 1] + i - 1;
            }
            for (int i : count) {
                ans += dp[i];
            }
            return ans;
        }

        private int getKey(int[] d) {
            if (d[0] > d[1]) {
                return d[1] * 10 + d[0];
            }
            return d[0] * 10 + d[1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}