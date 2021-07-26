// 1736

package com.oddcc.leetcode.editor.cn;

public class LatestTimeByReplacingHiddenDigits {
    public static void main(String[] args) {
        Solution solution = new LatestTimeByReplacingHiddenDigits().new Solution();
        System.out.println(solution.maximumTime("2?:?0"));
        System.out.println(solution.maximumTime("0?:3?"));
        System.out.println(solution.maximumTime("1?:22"));
        System.out.println(solution.maximumTime("??:??"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，每个位置都有各自的最大取值（也跟前后数字的值相关）
    class Solution {
        public String maximumTime(String time) {
            char[] chars = time.toCharArray();
            for (int i = 0; i < time.length(); i++) {
                char c = chars[i];
                if (c != '?') continue;
                if (i == 0) {
                    if (chars[i + 1] == '?') chars[i] = '2';
                    else if (chars[i + 1] > '3') chars[i] = '1';
                    else chars[i] = '2';
                }
                else if (i == 1) {
                    if (chars[i - 1] < '2') chars[i] = '9';
                    else chars[i] = '3';
                }
                else if (i == 3) {
                    chars[i] = '5';
                }
                else if (i == 4) {
                    chars[i] = '9';
                }
            }

            return String.valueOf(chars);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}