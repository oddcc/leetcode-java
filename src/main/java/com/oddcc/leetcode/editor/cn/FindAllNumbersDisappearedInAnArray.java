// 448

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        Solution solution = new FindAllNumbersDisappearedInAnArray().new Solution();
        System.out.println(solution.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(solution.findDisappearedNumbers(new int[]{2, 2}));
        System.out.println(solution.findDisappearedNumbers(new int[]{10, 2, 5, 10, 9, 1, 1, 4, 3, 7}));
        System.out.println(solution.findDisappearedNumbers(new int[]{5, 4, 6, 7, 9, 3, 10, 9, 5, 6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，另外一个数组存储对应数字是否出现，然后遍历这个是否出现的数组得到结果；不满足O(1)的空间复杂度要求
        // 思路2，一次遍历，利用数组本身记录对应位置的数字是否出现了
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (nums[i] > 0) ans.add(i + 1);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}