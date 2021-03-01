// 41

package com.oddcc.leetcode.editor.cn;

public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
        // System.out.println(solution.firstMissingPositive(new int[]{1, 2, 0}));
        // System.out.println(solution.firstMissingPositive(new int[]{3, 4, -1, 1}));
        // System.out.println(solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println(solution.firstMissingPositive(new int[]{1, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，哈希表+两次遍历，建立哈希表，如果值是负数或0则忽略，如果是正数则存下来
        // 然后从1开始查找，如果遇到哈希表中不存在的值，就是答案；因为题目提到0 <= nums.length <= 300，所以这种方式是能ac的
        // 但其实题目要求时间复杂度O(N)，空间复杂度O(1)，思路1的空间复杂度是不符合的
        // 思路2，我们其实只用关心[1,N+1]这个区间内的数，答案一定出现在这个区间内，这里N是nums的长度
        // 我们可以用nums数组本身来存储[1,N]分别存储在[0,N-1]的位置上，如果对应的位置有对应的数，就说明这个数字在nums中出现了
        // 然后我们再第二次遍历nums数组，如果碰到跟位置不符的数，则这个位置上本来应该存的就是答案
        // 如果遍历完成了都没找到答案，则答案就是N+1
        // 在第一次遍历的过程中，不能直接覆盖存储，否则还没遍历到的数据可能丢失，应采用交换的方式，直到所有可放到正确位置上的数都已交换完毕
        public int firstMissingPositive(int[] nums) {
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                while (nums[i] >= 1 && nums[i] <= len && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                    swap(nums, i, nums[i] - 1);
                }
            }
            for (int i = 0; i < len; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            return len + 1;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}