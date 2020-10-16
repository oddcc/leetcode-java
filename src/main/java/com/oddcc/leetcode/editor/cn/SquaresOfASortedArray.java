package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();
//        System.out.println(Arrays.toString(solution.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
//        System.out.println(Arrays.toString(solution.sortedSquares(new int[]{-7, -3, 2, 3, 11})));
//        System.out.println(Arrays.toString(solution.sortedSquares(new int[]{-7, -3, -3, -3, -3})));
        System.out.println(Arrays.toString(solution.sortedSquares(new int[]{1, 2, 3, 4, 5})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，暴力法，直接计算平方，然后排序
        // 思路2，一次遍历，两个指针，指针A指向负数，指针B指向>=0的最小值，每次插入一个新值时，比较A、B指针指向的数的绝对值，选用绝对值小的值插入，然后移动对应指针
        // 初始时用二分查找查>=0的最小值B，B-1就是A
        public int[] sortedSquares(int[] A) {
            int len = A.length;
            if (len == 0) return new int[0];
            if (len == 1) return new int[]{(int) Math.pow(A[0], 2)};
            int a = findFirstNoNegative(A, 0, len - 1, 0);
            int b;
            // 如果a==-1，说明整个数组都是负数，b要特别处理
            if (a == -1) {
                b = len - 1;
            }
            else {
                b = a - 1;
            }
            int[] ans = new int[len];
            // 一个有len个数要处理
            for (int i = 0; i < len; i++) {
                int absA = valid(a, A) ? Math.abs(A[a]) : Integer.MAX_VALUE;
                int absB = valid(b, A) ? Math.abs(A[b]) : Integer.MAX_VALUE;
                if (absA < absB) {
                    ans[i] = absA * absA;
                    a++;
                }
                else {
                    ans[i] = absB * absB;
                    b--;
                }
            }
            return ans;
        }

        private int findFirstNoNegative(int[] nums, int low, int high, int target) {
            if (low >= high) {
                if (nums[low] >= target) {
                    return low;
                }
                return -1;
            }
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                if (valid(mid - 1, nums)) {
                    if (nums[mid - 1] >= target) {
                        return findFirstNoNegative(nums, low, mid - 1, target);
                    }
                }
                return mid;
            }
            else {
                if (valid(mid + 1, nums)) {
                    if (nums[mid + 1] >= target) {
                        return mid + 1;
                    }
                }
                return findFirstNoNegative(nums, mid + 1, high, target);
            }
        }

        private boolean valid(int a, int[] nums) {
            return a >= 0 && a < nums.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}