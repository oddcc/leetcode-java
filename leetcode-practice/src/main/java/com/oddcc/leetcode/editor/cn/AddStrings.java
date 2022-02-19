// 415

package com.oddcc.leetcode.editor.cn;

public class AddStrings {
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
        System.out.println(solution.addStrings("10000000000000000","1"));
        System.out.println(solution.addStrings("9999999999999999","1"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 直接转换为数字会有溢出的问题
        // 思路1，转为数组，模拟手动加法，最后再转回字符串
        public String addStrings(String num1, String num2) {
            char[] arr1 = num1.toCharArray();
            char[] arr2 = num2.toCharArray();
            StringBuilder ans = new StringBuilder();
            int carry = 0;
            for (int i = 0; i < Math.max(arr1.length, arr2.length); i++) {
                int n1 = arr1.length - 1 - i >= 0 ? arr1[arr1.length - 1 - i] - '0' : 0;
                int n2 = arr2.length - 1 - i >= 0 ? arr2[arr2.length - 1 - i] - '0' : 0;
                int sum = n1 + n2 + carry;
                carry = sum / 10;
                ans.append(sum % 10);
            }
            if (carry != 0) ans.append(carry);
            return ans.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}