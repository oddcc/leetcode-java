// 709

package com.oddcc.leetcode.editor.cn;

public class ToLowerCase {
    public static void main(String[] args) {
        Solution solution = new ToLowerCase().new Solution();
        System.out.println(solution.toLowerCase("Hello"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，直接按字符转换
        public String toLowerCase(String str) {
            StringBuilder ans = new StringBuilder();
            for (char c : str.toCharArray()) {
                if (c >= 'A' && c <= 'Z') {
                    ans.append((char) (c + ('a' - 'A')));
                }
                else {
                    ans.append(c);
                }
            }
            return ans.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}