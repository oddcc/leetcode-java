// 1239

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfAConcatenatedStringWithUniqueCharacters().new Solution();
        System.out.println(solution.maxLength(Arrays.asList("un", "iq", "ue")));
        System.out.println(solution.maxLength(Arrays.asList("cha", "r", "act", "ers")));
        System.out.println(solution.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，每个字符串可以转换为一个26位的二进制整数，每一位表示是否存在某字符，因为arr.length<=16，可以尝试遍历
    class Solution {
        public int maxLength(List<String> arr) {
            int ans = 0;
            List<Integer> masks = new ArrayList<>();
            masks.add(0);
            for (String s : arr) {
                // s的二进制表示
                int mask = 0;
                // 把s转换为二进制表示
                for (int i = 0; i < s.length(); ++i) {
                    int ch = s.charAt(i) - 'a';
                    // 如果在字符串s之内有重复字符，则s肯定不会用于生成答案，直接break
                    if (((mask >> ch) & 1) != 0) {
                        mask = 0;
                        break;
                    }
                    mask |= 1 << ch;
                }
                // 如果s中不含任何字符，也用不到
                if (mask == 0) {
                    continue;
                }
                int n = masks.size();
                // 尝试跟已有的字符串连接进行连接，如果没有重复字符，则把结果加入mask，更新ans
                for (int i = 0; i < n; ++i) {
                    int m = masks.get(i);
                    if ((m & mask) == 0) {
                        masks.add(m | mask);
                        ans = Math.max(ans, Integer.bitCount(m | mask));
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}