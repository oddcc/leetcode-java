// 6

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
        // System.out.println(solution.convert("PAYPALISHIRING", 3));
        // System.out.println(solution.convert("PAYPALISHIRING", 4));
        // System.out.println(solution.convert("A", 1));
        System.out.println(solution.convert("AB", 1));
        System.out.println(solution.convert("AB", 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，用一个不停变换的指针，指向需要插入的数组，结束后遍历输出所有数组即可
        public String convert(String s, int numRows) {
            if (numRows == 1) return s; // 如果numRows是1，则不用走Z字形
            List<List<String>> ans = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                ans.add(new ArrayList<>());
            }
            boolean descend = true; // 插入指针的值是否递增
            int currentRow = 0; // 当前插入指针的位置
            for (Character c : s.toCharArray()) {
                ans.get(currentRow).add(String.valueOf(c));
                // System.out.println(currentRow);
                if (descend) {
                    currentRow++;
                    // 最大方向越界了，改变方向，值设为最大-2
                    if (currentRow == numRows) {
                        descend = false;
                        currentRow = currentRow - 2;
                    }
                }
                else {
                    currentRow--;
                    // 最小方向越界了，改变方向，设为最小+2
                    if (currentRow < 0) {
                        descend = true;
                        currentRow = currentRow + 2;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (List<String> list: ans) {
                for (String tmp: list) {
                    sb.append(tmp);
                }
            }
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}