# LeetCode Java Practices
LeetCode练习记录，JDK版本是11

可以通过题目名称的大驼峰来搜索，也可以通过题号来搜索，大体思路一般会在commit message里面，详细的思路一般会在注释中

项目拉下来直接导入IntelliJ IDEA就可以了，每道题都可以单独运行，已经带了一部分常见的测试用例



另外如果你也用IDEA刷题的话，推荐一下这个[插件](https://plugins.jetbrains.com/plugin/12132-leetcode-editor) ，非常好用

我的习惯配置如下：

PS：插件查看题目会连tag一起展示出来，这其实是个不小的提示，可以考虑不用这个插件功能

关于`TempFilePath`，对于我的包`com.oddcc.leetcode.editor.cn`来说，路径应该是`/Users/oddcc/Documents/Study/LeetCode/leetcode-practice/src/main/java/com/oddcc`，即从`leetcode`开始，后面是插件默认的包结构。这里应该根据个人需要进行修改

CodeFileName： `$!velocityTool.camelCaseName(${question.titleSlug})`

CodeTemplate：

```java
// ${question.frontendQuestionId}

package com.oddcc.leetcode.editor.cn;
public class $!velocityTool.camelCaseName(${question.titleSlug}){
  public static void main(String[] args) {
       Solution solution = new $!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
  }
  ${question.code}
}
```



PS：

推荐一些工具，方便做题的时候理解

图相关：

1. [graph_editor](https://csacademy.com/app/graph_editor) ， 可以根据“边”来构造图，有向图无向图都可以，在测试用例太大，你自己画不出来的时候可以用这个，方便找问题
2. [graphonline.ru](https://graphonline.ru/en/?graph=Planar) ，除了手画之外，构造图不是很方便，但内置了多种算法演示，如果你能把图画出来，在上面演示非常方便，不理解算法中某一步的时候用


<!--question list generated below here, don't DELETE this line-->
### 目前已有69道题，不断添加中…
|ID|标题|难度|CODE|
| ---- | ---- | ---- | ---- |
|[2](https://leetcode-cn.com/problems/add-two-numbers)|Add Two Numbers|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/AddTwoNumbers.java)|
|[3](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters)|Longest Substring Without Repeating Characters|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LongestSubstringWithoutRepeatingCharacters.java)|
|[5](https://leetcode-cn.com/problems/longest-palindromic-substring)|Longest Palindromic Substring|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LongestPalindromicSubstring.java)|
|[6](https://leetcode-cn.com/problems/zigzag-conversion)|ZigZag Conversion|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ZigzagConversion.java)|
|[7](https://leetcode-cn.com/problems/reverse-integer)|Reverse Integer|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ReverseInteger.java)|
|[8](https://leetcode-cn.com/problems/string-to-integer-atoi)|String to Integer (atoi)|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/StringToIntegerAtoi.java)|
|[12](https://leetcode-cn.com/problems/integer-to-roman)|Integer to Roman|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/IntegerToRoman.java)|
|[13](https://leetcode-cn.com/problems/roman-to-integer)|Roman to Integer|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RomanToInteger.java)|
|[15](https://leetcode-cn.com/problems/3sum)|3Sum|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ThreeSum.java)|
|[17](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number)|Letter Combinations of a Phone Number|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LetterCombinationsOfAPhoneNumber.java)|
|[18](https://leetcode-cn.com/problems/4sum)|4Sum|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FourSum.java)|
|[19](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list)|Remove Nth Node From End of List|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RemoveNthNodeFromEndOfList.java)|
|[21](https://leetcode-cn.com/problems/merge-two-sorted-lists)|Merge Two Sorted Lists|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MergeTwoSortedLists.java)|
|[22](https://leetcode-cn.com/problems/generate-parentheses)|Generate Parentheses|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/GenerateParentheses.java)|
|[24](https://leetcode-cn.com/problems/swap-nodes-in-pairs)|Swap Nodes in Pairs|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SwapNodesInPairs.java)|
|[26](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array)|Remove Duplicates from Sorted Array|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RemoveDuplicatesFromSortedArray.java)|
|[27](https://leetcode-cn.com/problems/remove-element)|Remove Element|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RemoveElement.java)|
|[28](https://leetcode-cn.com/problems/implement-strstr)|Implement strStr()|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ImplementStrstr.java)|
|[30](https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words)|Substring with Concatenation of All Words|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SubstringWithConcatenationOfAllWords.java)|
|[31](https://leetcode-cn.com/problems/next-permutation)|Next Permutation|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/NextPermutation.java)|
|[33](https://leetcode-cn.com/problems/search-in-rotated-sorted-array)|Search in Rotated Sorted Array|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SearchInRotatedSortedArray.java)|
|[34](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array)|Find First and Last Position of Element in Sorted Array|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FindFirstAndLastPositionOfElementInSortedArray.java)|
|[35](https://leetcode-cn.com/problems/search-insert-position)|Search Insert Position|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SearchInsertPosition.java)|
|[36](https://leetcode-cn.com/problems/valid-sudoku)|Valid Sudoku|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ValidSudoku.java)|
|[38](https://leetcode-cn.com/problems/count-and-say)|Count and Say|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CountAndSay.java)|
|[39](https://leetcode-cn.com/problems/combination-sum)|Combination Sum|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CombinationSum.java)|
|[41](https://leetcode-cn.com/problems/first-missing-positive)|First Missing Positive|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FirstMissingPositive.java)|
|[42](https://leetcode-cn.com/problems/trapping-rain-water)|Trapping Rain Water|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/TrappingRainWater.java)|
|[45](https://leetcode-cn.com/problems/jump-game-ii)|Jump Game II|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/JumpGameIi.java)|
|[46](https://leetcode-cn.com/problems/permutations)|Permutations|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/Permutations.java)|
|[48](https://leetcode-cn.com/problems/rotate-image)|Rotate Image|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RotateImage.java)|
|[49](https://leetcode-cn.com/problems/group-anagrams)|Group Anagrams|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/GroupAnagrams.java)|
|[53](https://leetcode-cn.com/problems/maximum-subarray)|Maximum Subarray|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaximumSubarray.java)|
|[54](https://leetcode-cn.com/problems/spiral-matrix)|Spiral Matrix|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SpiralMatrix.java)|
|[55](https://leetcode-cn.com/problems/jump-game)|Jump Game|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/JumpGame.java)|
|[56](https://leetcode-cn.com/problems/merge-intervals)|Merge Intervals|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MergeIntervals.java)|
|[58](https://leetcode-cn.com/problems/length-of-last-word)|Length of Last Word|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LengthOfLastWord.java)|
|[59](https://leetcode-cn.com/problems/spiral-matrix-ii)|Spiral Matrix II|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SpiralMatrixIi.java)|
|[61](https://leetcode-cn.com/problems/rotate-list)|Rotate List|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RotateList.java)|
|[62](https://leetcode-cn.com/problems/unique-paths)|Unique Paths|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/UniquePaths.java)|
|[64](https://leetcode-cn.com/problems/minimum-path-sum)|Minimum Path Sum|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MinimumPathSum.java)|
|[65](https://leetcode-cn.com/problems/valid-number)|Valid Number|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ValidNumber.java)|
|[66](https://leetcode-cn.com/problems/plus-one)|Plus One|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PlusOne.java)|
|[67](https://leetcode-cn.com/problems/add-binary)|Add Binary|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/AddBinary.java)|
|[68](https://leetcode-cn.com/problems/text-justification)|Text Justification|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/TextJustification.java)|
|[69](https://leetcode-cn.com/problems/sqrtx)|Sqrt(x)|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/Sqrtx.java)|
|[70](https://leetcode-cn.com/problems/climbing-stairs)|Climbing Stairs|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ClimbingStairs.java)|
|[71](https://leetcode-cn.com/problems/simplify-path)|Simplify Path|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SimplifyPath.java)|
|[73](https://leetcode-cn.com/problems/set-matrix-zeroes)|Set Matrix Zeroes|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SetMatrixZeroes.java)|
|[74](https://leetcode-cn.com/problems/search-a-2d-matrix)|Search a 2D Matrix|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SearchA2dMatrix.java)|
|[75](https://leetcode-cn.com/problems/sort-colors)|Sort Colors|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SortColors.java)|
|[78](https://leetcode-cn.com/problems/subsets)|Subsets|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/Subsets.java)|
|[79](https://leetcode-cn.com/problems/word-search)|Word Search|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/WordSearch.java)|
|[80](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii)|Remove Duplicates from Sorted Array II|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RemoveDuplicatesFromSortedArrayIi.java)|
|[81](https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii)|Search in Rotated Sorted Array II|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SearchInRotatedSortedArrayIi.java)|
|[82](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii)|Remove Duplicates from Sorted List II|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RemoveDuplicatesFromSortedListIi.java)|
|[83](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list)|Remove Duplicates from Sorted List|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RemoveDuplicatesFromSortedList.java)|
|[84](https://leetcode-cn.com/problems/largest-rectangle-in-histogram)|Largest Rectangle in Histogram|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LargestRectangleInHistogram.java)|
|[87](https://leetcode-cn.com/problems/scramble-string)|Scramble String|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ScrambleString.java)|
|[88](https://leetcode-cn.com/problems/merge-sorted-array)|Merge Sorted Array|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MergeSortedArray.java)|
|[89](https://leetcode-cn.com/problems/gray-code)|Gray Code|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/GrayCode.java)|
|[90](https://leetcode-cn.com/problems/subsets-ii)|Subsets II|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SubsetsIi.java)|
|[91](https://leetcode-cn.com/problems/decode-ways)|Decode Ways|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DecodeWays.java)|
|[92](https://leetcode-cn.com/problems/reverse-linked-list-ii)|Reverse Linked List II|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ReverseLinkedListIi.java)|
|[94](https://leetcode-cn.com/problems/binary-tree-inorder-traversal)|Binary Tree Inorder Traversal|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BinaryTreeInorderTraversal.java)|
|[96](https://leetcode-cn.com/problems/unique-binary-search-trees)|Unique Binary Search Trees|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/UniqueBinarySearchTrees.java)|
|[97](https://leetcode-cn.com/problems/interleaving-string)|Interleaving String|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/InterleavingString.java)|
|[98](https://leetcode-cn.com/problems/validate-binary-search-tree)|Validate Binary Search Tree|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ValidateBinarySearchTree.java)|
|[100](https://leetcode-cn.com/problems/same-tree)|Same Tree|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SameTree.java)|
