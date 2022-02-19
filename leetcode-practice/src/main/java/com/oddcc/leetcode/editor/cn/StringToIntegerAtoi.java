// 8

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringToIntegerAtoi {
    public static void main(String[] args) {
        Solution solution = new StringToIntegerAtoi().new Solution();
        System.out.println(solution.myAtoi("-2147483648"));
        System.out.println(solution.myAtoi("2147483647"));
        System.out.println(solution.myAtoi("2147483648"));
        System.out.println(solution.myAtoi("-6147483648"));
        System.out.println(solution.myAtoi("3.14159"));
        System.out.println(solution.myAtoi("   -42"));
        System.out.println(solution.myAtoi("00000-42a1234"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi(" with words 123"));
        System.out.println(solution.myAtoi("0000000000012345678"));
        System.out.println(solution.myAtoi("+0 123"));
        System.out.println(solution.myAtoi("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 通过状态机，简化判断逻辑
        public int myAtoi(String s) {
            String cleanStr = clean(s);
            long ans = 0;
            boolean positive = !cleanStr.startsWith("-");
            for (int i = 0; i < cleanStr.length(); i++) {
                char c = cleanStr.charAt(i);
                if (c == '-' || c == '+') {
                    continue;
                }
                long num = (c - '0');
                if (positive) {
                    ans = ans * 10 + num;
                    if (ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                }
                else {
                    ans = ans * 10 - num;
                    if (ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                }
            }
            return (int) ans;
        }

        Map<String, List<String>> stateMachine = new HashMap<String, List<String>>() {
            {
                put("start", Arrays.asList("start", "numbered", "signed", "fail"));
                put("signed", Arrays.asList("fail", "numbered", "fail", "fail"));
                put("numbered", Arrays.asList("end", "numbered", "end", "end"));
            }
        };

        // 转换字符串，如果失败则返回空字符串
        private String clean(String s) {
            StringBuilder sb = new StringBuilder();
            String state = "start";
            for (Character c : s.toCharArray()) {
                if (c == ' ') {
                    state = stateMachine.get(state).get(0);
                }
                else if (c >= '0' && c <= '9') {
                    state = stateMachine.get(state).get(1);
                }
                else if (c == '-' || c == '+') {
                    state = stateMachine.get(state).get(2);
                }
                else {
                    state = stateMachine.get(state).get(3);
                }
                if (state.equals("start")) continue;
                if (state.equals("end")) return sb.toString();
                if (state.equals("fail")) return "";
                sb.append(c);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}