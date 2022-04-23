// 面试题 01.01

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class IsUniqueLCCI {
    public static void main(String[] args) {
        Solution solution = new IsUniqueLCCI().new Solution();
        System.out.println(solution.isUnique("leetcode"));
        System.out.println(solution.isUnique("abc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isUnique(String astr) {
            int[] map = new int[26];
            Arrays.fill(map, 0);
            int cnt = 0;
            for (char c: astr.toCharArray()) {
                int i = c - 'a';
                if (map[i] == 0) {
                    map[i] = 1;
                    cnt++;
                }
            }
            return cnt == astr.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}