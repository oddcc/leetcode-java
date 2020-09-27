//Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.
// 
//
// Notice that the row index starts from 0. 
//
// 
//In Pascal's triangle, each number is the sum of the two numbers directly above
// it. 
//
// Follow up: 
//
// Could you optimize your algorithm to use only O(k) extra space? 
//
// 
// Example 1: 
// Input: rowIndex = 3
//Output: [1,3,3,1]
// Example 2: 
// Input: rowIndex = 0
//Output: [1]
// Example 3: 
// Input: rowIndex = 1
//Output: [1,1]
// 
// 
// Constraints: 
//
// 
// 0 <= rowIndex <= 40 
// 
// Related Topics 数组 
// 👍 181 👎 0


package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
        System.out.println(solution.getRow(0));
        System.out.println(solution.getRow(1));
        System.out.println(solution.getRow(2));
        System.out.println(solution.getRow(3));
        System.out.println(solution.getRow(4));
        System.out.println(solution.getRow(5));
        System.out.println(solution.getRow(6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            int numsLength = rowIndex + 1;
            Integer[] nums = new Integer[numsLength];
            Arrays.fill(nums, 0);
            nums[0] = 1;
            for (int i = 0; i < numsLength; i++) {
                Integer[] backup = Arrays.copyOf(nums, numsLength);
                for (int j = 0; j <= i; j++) {
                    nums[j] = backup[j] + (j - 1 < 0 ? 0 : backup[j - 1]);
                }
            }
            return Arrays.asList(nums);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}