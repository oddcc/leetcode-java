// 899

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class OrderlyQueue {
    public static void main(String[] args) {
        Solution solution = new OrderlyQueue().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String orderlyQueue(String s, int k) {
            String ans;
            if (k == 1) {
                String smallest = s;
                StringBuilder sb = new StringBuilder(s);
                int n = s.length();
                for (int i = 1; i < n; i++) {
                    char c = sb.charAt(0);
                    sb.deleteCharAt(0);
                    sb.append(c);
                    if (sb.toString().compareTo(smallest) < 0) {
                        smallest = sb.toString();
                    }
                }
                ans = smallest;
            } else {
                char[] arr = s.toCharArray();
                Arrays.sort(arr);
                ans = new String(arr);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}