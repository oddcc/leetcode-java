// 368

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        Solution solution = new LargestDivisibleSubset().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int[] f = new int[n];
            int[] g = new int[n];
            for (int i = 0; i < n; i++) {
                int len = 1, prev = i;
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0) {
                        if (f[j] + 1 > len) {
                            len = f[j] + 1;
                            prev = j;
                        }
                    }
                }
                f[i] = len;
                g[i] = prev;
            }

            int max = -1, idx = -1;
            for (int i = 0; i < n; i++) {
                if (f[i] > max) {
                    idx = i;
                    max = f[i];
                }
            }

            List<Integer> ans = new ArrayList<>();
            while (ans.size() != max) {
                ans.add(nums[idx]);
                idx = g[idx];
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}