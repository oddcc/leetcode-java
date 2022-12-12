// 1781

package com.oddcc.leetcode.editor.cn;

public class SumOfBeautyOfAllSubstrings {
    public static void main(String[] args) {
        Solution solution = new SumOfBeautyOfAllSubstrings().new Solution();
        System.out.println(solution.beautySum("aabcb"));
        System.out.println(solution.beautySum("aabcbaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int beautySum(String s) {
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                int[] countMap = new int[26];
                for (int j = i; j < s.length(); j++) {
                    char c = s.charAt(j);
                    countMap[c - 'a'] += 1;
                    int max = 0;
                    int min = Integer.MAX_VALUE;
                    for (int n: countMap) {
                        if (n > 0) {
                            max = Math.max(max, n);
                            min = Math.min(min, n);
                        }
                    }
                    ans += max - min;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}