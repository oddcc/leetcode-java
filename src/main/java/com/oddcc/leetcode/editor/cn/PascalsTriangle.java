//Given a non-negative integer numRows, generate the first numRows of Pascal's t
//riangle. 
//
// 
//In Pascal's triangle, each number is the sum of the two numbers directly above
// it. 
//
// Example: 
//
// 
//Input: 5
//Output:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
// 
// Related Topics 数组 
// 👍 353 👎 0


package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        System.out.println(solution.generate(5));
        System.out.println(solution.generate(0));
        System.out.println(solution.generate(1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 其实可以左对齐，比较好观察，下一行的第i个数，就是上一行的第i个+第i-1个，另外还要处理一些越界的情况
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> lastRow = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    row.add(getSumFromLast(lastRow, j));
                }
                lastRow = row;
                result.add(row);
            }
            return result;
        }

        // 返回lastRow中i 和 i - 1位置的和，如果越界则为0
        private Integer getSumFromLast(List<Integer> lastRow, int i) {
            if (lastRow.isEmpty()) return 1;
            int lower = 0;
            int higher = lastRow.size() - 1;
            int a = (i >= lower && i <= higher) ? lastRow.get(i) : 0;
            int b = (i - 1 >= lower && i - 1 <= higher) ? lastRow.get(i - 1) : 0;
            return a + b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}