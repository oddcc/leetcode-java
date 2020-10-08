//Write a function that reverses a string. The input string is given as an array
// of characters char[]. 
//
// Do not allocate extra space for another array, you must do this by modifying 
//the input array in-place with O(1) extra memory. 
//
// You may assume all the characters consist of printable ascii characters. 
//
// 
//
// 
// Example 1: 
//
//
//Input: ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]
// 
//
// 
// Example 2: 
//
// 
//Input: ["H","a","n","n","a","h"]
//Output: ["h","a","n","n","a","H"]
// 
// 
// 
// Related Topics 双指针 字符串 
// 👍 302 👎 0


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