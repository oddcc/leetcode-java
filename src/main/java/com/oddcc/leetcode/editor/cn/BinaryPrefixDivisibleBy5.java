// 1018

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {
    public static void main(String[] args) {
        Solution solution = new BinaryPrefixDivisibleBy5().new Solution();
        System.out.println(solution.prefixesDivBy5(new int[]{0, 1, 1}));
        System.out.println(solution.prefixesDivBy5(new int[]{1, 1, 1}));
        System.out.println(solution.prefixesDivBy5(new int[]{0, 1, 1, 1, 1, 1}));
        System.out.println(solution.prefixesDivBy5(new int[]{1, 1, 1, 0, 1}));
        System.out.println(solution.prefixesDivBy5(new int[]{1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 左边是高位，右边是低位，所以f(i)表示A[0] ~ A[i]表示的二进制数的话，应该有f(i)=2*f(i-1) + A[i]，特别的f(0) == A[0]
        // 需要考虑溢出的问题，否则测试用例大一点就会出错
        // 思路1，一次遍历，如果之前的值已经能够整除5，则去掉后对结果没有影响，留余数就可以，这样就可以避免溢出
        public List<Boolean> prefixesDivBy5(int[] A) {
            List<Boolean> ans = new ArrayList<>();
            int value = -1;
            for (int i = 0; i < A.length; i++) {
                if (i == 0) {
                    value = A[i];
                }
                else {
                    value = value % 5;
                    value = value * 2 + A[i];
                }
                System.out.println(value);
                ans.add(value % 5 == 0);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}