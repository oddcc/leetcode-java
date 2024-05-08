// 剑指 Offer 11&&xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof

package com.oddcc.leetcode.editor.cn;

public class XuanZhuanShuZuDeZuiXiaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
        System.out.println(solution.minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(solution.minArray(new int[]{2, 2, 2, 0, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，原本数组是递增的，旋转过后，数组分成两部分，每一部分依然是非严格递增的，但在连接的地方是不符合递增的
        // 因为旋转是把开始的元素搬到末尾；所以非递增的第一个数就是就是最小的数
        public int minArray(int[] numbers) {
            int ans = numbers[0]; // 如果数组只有一个元素，则这个元素就是答案
            Integer pre = null;
            for (int i : numbers) {
                if (pre == null) {
                    pre = i;
                    continue;
                }
                if (i < pre) {
                    ans = i;
                    break;
                }
                pre = i;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}