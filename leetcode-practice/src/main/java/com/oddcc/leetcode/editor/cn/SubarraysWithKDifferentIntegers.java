// 992

package com.oddcc.leetcode.editor.cn;

public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        Solution solution = new SubarraysWithKDifferentIntegers().new Solution();
        // System.out.println(solution.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
        // System.out.println(solution.subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3));
        // System.out.println(solution.subarraysWithKDistinct(new int[]{2, 1, 1, 1, 2}, 1));
        System.out.println(solution.subarraysWithKDistinct(new int[]{1, 1, 1, 2, 1, 2, 2, 1}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，遍历所有可能的子数组，通过维护一个哈希表，来判断子数组的K值，通过滑动数组来减少重复计算
        // 思路2，如果f(K)表示至多有K个不同整数的子数组的数量的话，则有ans => f(K) - f(K - 1)
        // 而f(K)可以通过遍历求出，比如[1, 2, 1, 2, 3]，在i>=4时，就不可能再有K==2的子数组出现了，即f(K)的值，在遍历到i==4时，就已经确定了
        public int subarraysWithKDistinct(int[] A, int K) {
            return atMostKDistinct(A, K) - atMostKDistinct(A, K - 1);
        }

        /**
         * @param A
         * @param K
         * @return 最多包含 K 个不同整数的子区间的个数
         */
        private int atMostKDistinct(int[] A, int K) {
            int len = A.length;
            int[] freq = new int[len + 1];

            int left = 0;
            int right = 0;
            // [left, right) 里不同整数的个数
            int count = 0;
            int res = 0;
            // [left, right) 包含不同整数的个数小于等于 K
            while (right < len) {
                if (freq[A[right]] == 0) {
                    count++;
                }
                freq[A[right]]++;
                right++;

                while (count > K) {
                    freq[A[left]]--;
                    if (freq[A[left]] == 0) {
                        count--;
                    }
                    left++;
                }
                // [left, right) 区间的长度就是对结果的贡献
                res += right - left;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}