// 646

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthOfPairChain {
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfPairChain().new Solution();
        System.out.println(solution.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
            int result = 0, current = Integer.MIN_VALUE;
            for (int i = 0; i < pairs.length; i++) {
                if (pairs[i][0] > current) {
                    current = pairs[i][1];
                    result++;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}