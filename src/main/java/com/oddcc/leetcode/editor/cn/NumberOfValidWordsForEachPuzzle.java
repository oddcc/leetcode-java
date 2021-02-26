// 1178

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class NumberOfValidWordsForEachPuzzle {
    public static void main(String[] args) {
        Solution solution = new NumberOfValidWordsForEachPuzzle().new Solution();
        System.out.println(
                solution.findNumOfValidWords(
                        new String[]{"aaaa", "asas", "able", "ability", "actt", "actor", "access"},
                        new String[]{"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"})
        );
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，暴力法，如果puzzle[i]，words[i]对应setP和setW，那么可以通过1次setW.contains()和setW.size次setP.contains()来确定一个word是不是可用
        // 构建所有集合的复杂度大概是O(words.length*max(words[i].length))，之后每次比较的复杂度大概是O(words[i].length * words.length * puzzles.length)
        // 要知道所有words和puzzles的情况，扫描数据是无法避免的，问题在于每次比较的时候，使用set效率太低了
        // 思路2，状态压缩，"ab" -> 11，字符串只含有小写英文字母，可以被压缩成一个最长26位的二进制数字
        // 压缩后的二进制数字包含的信息是，有哪些字母出现过，不同的字符串可能被压缩成相同的数字，如"aaaab" -> 11
        // 但由于word匹配puzzle规则的第二条只要出现信息就足够了，所以压缩是没有问题的
        // 可以把压缩后的数字作为key，把数字的出现次数作为value放入map中，这样就可以以O(1)的时间复杂度查到某个出现过的字母集合的word的个数
        // 如果我们有puzzle p = "abcdefg" ，用同样的方式压缩，可以得到 1111111，其中111111[1]最低位的1是必须出现的（表示字母a），剩余的6位可以出现，也可以不出现
        // 比如有word w1 = "aaaa" -> 1，当p的后6位都不出现时，用1去匹配，就可以匹配到w1
        // 再比如有word w2 = "ab" -> 11, 当p的前两位出现时，用11去匹配，就可以匹配到w2
        // 所以我们用这种方式从puzzles出发去匹配words，遍历完成时，就得到了答案
        public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
            Map<Integer, Integer> wordBitsMap = new HashMap<>();
            for (String word : words) {
                Integer key = convertToBits(word);
                System.out.println(word + " -> " + Integer.toBinaryString(key));
                wordBitsMap.put(key, wordBitsMap.getOrDefault(key, 0) + 1);
            }
            List<Integer> ans = new ArrayList<>();
            for (String puzzle : puzzles) {
                ans.add(countForPuzzle(puzzle, wordBitsMap));
            }
            return ans;
        }

        private Integer countForPuzzle(String puzzle, Map<Integer, Integer> wordBitsMap) {
            List<List<Character>> optionSet = getSubSet(puzzle.substring(1));
            char first = puzzle.toCharArray()[0];
            int count = 0;
            for (List<Character> option : optionSet) {
                int[] bitArray = new int[26];
                bitArray[first - 'a'] = 1;
                for (Character c : option) {
                    bitArray[c - 'a'] = 1;
                }
                int key = bitArrayToInt(bitArray);
                count += wordBitsMap.getOrDefault(key, 0);
            }
            return count;
        }

        private List<List<Character>> getSubSet(String str) {
            List<List<Character>> ans = new ArrayList<>();
            dfs(str, ans, 0, new ArrayList<>());
            return ans;
        }

        private void dfs(String str, List<List<Character>> ans, int i, List<Character> path) {
            if (i == str.length()) {
                ans.add(new ArrayList<>(path));
                return;
            }
            path.add(str.charAt(i));
            dfs(str, ans, i + 1, path);
            path.remove(path.size() - 1);
            dfs(str, ans, i + 1, path);
        }

        private Integer convertToBits(String word) {
            int[] bitArray = new int[26];
            for (char c : word.toCharArray()) {
                bitArray[c - 'a'] = 1;
            }
            return bitArrayToInt(bitArray);
        }

        private Integer bitArrayToInt(int[] bitArray) {
            int r = 0;
            int tmp = 1;
            for (int j : bitArray) {
                r += j * tmp;
                tmp *= 2;
            }
            return r;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}