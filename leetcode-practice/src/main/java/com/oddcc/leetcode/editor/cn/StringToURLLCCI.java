// 面试题 01.03

package com.oddcc.leetcode.editor.cn;

public class StringToURLLCCI {
    public static void main(String[] args) {
        Solution solution = new StringToURLLCCI().new Solution();
        System.out.println(solution.replaceSpaces("Mr John Smith    ", 13));
        System.out.println(solution.replaceSpaces("               ", 5));
        System.out.println(solution.replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpaces(String S, int length) {
            char[] chars = S.toCharArray();
            int spaceCnt = 0;
            for (int i = length - 1; i >= 0; i--) {
                if (chars[i] == ' ') {
                    spaceCnt++;
                }
            }

            char[] ans = new char[length + spaceCnt * 2];
            int w = ans.length - 1;
            for (int i = length - 1; i >= 0; i--) {
                if (chars[i] != ' ') {
                    ans[w] = chars[i];
                    w--;
                } else {
                    ans[w] = '0';
                    ans[w - 1] = '2';
                    ans[w - 2] = '%';
                    w = w - 3;
                }
            }
            return String.valueOf(ans);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}