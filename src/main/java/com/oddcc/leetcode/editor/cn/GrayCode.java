// 89

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class GrayCode {
    public static void main(String[] args) {
        Solution solution = new GrayCode().new Solution();
        // System.out.println(solution.grayCode(2));
        // System.out.println(solution.grayCode(1));
        System.out.println(solution.grayCode(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 回溯法
    class Solution {
        public List<Integer> grayCode(int n) {
            if(n == 1)
                return new ArrayList<Integer>(){{add(0);add(1);}};
            List<Integer> res = grayCode(n - 1);
            int add = 1 << (n - 1);
            for(int i=res.size()-1;i>=0;i--)
                res.add(res.get(i) + add);
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}