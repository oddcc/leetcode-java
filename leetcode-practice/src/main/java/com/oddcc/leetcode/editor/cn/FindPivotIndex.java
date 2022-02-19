// 724

package com.oddcc.leetcode.editor.cn;

public class FindPivotIndex {
    public static void main(String[] args) {
        Solution solution = new FindPivotIndex().new Solution();
        System.out.println(solution.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(solution.pivotIndex(new int[]{1, 2, 3}));
        System.out.println(solution.pivotIndex(new int[]{-1, -1, -1, 0, 1, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，计算前缀和数组pre，然后遍历这个pre数组，我们找的就是满足pre[len - 1] - pre[i] == pre[i - 1]的i的位置，其中len是数组长度
        public int pivotIndex(int[] nums) {
            int len = nums.length;
            int[] pre = new int[len];
            int p = 0;
            for (int i = 0; i < len; i++) {
                p += nums[i];
                pre[i] = p;
            }
            for (int i = 0; i < len; i++) {
                int i1 = pre[len - 1] - pre[i];
                if (i == 0) {
                    if (i1 == 0) return i; // 涉及到前缀和的问题，一定要注意i == 0的情况，这个值一般都要特殊处理
                }
                else {
                    if (i1 == pre[i - 1]) return i;
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}