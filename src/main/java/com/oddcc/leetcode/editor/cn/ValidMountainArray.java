package com.oddcc.leetcode.editor.cn;

public class ValidMountainArray {
    public static void main(String[] args) {
        Solution solution = new ValidMountainArray().new Solution();
        System.out.println(solution.validMountainArray(new int[]{3, 5, 5}));
        System.out.println(solution.validMountainArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(solution.validMountainArray(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));
        System.out.println(solution.validMountainArray(new int[]{0, 3, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validMountainArray(int[] A) {
            if (A.length < 3) return false;
            int state = 0; // 0-初始，1-上升，2-下降
            Integer tmp = null;
            for (int i : A) {
                if (tmp == null) {
                    tmp = i;
                }
                else {
                    if (tmp == i) return false;
                    if (state == 0) {
                        if (i > tmp) {
                            state = 1;
                        }
                        else {
                            return false;
                        }
                    }
                    else if (state == 1) {
                        if (i < tmp) {
                            state = 2;
                        }
                    }
                    else {
                        if (i > tmp) return false;
                    }
                    tmp = i;
                }
            }
            return state == 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}