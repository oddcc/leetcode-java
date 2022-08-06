// 1408

package com.oddcc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringMatchingInAnArray {
    public static void main(String[] args) {
        Solution solution = new StringMatchingInAnArray().new Solution();
        System.out.println(solution.stringMatching(new String[]{"mass", "as", "hero", "superhero"}));
        System.out.println(solution.stringMatching(new String[]{"leetcode", "et", "code"}));
        System.out.println(solution.stringMatching(new String[]{"blue", "green", "bu"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> stringMatching(String[] words) {
            Set<String> ans = new HashSet<>();
            for (String w1 : words) {
                for (String w2 : words) {
                    if (w1.equals(w2)) continue;
                    if (w1.contains(w2)) {
                        ans.add(w2);
                    }
                }
            }
            return new ArrayList<>(ans);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}