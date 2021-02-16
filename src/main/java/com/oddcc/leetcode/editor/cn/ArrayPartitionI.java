// 561

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class ArrayPartitionI {
    public static void main(String[] args) {
        Solution solution = new ArrayPartitionI().new Solution();
        System.out.println(solution.arrayPairSum(new int[]{1, 4, 3, 2}));
        System.out.println(solution.arrayPairSum(new int[]{6, 2, 6, 5, 1, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，要让最终结果尽可能大，取值的时候就要尽可能大，如果排序后是n1,n2...nX，那么取的应该是n1,n3,nX-1
        public int arrayPairSum(int[] nums) {
            int ans = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i += 2) {
                ans += nums[i];
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}