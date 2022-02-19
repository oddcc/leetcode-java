// 119


package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
        System.out.println(solution.getRow(0));
        System.out.println(solution.getRow(1));
        System.out.println(solution.getRow(2));
        System.out.println(solution.getRow(3));
        System.out.println(solution.getRow(4));
        System.out.println(solution.getRow(5));
        System.out.println(solution.getRow(6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，找规律，直接生成
        public List<Integer> getRow(int rowIndex) {
            Integer[] ans = new Integer[]{1};
            for (int i = 1; i <= rowIndex; i++) {
                Integer[] row = new Integer[i + 1];
                row[0] = 1;
                row[i] = 1;
                for (int j = 1; j <= i - 1; j++) {
                    row[j] = ans[j - 1] + (j < ans.length? ans[j]:0);
                }
                ans = row;
            }
            return Arrays.asList(ans);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}