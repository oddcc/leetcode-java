// 167
package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
        int[] n1 = {2,7,11,15};
        int t1 = 9;
        System.out.println(Arrays.toString(solution.twoSum(n1, t1)));
        int[] n2 = {2,3,4};
        int t2 = 6;
        System.out.println(Arrays.toString(solution.twoSum(n2, t2)));
        int[] n3 = {-1,0};
        int t3 = -1;
        System.out.println(Arrays.toString(solution.twoSum(n3, t3)));
        int[] n4 = {1,2,3,4,4,9,56,90};
        int t4 = 8;
        System.out.println(Arrays.toString(solution.twoSum(n4, t4)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 动态规划，一个left指针，一个right指针，当sum小于target时，应该左侧指针向右移，当sum大于target时，应该右侧指针向左移动
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) return new int[]{left + 1, right + 1};
                if (sum < target) left++;
                if (sum > target) right--;
            }
            return new int[]{-1, -1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}