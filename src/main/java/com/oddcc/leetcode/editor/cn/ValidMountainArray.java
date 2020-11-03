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
            int left = 0;
            // 主意边界条件，不要越界
            while (left < A.length - 1 && A[left] < A[left + 1]) {
                left++;
            }
            if (left == 0 || left == A.length - 1) return false;
            int right = A.length - 1;
            // 主意边界条件，不要越界
            while (right > 0 && A[right] < A[right - 1]) {
                right--;
            }
            return left == right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}