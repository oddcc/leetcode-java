// 剑指 Offer 38

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
        System.out.println(Arrays.toString(solution.permutation("abc")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，回溯法，使用Set去重
    class Solution {
        public String[] permutation(String s) {
            Set<String> ansSet = new HashSet<>();
            backtracing(s.toCharArray(), "", new boolean[s.length()], ansSet);
            String[] ans = new String[ansSet.size()];
            int i = 0;
            for (String str : ansSet) {
                ans[i++] = str;
            }
            return ans;
        }

        /**
         *
         * @param chars 源数据
         * @param cur 当前字符串
         * @param used 指定字符是否用过
         * @param ansSet
         */
        private void backtracing(char[] chars, String cur, boolean[] used, Set<String> ansSet) {
            if (cur.length() == chars.length) {
                ansSet.add(cur);
                return;
            }
            // 挨个尝试没用过的字符
            for (int i = 0; i < used.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    backtracing(chars, cur + chars[i], used, ansSet);
                    used[i] = false;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}