// 30

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
        System.out.println(solution.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
        System.out.println(solution.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
        System.out.println(solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
        System.out.println(solution.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo", "barr", "wing", "ding", "wing"}));
        System.out.println(solution.findSubstring("aaaaaaaa", new String[]{"a", "a"}));
        System.out.println(solution.findSubstring("ababababab", new String[]{"ababa", "babab"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路1,双指针
    class Solution {
        public List findSubstring(String s, String[] words) {
            int wordLen = words[0].length();
            int wordsLen = words.length;
            int sLen = s.length();
            int left = 0;
            List<Integer> ans = new ArrayList<>();
            Map<String, Integer> wordsCountMap = new HashMap<String, Integer>() {{
                for (String word : words) {
                    this.put(word, this.getOrDefault(word, 0) + 1);
                }
            }};
            Map<String, Integer> seenMap = new HashMap<>();
            int seenCount = 0;
            // 每次迭代,尝试找出一个符合题意的子串
            while (left < sLen) {
                // 依靠right来取词
                int right = left + wordLen;
                if (right > sLen) break;
                // 每次都是从left开始重新判断，所以辅助的数据结构要初始化
                seenMap = new HashMap<>();
                seenCount = 0;
                while (right <= sLen) {
                    String newWord = s.substring(right - wordLen, right);
                    // 如果取到的词满足下面两种情况之一，那么说明当前left为起点不满足题意，因为题目要求每个word出现一次，且没有其他字符
                    // words里面没有当前词
                    // words里有当前词，但数量超过了应该有的数量
                    if (
                            !wordsCountMap.containsKey(newWord) ||
                                    (seenMap.getOrDefault(newWord, 0) >= wordsCountMap.get(newWord))
                    ) {
                        break;
                    }
                    seenMap.put(newWord, seenMap.getOrDefault(newWord, 0) + 1);
                    seenCount++;
                    right += wordLen;
                    // 当有了足够的词之后，我们就找到了一个解，找到解之后，后面的字符不用看了，因为再添加任意字符都不符合题意了
                    if (seenCount == wordsLen) {
                        ans.add(left);
                        break;
                    }
                }
                // 找到解后，向后移动left
                left++;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}