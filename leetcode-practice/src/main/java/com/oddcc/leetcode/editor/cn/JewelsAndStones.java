// 771
package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class JewelsAndStones {
    public static void main(String[] args) {
        Solution solution = new JewelsAndStones().new Solution();
        System.out.println(solution.numJewelsInStones("z", "ZZ"));
        System.out.println(solution.numJewelsInStones("aA", "aAAbbbb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 方法1，可以采用暴力遍历，负责度O(m * n)
        // 方法2，知道表示的都是数字，所以可以把数量存起来，时间复杂度O(m + n)
        public int numJewelsInStones(String J, String S) {
            int[] count = new int['z' - 'A' + 1];
            Arrays.fill(count, -1);
            // 把是宝石的地方标志成0
            for (int i = 0; i < J.length(); i++) {
                count[J.charAt(i) - 'A'] = 0;
            }
            // 计数
            for (int i = 0; i < S.length(); i++) {
                char s = S.charAt(i);
                if (count[s - 'A'] != -1) {
                    count[s - 'A']++;
                }
            }
            // 输出结果
            int result = 0;
            for (int i = 0; i < count.length; i++) {
                if (count[i] != -1) {
                    result += count[i];
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}