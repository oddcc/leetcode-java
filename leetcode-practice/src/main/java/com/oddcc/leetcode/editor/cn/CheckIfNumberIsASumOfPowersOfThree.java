// 1780

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CheckIfNumberIsASumOfPowersOfThree {
    public static void main(String[] args) {
        Solution solution = new CheckIfNumberIsASumOfPowersOfThree().new Solution();
        System.out.println(solution.checkPowersOfThree(12));
        System.out.println(solution.checkPowersOfThree(91));
        System.out.println(solution.checkPowersOfThree(21));
        System.out.println(solution.checkPowersOfThree(6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkPowersOfThree(int n) {
            List<Integer> options = new ArrayList<>();
            int i = 1;
            while (i <= n) {
                options.add(i);
                i *= 3;
            }
            return dfs(options, options.size() - 1, 0, n);
        }

        private boolean dfs(List<Integer> options, int i, int sum, int target) {
            if (sum == target) {
                return true;
            }
            if (i < 0 || i >= options.size()) {
                return false;
            }
            return dfs(options, i - 1, sum + options.get(i), target) || dfs(options, i - 1, sum, target);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}