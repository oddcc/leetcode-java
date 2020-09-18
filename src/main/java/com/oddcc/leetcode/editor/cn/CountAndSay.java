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