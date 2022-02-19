// 96
package com.oddcc.leetcode.editor.cn;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
        System.out.println(solution.numTrees(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 给定一个根节点，可以把问题划分为两个子问题，即如何用剩下的元素，在左边\右边构建BST；可以按这个思路不断拆分
        public int numTrees(int n) {
            int[] db = new int[n];
            return nums(n, db);
        }

        private int nums(int n, int[] db) {
            if (n == 0) return 1; // 有0个点时，只有一种放法
            if (n == 1) return 1; // 有1个点时，只有一种放法
            if (n == 2) return 2; // 有2个点时，只有两种放法，根-左；根-右
            int sum = 0;
            // 当n为3时，结果应该是nums(0)*nums(2) + nums(1)*nums(1) + nums(2)*nums(0)
            // 为什么是相乘？因为左右子树的形状不一样，最终形状就不一样，而左右子树是相互独立的
            // 为什么是0-2，1-1，2-0这样的组合？因为当前根节点占了1个节点，剩下最多两个节点，两个节点在左右子树之间分配，就是这三种分配方式；n继续增大的话也是同理
            for (int i = 0; i < n; i++) {
                if (db[n - i - 1] == 0) {
                    db[n - i - 1] = nums(n - i - 1, db);
                }
                if (db[i] == 0) {
                    db[i] = nums(i, db);
                }
                sum += db[n - i - 1] * db[i];
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}