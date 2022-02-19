// 88
package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        int[] n1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] n2 = new int[]{2, 5, 6};
        solution.merge(n1, 3, n2, 3);
        System.out.println(Arrays.toString(n1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，类似归并排序合并两个数组，但不能从小到大合并，因为nums1后半部分是0，所以可以从大到小进行合并
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1;
            int p2 = n - 1;
            int i = nums1.length - 1;
            while (i >= 0) {
                int n1 = p1 >= 0 ? nums1[p1] : Integer.MIN_VALUE;
                int n2 = p2 >= 0 ? nums2[p2] : Integer.MIN_VALUE;
                if (n1 >= n2) {
                    nums1[i] = n1;
                    p1--;
                }
                else {
                    nums1[i] = nums2[p2];
                    p2--;
                }
                i--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}