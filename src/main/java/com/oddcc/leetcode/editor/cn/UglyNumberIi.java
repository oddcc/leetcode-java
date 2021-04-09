// 264

package com.oddcc.leetcode.editor.cn;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new UglyNumberIi().new Solution();
        System.out.println(solution.nthUglyNumber(10));
        System.out.println(solution.nthUglyNumber(1));
        System.out.println(solution.nthUglyNumber(1690));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，暴力法，每从1开始，每次+1，然后判断是否是ugly number，如果是就计数，不是就跳过
        // 思路2，优化思路1，把计算过的ugly number缓存起来，加快之后的计算
        // 使用缓存还是有太多的无效计算
        // 思路3，只计算ugly number，1 -> 2,3,5；2 -> 4,6,10以此类推，利用最小堆来记录计算到了哪个数，使用Integer有溢出的问题
        public int nthUglyNumber(int n) {
            PriorityQueue<Long> minHeap = new PriorityQueue<>();
            Set<Long> seen = new HashSet<>();
            minHeap.add(1L); // 加入初始值1
            seen.add(1L);
            int count = 0; // 表示从minHeap中弹出元素的次数，当第n次弹出时，弹出的就是答案
            long ans = 0;
            int[] primes = {2, 3, 5};
            while (true) {
                long i = minHeap.remove();
                for (int p : primes) {
                    if (!seen.contains(i * p)) {
                        minHeap.add(i * p);
                        seen.add(i * p);
                    }
                }
                count++;
                if (count == n) {
                    ans = i;
                    break;
                }
            }
            return (int) ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}