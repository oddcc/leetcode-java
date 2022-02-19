// 1486

package com.oddcc.leetcode.editor.cn;

public class XorOperationInAnArray {
    public static void main(String[] args) {
        Solution solution = new XorOperationInAnArray().new Solution();
        System.out.println(solution.xorOperation(5, 0));
        System.out.println(solution.xorOperation(4, 3));
        System.out.println(solution.xorOperation(1, 7));
        System.out.println(solution.xorOperation(10, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，直接计算
    class Solution {
        public int xorOperation(int n, int start) {
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans ^= start;
                start += 2;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}