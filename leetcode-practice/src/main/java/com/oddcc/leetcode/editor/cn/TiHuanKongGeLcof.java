// 剑指 Offer 05&&ti-huan-kong-ge-lcof

package com.oddcc.leetcode.editor.cn;

public class TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
        System.out.println(solution.replaceSpace("We are happy."));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，直接按位读取然后替换
        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c: s.toCharArray()) {
                if (c != ' ') {
                    sb.append(c);
                } else {
                    sb.append("%20");
                }
            }
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}