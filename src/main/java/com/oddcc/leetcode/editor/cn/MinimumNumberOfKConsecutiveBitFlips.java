// 995

package com.oddcc.leetcode.editor.cn;

public class MinimumNumberOfKConsecutiveBitFlips {
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfKConsecutiveBitFlips().new Solution();
        System.out.println(solution.minKBitFlips(new int[]{0, 1, 0}, 1));
        System.out.println(solution.minKBitFlips(new int[]{1, 1, 0}, 2));
        System.out.println(solution.minKBitFlips(new int[]{0, 0, 0, 1, 0, 1, 1, 0}, 3));
        System.out.println(solution.minKBitFlips(new int[]{0, 1}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，暴力法，以每个i为长度为K的子数组的左边界来看，一共有A.length - K + 1个子数组
        // 每个子数组都有可能翻转或者不翻转，粗略估一下时间复杂的是O(2^N)
        // 思路2，贪心，当左边界为值为0时，不得不进行翻转，当左边界值为1时，则跳过不进行翻转；超时
        // 思路3，使用差分数组优化思路2，不必执行实际的翻转操作
        public int minKBitFlips(int[] A, int K) {
            int len = A.length;
            int ans = 0;
            int[] arr = new int[len + 1];
            for (int i = 0, cnt = 0; i < len; i++) {
                cnt += arr[i];
                if ((A[i] + cnt) % 2 == 0) {
                    if (i + K > len) return -1;
                    arr[i + 1]++;
                    arr[i + K]--;
                    ans++;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}