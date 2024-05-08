// 剑指 Offer 38&&zi-fu-chuan-de-pai-lie-lcof

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
        // System.out.println(Arrays.toString(solution.permutation("abc")));
        System.out.println(Arrays.toString(solution.permutation("aab")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，回溯法，使用Set去重
    // 思路2，优化算法
    class Solution {
        public String[] permutation(String s) {
            List<String> ansList = new ArrayList<>();
            char[] chars = s.toCharArray();
            // 排序，相同的字符会在一起
            Arrays.sort(chars);
            backtracing(chars, "", new boolean[s.length()], ansList);
            String[] ans = new String[ansList.size()];
            int i = 0;
            for (String str : ansList) {
                ans[i++] = str;
            }
            return ans;
        }

        /**
         *
         * @param chars 源数据
         * @param cur 当前字符串
         * @param used 指定字符是否用过
         * @param ansList
         */
        private void backtracing(char[] chars, String cur, boolean[] used, List<String> ansList) {
            if (cur.length() == chars.length) {
                ansList.add(cur);
                return;
            }
            // 挨个尝试没用过的字符
            for (int i = 0; i < used.length; i++) {
                // 只有前一个相同字符使用过了，再考虑使用后一个相同字符，这样就不会出现重复的情况
                // 相当于在相同的字符之中，生成的是组合而不是排列
                // 如果有相同的字符a1和a2，按这种规则，a1永远会出现在a2之前，从而避免了重复
                if (used[i] || (i - 1 >= 0 && !used[i - 1] && chars[i - 1] == chars[i])) {
                    continue;
                }
                used[i] = true;
                backtracing(chars, cur + chars[i], used, ansList);
                used[i] = false;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}