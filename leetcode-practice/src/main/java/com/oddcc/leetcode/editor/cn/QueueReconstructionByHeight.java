// 406

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        Solution solution = new QueueReconstructionByHeight().new Solution();
        int[][] r1 = solution.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        System.out.println("done");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，先对原始输入进行排序，h高->低，k低->高
        // 这样排序的原因是，根据题意，k表示排在前面的h大于等于此元素的数量
        // 先处理h高的，原因是高的更加主动，高的相对位置确定了之后，不管在前面怎么插入h更低的元素，都不影响高的结果
        // 先处理k低的，原因是题目k的定义，相等的元素都k的值有影响，那么如果先处理k高的，排定了以后，加入后面出现h相同，k更小的元素，就会排在前面，导致结果出错
        // 如果先处理低的，就可以保证，当一个元素确定相对位置后，就不会再发生变动，因为之后插入的元素只能在它之后
        public int[][] reconstructQueue(int[][] people) {
            List<int[]> pList = new ArrayList<>(Arrays.asList(people));
            pList.sort((o1, o2) -> {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o2[0] - o1[0];
            });
            List<int[]> ansList = new ArrayList<>();
            for (int[] p : pList) {
                int count = 0;
                for (int[] p2 : ansList) {
                    if (count == p[1]) break;
                    if (p2[0] < p[0]) continue;
                    count++;
                }
                ansList.add(count, p);
            }
            int[][] ans = new int[ansList.size()][2];
            for (int i = 0; i < ansList.size(); i++) {
                ans[i] = ansList.get(i);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}