// 763
package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        Solution solution = new PartitionLabels().new Solution();
        System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(solution.partitionLabels("caedbdedda"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路是找到当前字母开始出现的位置start和最后出现的位置end，分段至少要包含 start和end
        // 从start开始向后遍历，每次遇到一个字母，如果end大于已有的end，就要扩充end的范围，直到和end相遇，说明访问过的所有字母，都在start～end的范围内了，这样才能确定一个分段
        public List<Integer> partitionLabels(String S) {
            List<Integer> ans = new ArrayList<>();
            int start = 0;
            int end = 0;
            int current = 0;
            // 处理完左右字符后结束
            while (current <= S.length() - 1) {
                char c = S.charAt(current);
                end = Math.max(end, S.lastIndexOf(c));
                if (current == end) {
                    ans.add(end - start + 1);
                    start = end + 1;
                    current = start;
                    end = start;
                }
                else {
                    current++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}