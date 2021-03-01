// 303

package com.oddcc.leetcode.editor.cn;

public class RangeSumQueryImmutable {
    public static void main(String[] args) {
        RangeSumQueryImmutable obj = new RangeSumQueryImmutable();
        obj.test();
    }

    private void test() {
        NumArray t = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(t.sumRange(0, 2));
        System.out.println(t.sumRange(2, 5));
        System.out.println(t.sumRange(0, 5));
        System.out.println(t.sumRange(0, 0));
        System.out.println(t.sumRange(5, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        // 数组用构造函数建立后，就没有修改操作了
        // 求子数组和的需求可以用前缀和数组完成
        private int[] preSum;

        // 构建前缀和数组
        public NumArray(int[] nums) {
            int len = nums.length;
            int[] pre = new int[len];
            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    pre[i] = nums[i];
                }
                else {
                    pre[i] = pre[i - 1] + nums[i];
                }
            }
            this.preSum = pre;
        }

        public int sumRange(int i, int j) {
            return preSum[j] - (i - 1 >= 0 ? preSum[i - 1] : 0);
        }
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}