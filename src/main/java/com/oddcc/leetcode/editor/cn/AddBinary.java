// 67

package com.oddcc.leetcode.editor.cn;

public class AddBinary {
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
//        System.out.println(solution.addBinary("11", "1"));
//        System.out.println(solution.addBinary("11", "11"));
//        System.out.println(solution.addBinary("1010", "1011"));
        System.out.println(solution.addBinary("0", "0"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            int al = a.length();
            int bl = b.length();
            int length = Math.max(al, bl);
            StringBuilder sb = new StringBuilder();
            int increment = 0;
            for (int i = 0; i < length; i++) {
                int addA = getAdd(a, a.length() - i - 1);
                int addB = getAdd(b, b.length() - i - 1);
                int sum = addA + addB + increment;
                if (sum >= 2) {
                    increment = 1;
                    sb.append(sum - 2);
                } else {
                    increment = 0;
                    sb.append(sum);
                }
            }
            if (increment != 0) {
                sb.append(1);
            }
            return sb.reverse().toString();
        }

        // 从字符串中取出i位置的数字，如果i超过了索引范围则返回0
        private int getAdd(String str, int i) {
            if (i >= 0 && i < str.length()) {
                return Integer.parseInt(str.substring(i, i + 1));
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}