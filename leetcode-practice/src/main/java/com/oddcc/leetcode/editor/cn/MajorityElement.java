// 169


package com.oddcc.leetcode.editor.cn;

public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
        System.out.println(solution.majorityElement(new int[]{3, 2, 3}));
        System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 3}));
        System.out.println(solution.majorityElement(new int[]{2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，暴力计数法，时间复杂度O(n)空间复杂度O(n)
        // 思路2，先排序，再遍历计数，如果碰到了可以提前返回，时间复杂度O(n)空间复杂度O(1)
        // 思路3，先排序，然后直接返回，数组⌊ n/2 ⌋位置的数必定是结果，就好像一个滑动窗口
        // 思路4，分治，如果设命题L是数字x在左半边是众数，命题R是数字x在右半边是众数，那么可以有
        // !L && !R = False 即一个数如果在左边不是众数，在右边也不是众数，那么这个数就不是整个数组的众数
        // !(L || R) = False
        // L || R = True 可以推出，如果一个数在左边或在右边是众数，那么这个数就是整个数组的众数（题目说了众数一定存在）
        // 当左右两边众数相同时，这个数就是答案
        // 当左右两边众数不同时，需要遍历数组，确定哪一个才是答案
        public int majorityElement(int[] nums) {
            return findMajority(0, nums.length, nums);
        }

        // start include, end exclude
        private int findMajority(int start, int end, int[] nums) {
            if (start + 1 >= end) return nums[start];
            int mid = start + (end - start) / 2;
            int left = findMajority(start, mid, nums);
            int right = findMajority(mid, end, nums);
            if (left == right) return left;
            int leftCount = 0;
            int rightCount = 0;
            for (int i : nums) {
                if (i == left) leftCount++;
                if (i == right) rightCount++;
            }
            return leftCount > rightCount ? left : right;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}