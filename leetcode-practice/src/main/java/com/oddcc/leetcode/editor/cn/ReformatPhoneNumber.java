// 1694

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ReformatPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new ReformatPhoneNumber().new Solution();
        System.out.println(solution.reformatNumber("1-23-45 6"));
        System.out.println(solution.reformatNumber("123 4-567"));
        System.out.println(solution.reformatNumber("123 4-5678"));
        System.out.println(solution.reformatNumber("12"));
        System.out.println(solution.reformatNumber("--17-5 229 35-39475 "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reformatNumber(String number) {
            List<Integer> nums = new ArrayList<>();
            for (Character c : number.toCharArray()) {
                if (c == ' ') continue;
                if (c == '-') continue;
                nums.add(Integer.valueOf(c.toString()));
            }
            int len = nums.size();
            int block3Count = len / 3;
            int remain = len % 3;
            int block2Count = 0;
            if (remain == 1) {
                block3Count--;
                block2Count = 2;
            } else if (remain == 2) {
                block2Count = 1;
            }
            StringBuilder sb = new StringBuilder();
            int n = 0;
            for (int i = 0; i < block3Count; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(nums.get(n++));
                }
                sb.append('-');
            }
            if (remain == 0) {
                sb.deleteCharAt(sb.lastIndexOf("-"));
            } else {
                for (int i = 0; i < block2Count; i++) {
                    for (int j = 0; j < 2; j++) {
                        sb.append(nums.get(n++));
                    }
                    sb.append('-');
                }
                sb.deleteCharAt(sb.lastIndexOf("-"));
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}