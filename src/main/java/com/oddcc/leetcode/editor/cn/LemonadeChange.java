// 860

package com.oddcc.leetcode.editor.cn;

public class LemonadeChange {
    public static void main(String[] args) {
        Solution solution = new LemonadeChange().new Solution();
        // System.out.println(solution.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        // System.out.println(solution.lemonadeChange(new int[]{5, 5, 10}));
        // System.out.println(solution.lemonadeChange(new int[]{10, 10}));
        // System.out.println(solution.lemonadeChange(new int[]{5, 5, 10, 10, 20}));
        System.out.println(solution.lemonadeChange(new int[]{5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，对每个面额进行计数，如果满足就收下，不满足就返回false
        public boolean lemonadeChange(int[] bills) {
            int[] count = new int[3]; // 0-5元，1-10元，2-20元
            for (int i : bills) {
                if (i == 5) {
                    count[0]++;
                }
                else if (i == 10) {
                    if (count[0] <= 0) return false;
                    count[0]--;
                    count[1]++;
                }
                else {
                    if (count[1] >= 1 && count[0] >= 1) {
                        count[0]--;
                        count[1]--;
                        count[2]++;
                    }
                    else if (count[0] >= 3) {
                        count[0] -= 3;
                        count[2]++;
                    }
                    else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}