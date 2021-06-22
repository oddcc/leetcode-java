# LeetCode Java Practices
LeetCode练习记录，JDK版本是11

可以通过题目名称的大驼峰来搜索，也可以通过题号来搜索，大体思路一般会在commit message里面，详细的思路一般会在注释中

项目拉下来直接导入IntelliJ IDEA就可以了，每道题都可以单独运行，已经带了一部分常见的测试用例



另外如果你也用IDEA刷题的话，推荐一下这个[插件](https://plugins.jetbrains.com/plugin/12132-leetcode-editor) ，非常好用

我的习惯配置如下：

PS：插件查看题目会连tag一起展示出来，这其实是个不小的提示，可以考虑不用这个插件功能

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
### 目前已有342道题，不断添加中…
|ID|标题|难度|CODE|
| ---- | ---- | ---- | ---- |
|[2](https://leetcode-cn.com/problems/add-two-numbers)|Add Two Numbers|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/AddTwoNumbers.java)|
|[3](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters)|Longest Substring Without Repeating Characters|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LongestSubstringWithoutRepeatingCharacters.java)|
|[5](https://leetcode-cn.com/problems/longest-palindromic-substring)|Longest Palindromic Substring|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LongestPalindromicSubstring.java)|
|[6](https://leetcode-cn.com/problems/zigzag-conversion)|ZigZag Conversion|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ZigzagConversion.java)|
|[7](https://leetcode-cn.com/problems/reverse-integer)|Reverse Integer|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ReverseInteger.java)|
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
|[69](https://leetcode-cn.com/problems/sqrtx)|Sqrt(x)|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/Sqrtx.java)|
|[70](https://leetcode-cn.com/problems/climbing-stairs)|Climbing Stairs|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ClimbingStairs.java)|
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
|[90](https://leetcode-cn.com/problems/subsets-ii)|Subsets II|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SubsetsIi.java)|
|[91](https://leetcode-cn.com/problems/decode-ways)|Decode Ways|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DecodeWays.java)|
|[92](https://leetcode-cn.com/problems/reverse-linked-list-ii)|Reverse Linked List II|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ReverseLinkedListIi.java)|
|[94](https://leetcode-cn.com/problems/binary-tree-inorder-traversal)|Binary Tree Inorder Traversal|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BinaryTreeInorderTraversal.java)|
|[96](https://leetcode-cn.com/problems/unique-binary-search-trees)|Unique Binary Search Trees|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/UniqueBinarySearchTrees.java)|
|[98](https://leetcode-cn.com/problems/validate-binary-search-tree)|Validate Binary Search Tree|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ValidateBinarySearchTree.java)|
|[100](https://leetcode-cn.com/problems/same-tree)|Same Tree|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SameTree.java)|
|[101](https://leetcode-cn.com/problems/symmetric-tree)|Symmetric Tree|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SymmetricTree.java)|
|[102](https://leetcode-cn.com/problems/binary-tree-level-order-traversal)|Binary Tree Level Order Traversal|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BinaryTreeLevelOrderTraversal.java)|
|[103](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal)|Binary Tree Zigzag Level Order Traversal|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BinaryTreeZigzagLevelOrderTraversal.java)|
|[104](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree)|Maximum Depth of Binary Tree|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaximumDepthOfBinaryTree.java)|
|[107](https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii)|Binary Tree Level Order Traversal II|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BinaryTreeLevelOrderTraversalIi.java)|
|[108](https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree)|Convert Sorted Array to Binary Search Tree|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ConvertSortedArrayToBinarySearchTree.java)|
|[110](https://leetcode-cn.com/problems/balanced-binary-tree)|Balanced Binary Tree|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BalancedBinaryTree.java)|
|[111](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree)|Minimum Depth of Binary Tree|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MinimumDepthOfBinaryTree.java)|
|[112](https://leetcode-cn.com/problems/path-sum)|Path Sum|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PathSum.java)|
|[114](https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list)|Flatten Binary Tree to Linked List|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FlattenBinaryTreeToLinkedList.java)|
|[115](https://leetcode-cn.com/problems/distinct-subsequences)|Distinct Subsequences|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DistinctSubsequences.java)|
|[116](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node)|Populating Next Right Pointers in Each Node|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PopulatingNextRightPointersInEachNode.java)|
|[118](https://leetcode-cn.com/problems/pascals-triangle)|Pascal's Triangle|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PascalsTriangle.java)|
|[119](https://leetcode-cn.com/problems/pascals-triangle-ii)|Pascal's Triangle II|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PascalsTriangleIi.java)|
|[121](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock)|Best Time to Buy and Sell Stock|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BestTimeToBuyAndSellStockIi.java)|
|[121](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock)|Best Time to Buy and Sell Stock|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BestTimeToBuyAndSellStockIi.java)|
|[125](https://leetcode-cn.com/problems/valid-palindrome)|Valid Palindrome|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ValidPalindrome.java)|
|[127](https://leetcode-cn.com/problems/word-ladder)|Word Ladder|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/WordLadder.java)|
|[129](https://leetcode-cn.com/problems/sum-root-to-leaf-numbers)|Sum Root to Leaf Numbers|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SumRootToLeafNumbers.java)|
|[131](https://leetcode-cn.com/problems/palindrome-partitioning)|Palindrome Partitioning|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PalindromePartitioning.java)|
|[132](https://leetcode-cn.com/problems/palindrome-partitioning-ii)|Palindrome Partitioning II|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PalindromePartitioningIi.java)|
|[134](https://leetcode-cn.com/problems/gas-station)|Gas Station|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/GasStation.java)|
|[135](https://leetcode-cn.com/problems/candy)|Candy|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/Candy.java)|
|[136](https://leetcode-cn.com/problems/single-number)|Single Number|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SingleNumber.java)|
|[137](https://leetcode-cn.com/problems/single-number-ii)|Single Number II|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SingleNumberIi.java)|
|[139](https://leetcode-cn.com/problems/word-break)|Word Break|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/WordBreak.java)|
|[141](https://leetcode-cn.com/problems/linked-list-cycle)|Linked List Cycle|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LinkedListCycle.java)|
|[142](https://leetcode-cn.com/problems/linked-list-cycle-ii)|Linked List Cycle II|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LinkedListCycleIi.java)|
|[143](https://leetcode-cn.com/problems/reorder-list)|Reorder List|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ReorderList.java)|
|[144](https://leetcode-cn.com/problems/binary-tree-preorder-traversal)|Binary Tree Preorder Traversal|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BinaryTreePreorderTraversal.java)|
|[145](https://leetcode-cn.com/problems/binary-tree-postorder-traversal)|Binary Tree Postorder Traversal|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BinaryTreePostorderTraversal.java)|
|[146](https://leetcode-cn.com/problems/lru-cache)|LRU Cache|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LruCache.java)|
|[147](https://leetcode-cn.com/problems/insertion-sort-list)|Insertion Sort List|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/InsertionSortList.java)|
|[148](https://leetcode-cn.com/problems/sort-list)|Sort List|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SortList.java)|
|[150](https://leetcode-cn.com/problems/evaluate-reverse-polish-notation)|Evaluate Reverse Polish Notation|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/EvaluateReversePolishNotation.java)|
|[152](https://leetcode-cn.com/problems/maximum-product-subarray)|Maximum Product Subarray|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaximumProductSubarray.java)|
|[153](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array)|Find Minimum in Rotated Sorted Array|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FindMinimumInRotatedSortedArray.java)|
|[154](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii)|Find Minimum in Rotated Sorted Array II|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FindMinimumInRotatedSortedArrayIi.java)|
|[160](https://leetcode-cn.com/problems/intersection-of-two-linked-lists)|Intersection of Two Linked Lists|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/IntersectionOfTwoLinkedLists.java)|
|[164](https://leetcode-cn.com/problems/maximum-gap)|Maximum Gap|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaximumGap.java)|
|[167](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted)|Two Sum II - Input array is sorted|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/TwoSumIiInputArrayIsSorted.java)|
|[168](https://leetcode-cn.com/problems/excel-sheet-column-title)|Excel Sheet Column Title|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ExcelSheetColumnTitle.java)|
|[169](https://leetcode-cn.com/problems/majority-element)|Majority Element|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MajorityElement.java)|
|[171](https://leetcode-cn.com/problems/excel-sheet-column-number)|Excel Sheet Column Number|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ExcelSheetColumnNumber.java)|
|[172](https://leetcode-cn.com/problems/factorial-trailing-zeroes)|Factorial Trailing Zeroes|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FactorialTrailingZeroes.java)|
|[173](https://leetcode-cn.com/problems/binary-search-tree-iterator)|Binary Search Tree Iterator|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BinarySearchTreeIterator.java)|
|[179](https://leetcode-cn.com/problems/largest-number)|Largest Number|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LargestNumber.java)|
|[189](https://leetcode-cn.com/problems/rotate-array)|Rotate Array|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RotateArray.java)|
|[190](https://leetcode-cn.com/problems/reverse-bits)|Reverse Bits|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ReverseBits.java)|
|[191](https://leetcode-cn.com/problems/number-of-1-bits)|Number of 1 Bits|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/NumberOf1Bits.java)|
|[198](https://leetcode-cn.com/problems/house-robber)|House Robber|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/HouseRobber.java)|
|[200](https://leetcode-cn.com/problems/number-of-islands)|Number of Islands|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/NumberOfIslands.java)|
|[202](https://leetcode-cn.com/problems/happy-number)|Happy Number|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/HappyNumber.java)|
|[203](https://leetcode-cn.com/problems/remove-linked-list-elements)|Remove Linked List Elements|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RemoveLinkedListElements.java)|
|[204](https://leetcode-cn.com/problems/count-primes)|Count Primes|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CountPrimes.java)|
|[205](https://leetcode-cn.com/problems/isomorphic-strings)|Isomorphic Strings|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/IsomorphicStrings.java)|
|[207](https://leetcode-cn.com/problems/course-schedule)|Course Schedule|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CourseSchedule.java)|
|[208](https://leetcode-cn.com/problems/implement-trie-prefix-tree)|Implement Trie (Prefix Tree)|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ImplementTriePrefixTree.java)|
|[209](https://leetcode-cn.com/problems/minimum-size-subarray-sum)|Minimum Size Subarray Sum|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MinimumSizeSubarraySum.java)|
|[213](https://leetcode-cn.com/problems/house-robber-ii)|House Robber II|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/HouseRobberIi.java)|
|[215](https://leetcode-cn.com/problems/kth-largest-element-in-an-array)|Kth Largest Element in an Array|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/KthLargestElementInAnArray.java)|
|[217](https://leetcode-cn.com/problems/contains-duplicate)|Contains Duplicate|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ContainsDuplicate.java)|
|[219](https://leetcode-cn.com/problems/contains-duplicate-ii)|Contains Duplicate II|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ContainsDuplicateIi.java)|
|[220](https://leetcode-cn.com/problems/contains-duplicate-iii)|Contains Duplicate III|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ContainsDuplicateIii.java)|
|[221](https://leetcode-cn.com/problems/maximal-square)|Maximal Square|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaximalSquare.java)|
|[222](https://leetcode-cn.com/problems/count-complete-tree-nodes)|Count Complete Tree Nodes|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CountCompleteTreeNodes.java)|
|[224](https://leetcode-cn.com/problems/basic-calculator)|Basic Calculator|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BasicCalculator.java)|
|[225](https://leetcode-cn.com/problems/implement-stack-using-queues)|Implement Stack using Queues|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ImplementStackUsingQueues.java)|
|[226](https://leetcode-cn.com/problems/invert-binary-tree)|Invert Binary Tree|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/InvertBinaryTree.java)|
|[227](https://leetcode-cn.com/problems/basic-calculator-ii)|Basic Calculator II|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BasicCalculatorIi.java)|
|[228](https://leetcode-cn.com/problems/summary-ranges)|Summary Ranges|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SummaryRanges.java)|
|[231](https://leetcode-cn.com/problems/power-of-two)|Power of Two|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PowerOfTwo.java)|
|[232](https://leetcode-cn.com/problems/implement-queue-using-stacks)|Implement Queue using Stacks|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ImplementQueueUsingStacks.java)|
|[234](https://leetcode-cn.com/problems/palindrome-linked-list)|Palindrome Linked List|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PalindromeLinkedList.java)|
|[235](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree)|Lowest Common Ancestor of a Binary Search Tree|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LowestCommonAncestorOfABinarySearchTree.java)|
|[236](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree)|Lowest Common Ancestor of a Binary Tree|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LowestCommonAncestorOfABinaryTree.java)|
|[237](https://leetcode-cn.com/problems/delete-node-in-a-linked-list)|Delete Node in a Linked List|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DeleteNodeInALinkedList.java)|
|[238](https://leetcode-cn.com/problems/product-of-array-except-self)|Product of Array Except Self|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ProductOfArrayExceptSelf.java)|
|[240](https://leetcode-cn.com/problems/search-a-2d-matrix-ii)|Search a 2D Matrix II|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SearchA2dMatrixIi.java)|
|[242](https://leetcode-cn.com/problems/valid-anagram)|Valid Anagram|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ValidAnagram.java)|
|[257](https://leetcode-cn.com/problems/binary-tree-paths)|Binary Tree Paths|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BinaryTreePaths.java)|
|[263](https://leetcode-cn.com/problems/ugly-number)|Ugly Number|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/UglyNumber.java)|
|[264](https://leetcode-cn.com/problems/ugly-number-ii)|Ugly Number II|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/UglyNumberIi.java)|
|[268](https://leetcode-cn.com/problems/missing-number)|Missing Number|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MissingNumber.java)|
|[278](https://leetcode-cn.com/problems/first-bad-version)|First Bad Version|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FirstBadVersion.java)|
|[279](https://leetcode-cn.com/problems/perfect-squares)|Perfect Squares|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PerfectSquares.java)|
|[283](https://leetcode-cn.com/problems/move-zeroes)|Move Zeroes|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MoveZeroes.java)|
|[287](https://leetcode-cn.com/problems/find-the-duplicate-number)|Find the Duplicate Number|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FindTheDuplicateNumber.java)|
|[290](https://leetcode-cn.com/problems/word-pattern)|Word Pattern|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/WordPattern.java)|
|[300](https://leetcode-cn.com/problems/longest-increasing-subsequence)|Longest Increasing Subsequence|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LongestIncreasingSubsequence.java)|
|[303](https://leetcode-cn.com/problems/range-sum-query-immutable)|Range Sum Query - Immutable|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RangeSumQueryImmutable.java)|
|[304](https://leetcode-cn.com/problems/range-sum-query-2d-immutable)|Range Sum Query 2D - Immutable|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RangeSumQuery2dImmutable.java)|
|[309](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown)|Best Time to Buy and Sell Stock with Cooldown|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BestTimeToBuyAndSellStockWithCooldown.java)|
|[316](https://leetcode-cn.com/problems/remove-duplicate-letters)|Remove Duplicate Letters|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RemoveDuplicateLetters.java)|
|[322](https://leetcode-cn.com/problems/coin-change)|Coin Change|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CoinChange.java)|
|[328](https://leetcode-cn.com/problems/odd-even-linked-list)|Odd Even Linked List|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/OddEvenLinkedList.java)|
|[331](https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree)|Verify Preorder Serialization of a Binary Tree|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/VerifyPreorderSerializationOfABinaryTree.java)|
|[337](https://leetcode-cn.com/problems/house-robber-iii)|House Robber III|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/HouseRobberIii.java)|
|[338](https://leetcode-cn.com/problems/counting-bits)|Counting Bits|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CountingBits.java)|
|[341](https://leetcode-cn.com/problems/flatten-nested-list-iterator)|Flatten Nested List Iterator|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FlattenNestedListIterator.java)|
|[342](https://leetcode-cn.com/problems/power-of-four)|Power of Four|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PowerOfFour.java)|
|[343](https://leetcode-cn.com/problems/integer-break)|Integer Break|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/IntegerBreak.java)|
|[344](https://leetcode-cn.com/problems/reverse-string)|Reverse String|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ReverseString.java)|
|[347](https://leetcode-cn.com/problems/top-k-frequent-elements)|Top K Frequent Elements|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/TopKFrequentElements.java)|
|[349](https://leetcode-cn.com/problems/intersection-of-two-arrays)|Intersection of Two Arrays|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/IntersectionOfTwoArrays.java)|
|[354](https://leetcode-cn.com/problems/russian-doll-envelopes)|Russian Doll Envelopes|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RussianDollEnvelopes.java)|
|[363](https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k)|Max Sum of Rectangle No Larger Than K|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaxSumOfRectangleNoLargerThanK.java)|
|[368](https://leetcode-cn.com/problems/largest-divisible-subset)|Largest Divisible Subset|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LargestDivisibleSubset.java)|
|[377](https://leetcode-cn.com/problems/combination-sum-iv)|Combination Sum IV|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CombinationSumIv.java)|
|[387](https://leetcode-cn.com/problems/first-unique-character-in-a-string)|First Unique Character in a String|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FirstUniqueCharacterInAString.java)|
|[394](https://leetcode-cn.com/problems/decode-string)|Decode String|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DecodeString.java)|
|[395](https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters)|Longest Substring with At Least K Repeating Characters|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LongestSubstringWithAtLeastKRepeatingCharacters.java)|
|[399](https://leetcode-cn.com/problems/evaluate-division)|Evaluate Division|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/EvaluateDivision.java)|
|[401](https://leetcode-cn.com/problems/binary-watch)|Binary Watch|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BinaryWatch.java)|
|[403](https://leetcode-cn.com/problems/frog-jump)|Frog Jump|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FrogJump.java)|
|[406](https://leetcode-cn.com/problems/queue-reconstruction-by-height)|Queue Reconstruction by Height|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/QueueReconstructionByHeight.java)|
|[415](https://leetcode-cn.com/problems/add-strings)|Add Strings|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/AddStrings.java)|
|[416](https://leetcode-cn.com/problems/partition-equal-subset-sum)|Partition Equal Subset Sum|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PartitionEqualSubsetSum.java)|
|[421](https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array)|Maximum XOR of Two Numbers in an Array|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaximumXorOfTwoNumbersInAnArray.java)|
|[424](https://leetcode-cn.com/problems/longest-repeating-character-replacement)|Longest Repeating Character Replacement|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LongestRepeatingCharacterReplacement.java)|
|[435](https://leetcode-cn.com/problems/non-overlapping-intervals)|Non-overlapping Intervals|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/NonOverlappingIntervals.java)|
|[437](https://leetcode-cn.com/problems/path-sum-iii)|Path Sum III|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PathSumIii.java)|
|[438](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string)|Find All Anagrams in a String|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FindAllAnagramsInAString.java)|
|[448](https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array)|Find All Numbers Disappeared in an Array|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FindAllNumbersDisappearedInAnArray.java)|
|[452](https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons)|Minimum Number of Arrows to Burst Balloons|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MinimumNumberOfArrowsToBurstBalloons.java)|
|[454](https://leetcode-cn.com/problems/4sum-ii)|4Sum II|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FourSumIi.java)|
|[455](https://leetcode-cn.com/problems/assign-cookies)|Assign Cookies|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/AssignCookies.java)|
|[456](https://leetcode-cn.com/problems/132-pattern)|132 Pattern|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/One32Pattern.java)|
|[461](https://leetcode-cn.com/problems/hamming-distance)|Hamming Distance|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/HammingDistance.java)|
|[463](https://leetcode-cn.com/problems/island-perimeter)|Island Perimeter|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/IslandPerimeter.java)|
|[474](https://leetcode-cn.com/problems/ones-and-zeroes)|Ones and Zeroes|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/OnesAndZeroes.java)|
|[477](https://leetcode-cn.com/problems/total-hamming-distance)|Total Hamming Distance|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/TotalHammingDistance.java)|
|[480](https://leetcode-cn.com/problems/sliding-window-median)|Sliding Window Median|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SlidingWindowMedian.java)|
|[485](https://leetcode-cn.com/problems/max-consecutive-ones)|Max Consecutive Ones|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaxConsecutiveOnes.java)|
|[494](https://leetcode-cn.com/problems/target-sum)|Target Sum|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/TargetSum.java)|
|[503](https://leetcode-cn.com/problems/next-greater-element-ii)|Next Greater Element II|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/NextGreaterElementIi.java)|
|[509](https://leetcode-cn.com/problems/fibonacci-number)|Fibonacci Number|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FibonacciNumber.java)|
|[518](https://leetcode-cn.com/problems/coin-change-2)|Coin Change 2|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CoinChange2.java)|
|[523](https://leetcode-cn.com/problems/continuous-subarray-sum)|Continuous Subarray Sum|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ContinuousSubarraySum.java)|
|[525](https://leetcode-cn.com/problems/contiguous-array)|Contiguous Array|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ContiguousArray.java)|
|[530](https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst)|Minimum Absolute Difference in BST|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MinimumAbsoluteDifferenceInBst.java)|
|[538](https://leetcode-cn.com/problems/convert-bst-to-greater-tree)|Convert BST to Greater Tree|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ConvertBstToGreaterTree.java)|
|[543](https://leetcode-cn.com/problems/diameter-of-binary-tree)|Diameter of Binary Tree|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DiameterOfBinaryTree.java)|
|[547](https://leetcode-cn.com/problems/number-of-provinces)|Number of Provinces|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/NumberOfProvinces.java)|
|[554](https://leetcode-cn.com/problems/brick-wall)|Brick Wall|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BrickWall.java)|
|[560](https://leetcode-cn.com/problems/subarray-sum-equals-k)|Subarray Sum Equals K|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SubarraySumEqualsK.java)|
|[561](https://leetcode-cn.com/problems/array-partition-i)|Array Partition I|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ArrayPartitionI.java)|
|[566](https://leetcode-cn.com/problems/reshape-the-matrix)|Reshape the Matrix|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ReshapeTheMatrix.java)|
|[567](https://leetcode-cn.com/problems/permutation-in-string)|Permutation in String|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PermutationInString.java)|
|[581](https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray)|Shortest Unsorted Continuous Subarray|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ShortestUnsortedContinuousSubarray.java)|
|[605](https://leetcode-cn.com/problems/can-place-flowers)|Can Place Flowers|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CanPlaceFlowers.java)|
|[617](https://leetcode-cn.com/problems/merge-two-binary-trees)|Merge Two Binary Trees|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MergeTwoBinaryTrees.java)|
|[621](https://leetcode-cn.com/problems/task-scheduler)|Task Scheduler|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/TaskScheduler.java)|
|[628](https://leetcode-cn.com/problems/maximum-product-of-three-numbers)|Maximum Product of Three Numbers|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaximumProductOfThreeNumbers.java)|
|[633](https://leetcode-cn.com/problems/sum-of-square-numbers)|Sum of Square Numbers|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SumOfSquareNumbers.java)|
|[639](https://leetcode-cn.com/problems/decode-ways-ii)|Decode Ways II|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DecodeWaysIi.java)|
|[643](https://leetcode-cn.com/problems/maximum-average-subarray-i)|Maximum Average Subarray I|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaximumAverageSubarrayI.java)|
|[647](https://leetcode-cn.com/problems/palindromic-substrings)|Palindromic Substrings|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PalindromicSubstrings.java)|
|[664](https://leetcode-cn.com/problems/strange-printer)|Strange Printer|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/StrangePrinter.java)|
|[665](https://leetcode-cn.com/problems/non-decreasing-array)|Non-decreasing Array|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/NonDecreasingArray.java)|
|[674](https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence)|Longest Continuous Increasing Subsequence|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LongestContinuousIncreasingSubsequence.java)|
|[684](https://leetcode-cn.com/problems/redundant-connection)|Redundant Connection|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RedundantConnection.java)|
|[690](https://leetcode-cn.com/problems/employee-importance)|Employee Importance|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/EmployeeImportance.java)|
|[692](https://leetcode-cn.com/problems/top-k-frequent-words)|Top K Frequent Words|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/TopKFrequentWords.java)|
|[697](https://leetcode-cn.com/problems/degree-of-an-array)|Degree of an Array|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DegreeOfAnArray.java)|
|[701](https://leetcode-cn.com/problems/insert-into-a-binary-search-tree)|Insert into a Binary Search Tree|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/InsertIntoABinarySearchTree.java)|
|[703](https://leetcode-cn.com/problems/kth-largest-element-in-a-stream)|Kth Largest Element in a Stream|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/KthLargestElementInAStream.java)|
|[705](https://leetcode-cn.com/problems/design-hashset)|Design HashSet|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DesignHashset.java)|
|[706](https://leetcode-cn.com/problems/design-hashmap)|Design HashMap|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DesignHashmap.java)|
|[709](https://leetcode-cn.com/problems/to-lower-case)|To Lower Case|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ToLowerCase.java)|
|[713](https://leetcode-cn.com/problems/subarray-product-less-than-k)|Subarray Product Less Than K|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SubarrayProductLessThanK.java)|
|[714](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee)|Best Time to Buy and Sell Stock with Transaction Fee|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BestTimeToBuyAndSellStockWithTransactionFee.java)|
|[721](https://leetcode-cn.com/problems/accounts-merge)|Accounts Merge|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/AccountsMerge.java)|
|[724](https://leetcode-cn.com/problems/find-pivot-index)|Find Pivot Index|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FindPivotIndex.java)|
|[738](https://leetcode-cn.com/problems/monotone-increasing-digits)|Monotone Increasing Digits|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MonotoneIncreasingDigits.java)|
|[739](https://leetcode-cn.com/problems/daily-temperatures)|Daily Temperatures|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DailyTemperatures.java)|
|[740](https://leetcode-cn.com/problems/delete-and-earn)|Delete and Earn|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DeleteAndEarn.java)|
|[746](https://leetcode-cn.com/problems/min-cost-climbing-stairs)|Min Cost Climbing Stairs|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MinCostClimbingStairs.java)|
|[763](https://leetcode-cn.com/problems/partition-labels)|Partition Labels|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PartitionLabels.java)|
|[765](https://leetcode-cn.com/problems/couples-holding-hands)|Couples Holding Hands|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CouplesHoldingHands.java)|
|[766](https://leetcode-cn.com/problems/toeplitz-matrix)|Toeplitz Matrix|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ToeplitzMatrix.java)|
|[767](https://leetcode-cn.com/problems/reorganize-string)|Reorganize String|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ReorganizeString.java)|
|[771](https://leetcode-cn.com/problems/jewels-and-stones)|Jewels and Stones|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/JewelsAndStones.java)|
|[781](https://leetcode-cn.com/problems/rabbits-in-forest)|Rabbits in Forest|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RabbitsInForest.java)|
|[783](https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes)|Minimum Distance Between BST Nodes|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MinimumDistanceBetweenBstNodes.java)|
|[830](https://leetcode-cn.com/problems/positions-of-large-groups)|Positions of Large Groups|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PositionsOfLargeGroups.java)|
|[832](https://leetcode-cn.com/problems/flipping-an-image)|Flipping an Image|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FlippingAnImage.java)|
|[844](https://leetcode-cn.com/problems/backspace-string-compare)|Backspace String Compare|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BackspaceStringCompare.java)|
|[845](https://leetcode-cn.com/problems/longest-mountain-in-array)|Longest Mountain in Array|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LongestMountainInArray.java)|
|[852](https://leetcode-cn.com/problems/peak-index-in-a-mountain-array)|Peak Index in a Mountain Array|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PeakIndexInAMountainArray.java)|
|[860](https://leetcode-cn.com/problems/lemonade-change)|Lemonade Change|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LemonadeChange.java)|
|[867](https://leetcode-cn.com/problems/transpose-matrix)|Transpose Matrix|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/TransposeMatrix.java)|
|[872](https://leetcode-cn.com/problems/leaf-similar-trees)|Leaf-Similar Trees|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LeafSimilarTrees.java)|
|[877](https://leetcode-cn.com/problems/stone-game)|Stone Game|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/StoneGame.java)|
|[888](https://leetcode-cn.com/problems/fair-candy-swap)|Fair Candy Swap|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FairCandySwap.java)|
|[896](https://leetcode-cn.com/problems/monotonic-array)|Monotonic Array|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MonotonicArray.java)|
|[897](https://leetcode-cn.com/problems/increasing-order-search-tree)|Increasing Order Search Tree|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/IncreasingOrderSearchTree.java)|
|[922](https://leetcode-cn.com/problems/sort-array-by-parity-ii)|Sort Array By Parity II|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SortArrayByParityIi.java)|
|[925](https://leetcode-cn.com/problems/long-pressed-name)|Long Pressed Name|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LongPressedName.java)|
|[938](https://leetcode-cn.com/problems/range-sum-of-bst)|Range Sum of BST|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RangeSumOfBst.java)|
|[941](https://leetcode-cn.com/problems/valid-mountain-array)|Valid Mountain Array|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ValidMountainArray.java)|
|[951](https://leetcode-cn.com/problems/flip-equivalent-binary-trees)|Flip Equivalent Binary Trees|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FlipEquivalentBinaryTrees.java)|
|[959](https://leetcode-cn.com/problems/regions-cut-by-slashes)|Regions Cut By Slashes|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RegionsCutBySlashes.java)|
|[973](https://leetcode-cn.com/problems/k-closest-points-to-origin)|K Closest Points to Origin|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/KClosestPointsToOrigin.java)|
|[977](https://leetcode-cn.com/problems/squares-of-a-sorted-array)|Squares of a Sorted Array|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SquaresOfASortedArray.java)|
|[978](https://leetcode-cn.com/problems/longest-turbulent-subarray)|Longest Turbulent Subarray|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LongestTurbulentSubarray.java)|
|[989](https://leetcode-cn.com/problems/add-to-array-form-of-integer)|Add to Array-Form of Integer|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/AddToArrayFormOfInteger.java)|
|[992](https://leetcode-cn.com/problems/subarrays-with-k-different-integers)|Subarrays with K Different Integers|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SubarraysWithKDifferentIntegers.java)|
|[993](https://leetcode-cn.com/problems/cousins-in-binary-tree)|Cousins in Binary Tree|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CousinsInBinaryTree.java)|
|[995](https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips)|Minimum Number of K Consecutive Bit Flips|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MinimumNumberOfKConsecutiveBitFlips.java)|
|[1002](https://leetcode-cn.com/problems/find-common-characters)|Find Common Characters|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FindCommonCharacters.java)|
|[1004](https://leetcode-cn.com/problems/max-consecutive-ones-iii)|Max Consecutive Ones III|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaxConsecutiveOnesIii.java)|
|[1006](https://leetcode-cn.com/problems/clumsy-factorial)|Clumsy Factorial|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ClumsyFactorial.java)|
|[1011](https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days)|Capacity To Ship Packages Within D Days|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CapacityToShipPackagesWithinDDays.java)|
|[1018](https://leetcode-cn.com/problems/binary-prefix-divisible-by-5)|Binary Prefix Divisible By 5|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BinaryPrefixDivisibleBy5.java)|
|[1030](https://leetcode-cn.com/problems/matrix-cells-in-distance-order)|Matrix Cells in Distance Order|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MatrixCellsInDistanceOrder.java)|
|[1035](https://leetcode-cn.com/problems/uncrossed-lines)|Uncrossed Lines|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/UncrossedLines.java)|
|[1046](https://leetcode-cn.com/problems/last-stone-weight)|Last Stone Weight|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LastStoneWeight.java)|
|[1047](https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string)|Remove All Adjacent Duplicates In String|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RemoveAllAdjacentDuplicatesInString.java)|
|[1049](https://leetcode-cn.com/problems/last-stone-weight-ii)|Last Stone Weight II|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LastStoneWeightIi.java)|
|[1052](https://leetcode-cn.com/problems/grumpy-bookstore-owner)|Grumpy Bookstore Owner|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/GrumpyBookstoreOwner.java)|
|[1074](https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target)|Number of Submatrices That Sum to Target|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/NumberOfSubmatricesThatSumToTarget.java)|
|[1122](https://leetcode-cn.com/problems/relative-sort-array)|Relative Sort Array|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RelativeSortArray.java)|
|[1128](https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs)|Number of Equivalent Domino Pairs|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/NumberOfEquivalentDominoPairs.java)|
|[1143](https://leetcode-cn.com/problems/longest-common-subsequence)|Longest Common Subsequence|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LongestCommonSubsequence.java)|
|[1178](https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle)|Number of Valid Words for Each Puzzle|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/NumberOfValidWordsForEachPuzzle.java)|
|[1190](https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses)|Reverse Substrings Between Each Pair of Parentheses|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ReverseSubstringsBetweenEachPairOfParentheses.java)|
|[1202](https://leetcode-cn.com/problems/smallest-string-with-swaps)|Smallest String With Swaps|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SmallestStringWithSwaps.java)|
|[1207](https://leetcode-cn.com/problems/unique-number-of-occurrences)|Unique Number of Occurrences|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/UniqueNumberOfOccurrences.java)|
|[1208](https://leetcode-cn.com/problems/get-equal-substrings-within-budget)|Get Equal Substrings Within Budget|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/GetEqualSubstringsWithinBudget.java)|
|[1232](https://leetcode-cn.com/problems/check-if-it-is-a-straight-line)|Check If It Is a Straight Line|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CheckIfItIsAStraightLine.java)|
|[1239](https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters)|Maximum Length of a Concatenated String with Unique Characters|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaximumLengthOfAConcatenatedStringWithUniqueCharacters.java)|
|[1269](https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps)|Number of Ways to Stay in the Same Place After Some Steps|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/NumberOfWaysToStayInTheSamePlaceAfterSomeSteps.java)|
|[1277](https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones)|Count Square Submatrices with All Ones|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CountSquareSubmatricesWithAllOnes.java)|
|[1310](https://leetcode-cn.com/problems/xor-queries-of-a-subarray)|XOR Queries of a Subarray|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/XorQueriesOfASubarray.java)|
|[1356](https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits)|Sort Integers by The Number of 1 Bits|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SortIntegersByTheNumberOf1Bits.java)|
|[1365](https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number)|How Many Numbers Are Smaller Than the Current Number|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/HowManyNumbersAreSmallerThanTheCurrentNumber.java)|
|[1370](https://leetcode-cn.com/problems/increasing-decreasing-string)|Increasing Decreasing String|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/IncreasingDecreasingString.java)|
|[1423](https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards)|Maximum Points You Can Obtain from Cards|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaximumPointsYouCanObtainFromCards.java)|
|[1438](https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit)|Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit.java)|
|[1442](https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor)|Count Triplets That Can Form Two Arrays of Equal XOR|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CountTripletsThatCanFormTwoArraysOfEqualXor.java)|
|[1473](https://leetcode-cn.com/problems/paint-house-iii)|Paint House III|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PaintHouseIii.java)|
|[1482](https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets)|Minimum Number of Days to Make m Bouquets|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MinimumNumberOfDaysToMakeMBouquets.java)|
|[1486](https://leetcode-cn.com/problems/xor-operation-in-an-array)|XOR Operation in an Array|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/XorOperationInAnArray.java)|
|[1600](https://leetcode-cn.com/problems/throne-inheritance)|Throne Inheritance|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ThroneInheritanceWrapper.java)|
|[1603](https://leetcode-cn.com/problems/design-parking-system)|Design Parking System|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DesignParkingSystem.java)|
|[1631](https://leetcode-cn.com/problems/path-with-minimum-effort)|Path With Minimum Effort|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PathWithMinimumEffort.java)|
|[1707](https://leetcode-cn.com/problems/maximum-xor-with-an-element-from-array)|Maximum XOR With an Element From Array|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaximumXorWithAnElementFromArray.java)|
|[1720](https://leetcode-cn.com/problems/decode-xored-array)|Decode XORed Array|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DecodeXoredArray.java)|
|[1723](https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs)|Find Minimum Time to Finish All Jobs|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FindMinimumTimeToFinishAllJobs.java)|
|[1734](https://leetcode-cn.com/problems/decode-xored-permutation)|Decode XORed Permutation|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DecodeXoredPermutation.java)|
|[1738](https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value)|Find Kth Largest XOR Coordinate Value|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FindKthLargestXorCoordinateValue.java)|
|[1744](https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day)|Can You Eat Your Favorite Candy on Your Favorite Day?|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CanYouEatYourFavoriteCandyOnYourFavoriteDay.java)|
|[1758](https://leetcode-cn.com/problems/minimum-changes-to-make-alternating-binary-string)|Minimum Changes To Make Alternating Binary String|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MinimumChangesToMakeAlternatingBinaryString.java)|
|[1822](https://leetcode-cn.com/problems/sign-of-the-product-of-an-array)|Sign of the Product of an Array|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SignOfTheProductOfAnArray.java)|
|[1823](https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game)|Find the Winner of the Circular Game|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FindTheWinnerOfTheCircularGame.java)|
|[剑指 Offer 03](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof)|数组中重复的数字 LCOF|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ShuZuZhongZhongFuDeShuZiLcof.java)|
|[剑指 Offer 04](https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof)|二维数组中的查找 LCOF|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ErWeiShuZuZhongDeChaZhaoLcof.java)|
|[剑指 Offer 05](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof)|替换空格 LCOF|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/TiHuanKongGeLcof.java)|
|[剑指 Offer 06](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof)|从尾到头打印链表 LCOF|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CongWeiDaoTouDaYinLianBiaoLcof.java)|
|[剑指 Offer 07](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof)|重建二叉树 LCOF|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ZhongJianErChaShuLcof.java)|
|[剑指 Offer 09](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof)|用两个栈实现队列 LCOF|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/YongLiangGeZhanShiXianDuiLieLcof.java)|
|[剑指 Offer 10- I](https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof)|斐波那契数列 LCOF|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FeiBoNaQiShuLieLcof.java)|
|[剑指 Offer 10- II](https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof)|青蛙跳台阶问题 LCOF|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/QingWaTiaoTaiJieWenTiLcof.java)|
|[剑指 Offer 11](https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof)|旋转数组的最小数字 LCOF|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/XuanZhuanShuZuDeZuiXiaoShuZiLcof.java)|
|[剑指 Offer 12](https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof)|矩阵中的路径 LCOF|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/JuZhenZhongDeLuJingLcof.java)|
|[剑指 Offer 13](https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof)|机器人的运动范围 LCOF|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/JiQiRenDeYunDongFanWeiLcof.java)|
|[剑指 Offer 14- I](https://leetcode-cn.com/problems/jian-sheng-zi-lcof)|剪绳子 LCOF|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/JianShengZiLcof.java)|
|[剑指 Offer 14- II](https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof)|剪绳子 II LCOF|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/JianShengZiIiLcof.java)|
|[剑指 Offer 15](https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof)|二进制中1的个数 LCOF|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ErJinZhiZhong1deGeShuLcof.java)|
|[剑指 Offer 17](https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof)|打印从1到最大的n位数 LCOF|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DaYinCong1daoZuiDaDeNweiShuLcof.java)|
|[剑指 Offer 18](https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof)|删除链表的节点 LCOF|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ShanChuLianBiaoDeJieDianLcof.java)|
|[剑指 Offer 21](https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof)|调整数组顺序使奇数位于偶数前面 LCOF|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof.java)|
|[剑指 Offer 22](https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof)|链表中倒数第k个节点 LCOF|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LianBiaoZhongDaoShuDiKgeJieDianLcof.java)|
|[剑指 Offer 24](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof)|反转链表 LCOF|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FanZhuanLianBiaoLcof.java)|
|[剑指 Offer 38](https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof)|字符串的排列 LCOF|⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ZiFuChuanDePaiLieLcof.java)|
|[剑指 Offer 42](https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof)|连续子数组的最大和 LCOF|⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LianXuZiShuZuDeZuiDaHeLcof.java)|
|[面试题 17.21](https://leetcode-cn.com/problems/volume-of-histogram-lcci)|Volume of Histogram LCCI|⭐⭐⭐|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/VolumeOfHistogramLcci.java)|
