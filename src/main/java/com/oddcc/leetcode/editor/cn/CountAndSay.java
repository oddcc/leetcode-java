//The count-and-say sequence is the sequence of integers with the first five ter
//ms as following: 
//
// 
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
// 
//
// 1 is read off as "one 1" or 11. 
//11 is read off as "two 1s" or 21. 
//21 is read off as "one 2, then one 1" or 1211. 
//
// Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-s
//ay sequence. You can do so recursively, in other words from the previous member 
//read off the digits, counting the number of digits in groups of the same digit. 
//
//
// Note: Each term of the sequence of integers will be represented as a string. 
//
//
// 
//
// Example 1: 
//
// 
//Input: 1
//Output: "1"
//Explanation: This is the base case.
// 
//
// Example 2: 
//
// 
//Input: 4
//Output: "1211"
//Explanation: For n = 3 the term was "21" in which we have two groups "2" and "
//1", "2" can be read as "12" which means frequency = 1 and value = 2, the same wa
//y "1" is read as "11", so the answer is the concatenation of "12" and "11" which
// is "1211".
// 
// Related Topics 字符串 
// 👍 554 👎 0


package com.oddcc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

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
        private final Map<String, String> mapping = init();

        private Map<String, String> init() {
            Map<String, String> m = new HashMap<>(4);
            m.put("22", "22");
            m.put("2", "12");
            m.put("11", "21");
            m.put("1", "11");
            return m;
        }

        public String countAndSay(int n) {
            if (n == 1) return "1";
            return convert(countAndSay(n - 1));
        }

        private String convert(String s) {
            if (mapping.containsKey(s)) return mapping.get(s);
            // 到这里s的长度一定大于等于2
            String firstTwo = s.substring(0, 2);
            String firstOne = s.substring(0, 1);
            if (mapping.containsKey(firstTwo)) {
                return mapping.get(firstTwo) + convert(s.substring(2));
            }
            else {
                return mapping.get(firstOne) + convert((s.substring(1)));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}