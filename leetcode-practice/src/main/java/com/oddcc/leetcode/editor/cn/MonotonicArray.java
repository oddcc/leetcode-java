// 896

package com.oddcc.leetcode.editor.cn;

public class MonotonicArray {
    public static void main(String[] args) {
        Solution solution = new MonotonicArray().new Solution();
        System.out.println(solution.isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(solution.isMonotonic(new int[]{6, 5, 4, 4}));
        System.out.println(solution.isMonotonic(new int[]{1, 3, 2}));
        System.out.println(solution.isMonotonic(new int[]{1, 2, 4, 5}));
        System.out.println(solution.isMonotonic(new int[]{1, 1, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 一次遍历
        public boolean isMonotonic(int[] A) {
            Boolean asc = null; // null 表示还不确定，true表示升序，false表示降序
            for (int i = 1; i < A.length; i++) {
                // 如果升序降序已经确定，则发现不符的就返回false
                if (asc != null) {
                    if (asc && A[i - 1] > A[i]) return false;
                    if (!asc && A[i - 1] < A[i]) return false;
                }
                // 如果升序降序还没确定，则先确定是升序还是降序
                else {
                    if (A[i - 1] > A[i]) {
                        asc = false;
                    }
                    else if (A[i - 1] < A[i]) {
                        asc = true;
                    }
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}