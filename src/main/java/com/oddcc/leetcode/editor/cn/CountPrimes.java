// 204

package com.oddcc.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class CountPrimes {
    public static void main(String[] args) {
        Solution solution = new CountPrimes().new Solution();
        // System.out.println(solution.countPrimes(10));
        System.out.println(solution.countPrimes(499979));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Set<Integer> cache = new HashSet<>();

        public int countPrimes(int n) {
            if (n < 2) return 0;
            int ans = 0;
            for (int i = 2; i < n; i++) {
                if (isPrime(i)) ans++;
            }
            return ans;
        }

        private boolean isPrime(int n) {
            boolean isPrime = cache.contains(n);
            if (isPrime) return true;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            cache.add(n);
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}