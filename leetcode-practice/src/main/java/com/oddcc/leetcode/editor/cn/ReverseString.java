// 344

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        Solution solution = new ReverseString().new Solution();
        char[] c1 = "hello".toCharArray();
        solution.reverseString(c1);
        System.out.println(Arrays.toString(c1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            int left = 0;
            int right = s.length - 1;
            while (left < right) {
                exchange(s, left, right);
                left++;
                right--;
            }
        }

        private void exchange(char[] s, int a, int b) {
            char tmp = s[a];
            s[a] = s[b];
            s[b] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}