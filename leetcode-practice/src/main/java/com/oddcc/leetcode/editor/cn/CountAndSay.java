// 38
package com.oddcc.leetcode.editor.cn;

public class CountAndSay {
    public static void main(String[] args) {
        Solution solution = new CountAndSay().new Solution();
        System.out.println(solution.countAndSay(1));
        System.out.println(solution.countAndSay(2));
        System.out.println(solution.countAndSay(3));
        System.out.println(solution.countAndSay(4));
        System.out.println(solution.countAndSay(5));
        System.out.println(solution.countAndSay(6));
        System.out.println(solution.countAndSay(7));
        System.out.println(solution.countAndSay(8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String countAndSay(int n) {
            if (n == 1) return "1";
            return convert(countAndSay(n - 1));
        }

        private String convert(String s) {
            char tmp = s.charAt(0);
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= s.length(); i++) {
                // 等于s.length()时，说明结束了，需要进行输出
                if (i == s.length()) {
                    sb.append(count).append(tmp);
                    break;
                }
                // 当前跟tmp一样时，计数+1
                if (tmp == s.charAt(i)) {
                    count++;
                }
                // 不一样时，输出，并把计数设为1，因为当前已经指向了一个不同的
                else {
                    sb.append(count).append(tmp);
                    tmp = s.charAt(i);
                    count = 1;
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}