// 421

package com.oddcc.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class MaximumXorOfTwoNumbersInAnArray {
    public static void main(String[] args) {
        Solution solution = new MaximumXorOfTwoNumbersInAnArray().new Solution();
        System.out.println(solution.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
        System.out.println(solution.findMaximumXOR(new int[]{2, 4}));
        System.out.println(solution.findMaximumXOR(new int[]{8, 10, 2}));
        System.out.println(solution.findMaximumXOR(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}));
        System.out.println(solution.findMaximumXOR(new int[]{0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1,暴力法,复杂度是O(n^2)
    // 思路2，位运算+哈希表
    class Solution {
        public int findMaximumXOR(int[] nums) {
            int ans = 0;
            // 对一个二进制数来说,高位的1,大于低位所有1代表十进制数字的加和,所以要从高位开始,依次判断是否可以为1
            for (int k = 30; k >= 0; --k) {
                Set<Integer> seen = new HashSet<>();
                // 将所有的 pre^k(a_j) 放入哈希表中
                for (int num : nums) {
                    // 如果只想保留从最高位开始到第 k 个二进制位为止的部分
                    // 只需将其右移 k 位
                    seen.add(num >> k);
                }

                // 我们这时已经有了ans的高k位,为了后续计算方便,我们假设第k+1位是1
                int next = (ans << 1) + 1;
                boolean found = false;

                // 遍历所有数,如果存在使第k+1位是1的数,则说明可以满足
                // 这里利用的是 a XOR b == c => a = b XOR c 的性质
                // 这里a是我们要找的数；b就是next，表示如果ans这一位是1的话，ans是什么样的；c就是遍历数字的高k位
                // 如果找到了，那么就说明满足条件
                for (int num : nums) {
                    if (seen.contains(next ^ (num >> k))) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    ans = next;
                }
                else {
                    // 不能满足第k+1位是1的情况，这里相当于第k+1位置为0
                    ans = next - 1;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}