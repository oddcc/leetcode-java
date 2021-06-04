// 118

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        System.out.println(solution.generate(5));
        System.out.println(solution.generate(0));
        System.out.println(solution.generate(1));
        System.out.println(solution.generate(40));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                if (i == 0) {
                    List<Integer> row = new ArrayList<>();
                    row.add(1);
                    ans.add(row);
                }
                else {
                    List<Integer> pre = ans.get(i - 1);
                    List<Integer> row = new ArrayList<>();
                    for (int j = 0; j < i + 1; j++) {
                        int num = 0;
                        if (j == 0) {
                            num = pre.get(0);
                        }
                        else {
                            num = (j < pre.size() ? pre.get(j) : 0) + (j - 1 < pre.size() ? pre.get(j - 1) : 0);
                        }
                        row.add(num);
                    }
                    ans.add(row);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}