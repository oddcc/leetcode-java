// 989

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInteger {
    public static void main(String[] args) {
        Solution solution = new AddToArrayFormOfInteger().new Solution();
        System.out.println(solution.addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
        System.out.println(solution.addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        System.out.println(solution.addToArrayForm(new int[]{0}, 34));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 转成10进制再相加肯定是不行的，因为没法解决溢出问题
        // 思路1，模拟手动加法，需要注意进位的问题，最终结果的长度可能大于A.length，但即使进位了，最多也只会进1位
        public List<Integer> addToArrayForm(int[] A, int K) {
            int[] kArr = intToArr(K);
            int carry = 0;
            List<Integer> ans = new ArrayList<>();
            int iA = A.length - 1;
            int iK = kArr.length - 1;
            while (iA >= 0 || iK >= 0) {
                int fromA = iA >= 0 ? A[iA--] : 0;
                int fromK = iK >= 0 ? kArr[iK--] : 0;
                int sum = fromA + fromK + carry;
                if (sum >= 10) {
                    carry = 1;
                }
                else {
                    carry = 0;
                }
                sum = sum % 10;
                ans.add(sum);
            }
            if (carry == 1) ans.add(1);
            Collections.reverse(ans);
            return ans;
        }

        private int[] intToArr(int k) {
            int len = 0;
            int tmp = k;
            while (tmp > 0) {
                tmp = tmp / 10;
                len++;
            }
            int[] arr = new int[len];
            for (int i = arr.length - 1; i >= 0; i--) {
                arr[i] = k % 10;
                k = (k - arr[i]) / 10;
            }
            return arr;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}