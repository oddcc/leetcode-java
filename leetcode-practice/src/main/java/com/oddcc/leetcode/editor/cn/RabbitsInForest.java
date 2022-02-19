// 781

package com.oddcc.leetcode.editor.cn;

public class RabbitsInForest {
    public static void main(String[] args) {
        Solution solution = new RabbitsInForest().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numRabbits(int[] answers) {
            if (answers == null || answers.length == 0) return 0;
            int ans = 0;
            int[] countArr = new int[1000];
            for (int answer : answers) {
                if (countArr[answer] == 0) {
                    countArr[answer] = answer;
                    ans += answer + 1;
                } else {
                    countArr[answer]--;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}