// 1832

package com.oddcc.leetcode.editor.cn;


public class CheckIfTheSentenceIsPangram {
    public static void main(String[] args) {
        Solution solution = new CheckIfTheSentenceIsPangram().new Solution();
        System.out.println(solution.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(solution.checkIfPangram("leetcode"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkIfPangram(String sentence) {
            int[] count = new int[26];
            for (char c: sentence.toCharArray()) {
                count[c - 'a']++;
            }
            for (int i : count) {
                if (i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}