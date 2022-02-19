// 331

package com.oddcc.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class VerifyPreorderSerializationOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new VerifyPreorderSerializationOfABinaryTree().new Solution();
        System.out.println(solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(solution.isValidSerialization("1,#"));
        System.out.println(solution.isValidSerialization("9,#,#,1"));
        System.out.println(solution.isValidSerialization("1,#,#,#,#"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 要求是pre-order，也就是根左右
        // 要求不能用重新生成二叉树的方法
        // 只判断是还是否
        // 思路1，利用栈，遍历时合并已确定是树的节点，把已确定是树的节点标记为#
        public boolean isValidSerialization(String preorder) {
            Deque<String> stack = new LinkedList<>();
            String[] strs = preorder.split(",");
            int hashMarkCount = 0;
            for (int i = strs.length - 1; i >= 0; i--) {
                String s = strs[i];
                if (s.equals("#")) {
                    stack.push(s);
                    hashMarkCount++;
                }
                else {
                    if (hashMarkCount >= 2) {
                        stack.pop();
                        hashMarkCount--;
                        stack.pop();
                        hashMarkCount--;
                        stack.push("#");
                        hashMarkCount++;
                    }
                    else {
                        return false;
                    }
                }
            }
            return stack.size() == 1 && stack.peek().equals("#");
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}