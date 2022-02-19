// 45

package com.oddcc.leetcode.editor.cn;

public class JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
        System.out.println(solution.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution.jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(solution.jump(new int[]{0}));
        System.out.println(solution.jump(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 贪心
    class Solution {
        public int jump(int[] nums) {
            // 需要特殊处理，当只有一个数字时，不用移动就可以完成
            if (nums.length == 1) {
                return 0;
            }

            int steps = 0;
            int farthestWeCanReach = 0; // 不限步数，目前知道能到达的最远位置；观察可知，这里能得到的，一定是到达当前位置后，再跳一步所能达到的位置
            int farthestWeCanReachInThisStep = 0; // 当前步数下，能到达的最远位置
            // 遍历的时候，遍历到了，就说明当前位置已经可以到达了
            for (int i = 0; i < nums.length; i++) {
                // 如果发现了能到达更远的位置，就更新
                farthestWeCanReach = Math.max(farthestWeCanReach, nums[i] + i);
                // 如果最远位置超过了终点，说明从当前位置可以到达，只需要再跳一次
                if (farthestWeCanReach >= nums.length - 1) {
                    steps++;
                    break;
                }
                // farthestWeCanReachInThisStep是这一步能到达的最远位置，当条件满足时，再后面的位置，在这一步就到不了了
                // 所以要+1，然后把能到达的最远位置当作下一步的最远位置
                if (farthestWeCanReachInThisStep == i) {
                    steps++;
                    farthestWeCanReachInThisStep = farthestWeCanReach;
                }
            }

            return steps;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}