// 852

package com.oddcc.leetcode.editor.cn;

public class PeakIndexInAMountainArray {
    public static void main(String[] args) {
        Solution solution = new PeakIndexInAMountainArray().new Solution();
        System.out.println(solution.peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{3, 4, 5, 1}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1，直接遍历找max，O(n)
    // 思路2，二分查找
    // 通过对比当前值和后一个值，可以区分在区间的哪个位置，如果arr[i] < arr[i+1]，说明在前半部分，答案应该在arr[i+1]之后（包含）
    // 如果arr[i] > arr[i+1]，说明i在后半部分，答案应该在arr[i]之前（包含）
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            return searchMax(0, arr.length - 1, arr);
        }

        private int searchMax(int left, int right, int[] arr) {
            if (left >= right) return left;
            int mid = (right - left) / 2 + left;
            if (arr[mid] < arr[mid + 1]) {
                return searchMax(mid + 1, right, arr);
            }
            else {
                return searchMax(left, mid, arr);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}