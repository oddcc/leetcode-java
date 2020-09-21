//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one
// sorted array. 
//
// Note: 
//
// 
// The number of elements initialized in nums1 and nums2 are m and n respectivel
//y. 
// You may assume that nums1 has enough space (size that is equal to m + n) to h
//old additional elements from nums2. 
// 
//
// Example: 
//
// 
//Input:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//Output: [1,2,2,3,5,6]
// 
//
// 
// Constraints: 
//
// 
// -10^9 <= nums1[i], nums2[i] <= 10^9 
// nums1.length == m + n 
// nums2.length == n 
// 
// Related Topics 数组 双指针 
// 👍 629 👎 0


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
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // 类似归并排序，但是要从大到小排序，这样才可以利用开始为0的那些空间
            int p1 = m - 1;
            int p2 = n - 1;
            int insert = m + n - 1;
            while (p1 >= 0 || p2 >= 0) {
                if (p1 < 0) {
                    nums1[insert] = nums2[p2];
                    p2--;
                    insert--;
                    continue;
                }
                if (p2 < 0) {
                    nums1[insert] = nums1[p1];
                    p1--;
                    insert--;
                    continue;
                }
                if (nums1[p1] > nums2[p2]) {
                    nums1[insert] = nums1[p1];
                    p1--;
                }
                else {
                    nums1[insert] = nums2[p2];
                    p2--;
                }
                insert--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}