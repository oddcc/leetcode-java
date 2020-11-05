package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        Solution solution = new WordLadder().new Solution();
        System.out.println(solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
        System.out.println(solution.ladderLength("a", "c", Arrays.asList("a", "b", "c")));
        System.out.println(solution.ladderLength("hot", "dog", Arrays.asList("hot", "dog")));
        System.out.println(solution.ladderLength("hot", "dog", Arrays.asList("hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 由题目要求最短路径想到BFS
        // 选跟start相差1个字符的进行搜索，选中的字符作为下一次搜索的起点，直到start跟end只相差1个字符
        // 搜索过程中也记录可能中是否有end，如果没有的话，可以提前return
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) return 0;
            int ans = 0;
            Queue<String> beginWords = new LinkedList<>();
            Queue<List<String>> optionWords = new LinkedList<>();
            beginWords.add(beginWord);
            optionWords.add(wordList);
            // beginWords还有，说明还可以继续搜索
            while (!beginWords.isEmpty()) {
//                System.out.println("************");
                // 用于存放下一层的beginWords和optionWords
                Queue<String> bList = new LinkedList<>();
                Queue<List<String>> oList = new LinkedList<>();
//                System.out.println(beginWords);
//                System.out.println(optionWords);
//                System.out.println("=====");
                while (!beginWords.isEmpty()) {
                    String begin = beginWords.remove();
                    List<String> options = optionWords.remove();
                    // 如果begin和end只相差一位，说明找到结果了，直接返回，要把这一层加上去
                    if (differentCount(begin, endWord) == 1) {
                        ans++;
                        return ans + 1;
                    }
                    // 遍历每个选项，如果有跟begin差一位的，说明还能继续进行搜索，放入下一层的搜索集
                    for (String w : options) {
                        if (differentCount(w, begin) == 1) {
                            bList.add(w);
                            oList.add(getOptions(w, options));
                        }
                    }
                }
                ans++;
                beginWords = bList;
                optionWords = oList;
            }
            return 0; // 如果有结果，总应该出现在上方循环内
        }

        private List<String> getOptions(String word, List<String> wordList) {
            List<String> copy = new ArrayList<>(wordList);
            copy.remove(word);
            return copy;
        }

        // w1和w2的长度总是相同
        private int differentCount(String w1, String w2) {
            if (w1.equals(w2)) return 0;
            int count = 0;
            for (int i = 0; i < w1.length(); i++) {
                if (w1.charAt(i) != w2.charAt(i)) count++;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}