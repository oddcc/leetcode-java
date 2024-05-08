// 剑指 Offer 17&&da-yin-cong-1dao-zui-da-de-nwei-shu-lcof

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class DaYinCong1daoZuiDaDeNweiShuLcof {
    public static void main(String[] args) {
        Solution solution = new DaYinCong1daoZuiDaDeNweiShuLcof().new Solution();
        System.out.println(Arrays.toString(solution.printNumbers(1)));
        System.out.println(Arrays.toString(solution.printNumbers(3)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] printNumbers(int n) {
            int total = 1;
            while (n-- > 0) {
                total *= 10;
            }
            int[] ans = new int[total - 1];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = i + 1;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}