package com.oddcc.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {
    public static void main(String[] args) {
        Solution solution = new FindCommonCharacters().new Solution();
        System.out.println(solution.commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(solution.commonChars(new String[]{"cool", "lock", "cook"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 生成结果需要知道两个信息：1，字符是否在所有字符串中都出现过；2，在所有字符串中出现的最小次数是多少（不包括0）
        public List<String> commonChars(String[] A) {
            // 0-出现在几个字符串中，1-截止目前，在单个字符串中出现的最小次数，2-在本字符串中出现几次
            int[][] count = new int['z' - 'a' + 1][3];
            for (int[] arr : count) {
                Arrays.fill(arr, 0);
            }
            for (int i = 0; i < A.length; i++) {
                for (char c : A[i].toCharArray()) {
                    int charIndex = c - 'a';
                    // 记录出现在几个字符串中
                    if (count[charIndex][0] == i) {
                        count[charIndex][0]++;
                    }
                    count[charIndex][2]++;
                }
                // 记录单字符串中最小出现次数，本字符串中出现次数归零
                for (int[] arr : count) {
                    if (i == 0) {
                        arr[1] = arr[2];
                    }
                    if (arr[1] > 0) {
                        if (arr[2] < arr[1]) {
                            arr[1] = arr[2];
                        }
                    }
                    arr[2] = 0;
                }
            }
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < count.length; i++) {
                if (count[i][0] == A.length) {
                    for (int j = 0; j < count[i][1]; j++) {
                        ans.add(String.valueOf((char) ('a' + i)));
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}