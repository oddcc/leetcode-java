// 剑指 Offer 03&&shu-zu-zhong-zhong-fu-de-shu-zi-lcof
package com.oddcc.leetcode.editor.cn;

public class ShuZuZhongZhongFuDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongZhongFuDeShuZiLcof().new Solution();
        System.out.println(solution.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内；利用这一点可以得到一个长度为n的哈希表
        public int findRepeatNumber(int[] nums) {
            int[] cache = new int[nums.length];
            int ans = -1;
            for (int i = 0; i < nums.length; i++) {
                if (cache[nums[i]] == 0) {
                    cache[nums[i]]++;
                }
                else {
                    ans = nums[i];
                    break;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}