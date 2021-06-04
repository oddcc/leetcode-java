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
### 目前已有219道题，不断添加中…
|ID|标题|难度|CODE|
| ---- | ---- | ---- | ---- |
|[6](https://leetcode-cn.com/problems/zigzag-conversion)|ZigZag Conversion|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ZigzagConversion.java)|
|[7](https://leetcode-cn.com/problems/reverse-integer)|Reverse Integer|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ReverseInteger.java)|
|[12](https://leetcode-cn.com/problems/integer-to-roman)|Integer to Roman|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/IntegerToRoman.java)|
|[13](https://leetcode-cn.com/problems/roman-to-integer)|Roman to Integer|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RomanToInteger.java)|
|[26](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array)|Remove Duplicates from Sorted Array|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RemoveDuplicatesFromSortedArray.java)|
|[27](https://leetcode-cn.com/problems/remove-element)|Remove Element|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RemoveElement.java)|
|[28](https://leetcode-cn.com/problems/implement-strstr)|Implement strStr()|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ImplementStrstr.java)|
|[30](https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words)|Substring with Concatenation of All Words|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SubstringWithConcatenationOfAllWords.java)|
|[41](https://leetcode-cn.com/problems/first-missing-positive)|First Missing Positive|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FirstMissingPositive.java)|
|[42](https://leetcode-cn.com/problems/trapping-rain-water)|Trapping Rain Water|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/TrappingRainWater.java)|
|[49](https://leetcode-cn.com/problems/group-anagrams)|Group Anagrams|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/GroupAnagrams.java)|
|[54](https://leetcode-cn.com/problems/spiral-matrix)|Spiral Matrix|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SpiralMatrix.java)|
|[55](https://leetcode-cn.com/problems/jump-game)|Jump Game|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/JumpGame.java)|
|[59](https://leetcode-cn.com/problems/spiral-matrix-ii)|Spiral Matrix II|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SpiralMatrixIi.java)|
|[61](https://leetcode-cn.com/problems/rotate-list)|Rotate List|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RotateList.java)|
|[62](https://leetcode-cn.com/problems/unique-paths)|Unique Paths|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/UniquePaths.java)|
|[73](https://leetcode-cn.com/problems/set-matrix-zeroes)|Set Matrix Zeroes|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SetMatrixZeroes.java)|
|[74](https://leetcode-cn.com/problems/search-a-2d-matrix)|Search a 2D Matrix|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SearchA2dMatrix.java)|
|[80](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii)|Remove Duplicates from Sorted Array II|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RemoveDuplicatesFromSortedArrayIi.java)|
|[81](https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii)|Search in Rotated Sorted Array II|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SearchInRotatedSortedArrayIi.java)|
|[82](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii)|Remove Duplicates from Sorted List II|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RemoveDuplicatesFromSortedListIi.java)|
|[84](https://leetcode-cn.com/problems/largest-rectangle-in-histogram)|Largest Rectangle in Histogram|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LargestRectangleInHistogram.java)|
|[87](https://leetcode-cn.com/problems/scramble-string)|Scramble String|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ScrambleString.java)|
|[90](https://leetcode-cn.com/problems/subsets-ii)|Subsets II|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SubsetsIi.java)|
|[91](https://leetcode-cn.com/problems/decode-ways)|Decode Ways|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DecodeWays.java)|
|[92](https://leetcode-cn.com/problems/reverse-linked-list-ii)|Reverse Linked List II|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ReverseLinkedListIi.java)|
|[103](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal)|Binary Tree Zigzag Level Order Traversal|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BinaryTreeZigzagLevelOrderTraversal.java)|
|[115](https://leetcode-cn.com/problems/distinct-subsequences)|Distinct Subsequences|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DistinctSubsequences.java)|
|[119](https://leetcode-cn.com/problems/pascals-triangle-ii)|Pascal's Triangle II|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PascalsTriangleIi.java)|
|[131](https://leetcode-cn.com/problems/palindrome-partitioning)|Palindrome Partitioning|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PalindromePartitioning.java)|
|[132](https://leetcode-cn.com/problems/palindrome-partitioning-ii)|Palindrome Partitioning II|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PalindromePartitioningIi.java)|
|[134](https://leetcode-cn.com/problems/gas-station)|Gas Station|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/GasStation.java)|
|[135](https://leetcode-cn.com/problems/candy)|Candy|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/Candy.java)|
|[137](https://leetcode-cn.com/problems/single-number-ii)|Single Number II|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SingleNumberIi.java)|
|[145](https://leetcode-cn.com/problems/binary-tree-postorder-traversal)|Binary Tree Postorder Traversal|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BinaryTreePostorderTraversal.java)|
|[146](https://leetcode-cn.com/problems/lru-cache)|LRU Cache|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LruCache.java)|
|[147](https://leetcode-cn.com/problems/insertion-sort-list)|Insertion Sort List|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/InsertionSortList.java)|
|[150](https://leetcode-cn.com/problems/evaluate-reverse-polish-notation)|Evaluate Reverse Polish Notation|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/EvaluateReversePolishNotation.java)|
|[153](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array)|Find Minimum in Rotated Sorted Array|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FindMinimumInRotatedSortedArray.java)|
|[154](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii)|Find Minimum in Rotated Sorted Array II|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FindMinimumInRotatedSortedArrayIi.java)|
|[164](https://leetcode-cn.com/problems/maximum-gap)|Maximum Gap|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaximumGap.java)|
|[169](https://leetcode-cn.com/problems/majority-element)|Majority Element|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MajorityElement.java)|
|[173](https://leetcode-cn.com/problems/binary-search-tree-iterator)|Binary Search Tree Iterator|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BinarySearchTreeIterator.java)|
|[179](https://leetcode-cn.com/problems/largest-number)|Largest Number|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LargestNumber.java)|
|[189](https://leetcode-cn.com/problems/rotate-array)|Rotate Array|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RotateArray.java)|
|[190](https://leetcode-cn.com/problems/reverse-bits)|Reverse Bits|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ReverseBits.java)|
|[191](https://leetcode-cn.com/problems/number-of-1-bits)|Number of 1 Bits|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/NumberOf1Bits.java)|
|[202](https://leetcode-cn.com/problems/happy-number)|Happy Number|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/HappyNumber.java)|
|[203](https://leetcode-cn.com/problems/remove-linked-list-elements)|Remove Linked List Elements|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RemoveLinkedListElements.java)|
|[204](https://leetcode-cn.com/problems/count-primes)|Count Primes|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CountPrimes.java)|
|[205](https://leetcode-cn.com/problems/isomorphic-strings)|Isomorphic Strings|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/IsomorphicStrings.java)|
|[208](https://leetcode-cn.com/problems/implement-trie-prefix-tree)|Implement Trie (Prefix Tree)|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ImplementTriePrefixTree.java)|
|[209](https://leetcode-cn.com/problems/minimum-size-subarray-sum)|Minimum Size Subarray Sum|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MinimumSizeSubarraySum.java)|
|[213](https://leetcode-cn.com/problems/house-robber-ii)|House Robber II|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/HouseRobberIi.java)|
|[215](https://leetcode-cn.com/problems/kth-largest-element-in-an-array)|Kth Largest Element in an Array|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/KthLargestElementInAnArray.java)|
|[217](https://leetcode-cn.com/problems/contains-duplicate)|Contains Duplicate|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ContainsDuplicate.java)|
|[220](https://leetcode-cn.com/problems/contains-duplicate-iii)|Contains Duplicate III|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ContainsDuplicateIii.java)|
|[221](https://leetcode-cn.com/problems/maximal-square)|Maximal Square|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaximalSquare.java)|
|[222](https://leetcode-cn.com/problems/count-complete-tree-nodes)|Count Complete Tree Nodes|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CountCompleteTreeNodes.java)|
|[224](https://leetcode-cn.com/problems/basic-calculator)|Basic Calculator|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BasicCalculator.java)|
|[225](https://leetcode-cn.com/problems/implement-stack-using-queues)|Implement Stack using Queues|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ImplementStackUsingQueues.java)|
|[227](https://leetcode-cn.com/problems/basic-calculator-ii)|Basic Calculator II|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BasicCalculatorIi.java)|
|[228](https://leetcode-cn.com/problems/summary-ranges)|Summary Ranges|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SummaryRanges.java)|
|[231](https://leetcode-cn.com/problems/power-of-two)|Power of Two|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PowerOfTwo.java)|
|[232](https://leetcode-cn.com/problems/implement-queue-using-stacks)|Implement Queue using Stacks|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ImplementQueueUsingStacks.java)|
|[235](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree)|Lowest Common Ancestor of a Binary Search Tree|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LowestCommonAncestorOfABinarySearchTree.java)|
|[236](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree)|Lowest Common Ancestor of a Binary Tree|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LowestCommonAncestorOfABinaryTree.java)|
|[237](https://leetcode-cn.com/problems/delete-node-in-a-linked-list)|Delete Node in a Linked List|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DeleteNodeInALinkedList.java)|
|[238](https://leetcode-cn.com/problems/product-of-array-except-self)|Product of Array Except Self|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ProductOfArrayExceptSelf.java)|
|[240](https://leetcode-cn.com/problems/search-a-2d-matrix-ii)|Search a 2D Matrix II|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SearchA2dMatrixIi.java)|
|[242](https://leetcode-cn.com/problems/valid-anagram)|Valid Anagram|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ValidAnagram.java)|
|[257](https://leetcode-cn.com/problems/binary-tree-paths)|Binary Tree Paths|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BinaryTreePaths.java)|
|[263](https://leetcode-cn.com/problems/ugly-number)|Ugly Number|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/UglyNumber.java)|
|[264](https://leetcode-cn.com/problems/ugly-number-ii)|Ugly Number II|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/UglyNumberIi.java)|
|[279](https://leetcode-cn.com/problems/perfect-squares)|Perfect Squares|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PerfectSquares.java)|
|[283](https://leetcode-cn.com/problems/move-zeroes)|Move Zeroes|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MoveZeroes.java)|
|[287](https://leetcode-cn.com/problems/find-the-duplicate-number)|Find the Duplicate Number|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FindTheDuplicateNumber.java)|
|[290](https://leetcode-cn.com/problems/word-pattern)|Word Pattern|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/WordPattern.java)|
|[300](https://leetcode-cn.com/problems/longest-increasing-subsequence)|Longest Increasing Subsequence|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LongestIncreasingSubsequence.java)|
|[303](https://leetcode-cn.com/problems/range-sum-query-immutable)|Range Sum Query - Immutable|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RangeSumQueryImmutable.java)|
|[304](https://leetcode-cn.com/problems/range-sum-query-2d-immutable)|Range Sum Query 2D - Immutable|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RangeSumQuery2dImmutable.java)|
|[309](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown)|Best Time to Buy and Sell Stock with Cooldown|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BestTimeToBuyAndSellStockWithCooldown.java)|
|[316](https://leetcode-cn.com/problems/remove-duplicate-letters)|Remove Duplicate Letters|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RemoveDuplicateLetters.java)|
|[322](https://leetcode-cn.com/problems/coin-change)|Coin Change|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CoinChange.java)|
|[328](https://leetcode-cn.com/problems/odd-even-linked-list)|Odd Even Linked List|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/OddEvenLinkedList.java)|
|[331](https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree)|Verify Preorder Serialization of a Binary Tree|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/VerifyPreorderSerializationOfABinaryTree.java)|
|[337](https://leetcode-cn.com/problems/house-robber-iii)|House Robber III|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/HouseRobberIii.java)|
|[338](https://leetcode-cn.com/problems/counting-bits)|Counting Bits|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CountingBits.java)|
|[341](https://leetcode-cn.com/problems/flatten-nested-list-iterator)|Flatten Nested List Iterator|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FlattenNestedListIterator.java)|
|[342](https://leetcode-cn.com/problems/power-of-four)|Power of Four|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PowerOfFour.java)|
|[343](https://leetcode-cn.com/problems/integer-break)|Integer Break|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/IntegerBreak.java)|
|[347](https://leetcode-cn.com/problems/top-k-frequent-elements)|Top K Frequent Elements|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/TopKFrequentElements.java)|
|[354](https://leetcode-cn.com/problems/russian-doll-envelopes)|Russian Doll Envelopes|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RussianDollEnvelopes.java)|
|[363](https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k)|Max Sum of Rectangle No Larger Than K|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaxSumOfRectangleNoLargerThanK.java)|
|[368](https://leetcode-cn.com/problems/largest-divisible-subset)|Largest Divisible Subset|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LargestDivisibleSubset.java)|
|[377](https://leetcode-cn.com/problems/combination-sum-iv)|Combination Sum IV|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CombinationSumIv.java)|
|[387](https://leetcode-cn.com/problems/first-unique-character-in-a-string)|First Unique Character in a String|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FirstUniqueCharacterInAString.java)|
|[394](https://leetcode-cn.com/problems/decode-string)|Decode String|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DecodeString.java)|
|[395](https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters)|Longest Substring with At Least K Repeating Characters|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LongestSubstringWithAtLeastKRepeatingCharacters.java)|
|[399](https://leetcode-cn.com/problems/evaluate-division)|Evaluate Division|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/EvaluateDivision.java)|
|[403](https://leetcode-cn.com/problems/frog-jump)|Frog Jump|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FrogJump.java)|
|[406](https://leetcode-cn.com/problems/queue-reconstruction-by-height)|Queue Reconstruction by Height|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/QueueReconstructionByHeight.java)|
|[415](https://leetcode-cn.com/problems/add-strings)|Add Strings|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/AddStrings.java)|
|[416](https://leetcode-cn.com/problems/partition-equal-subset-sum)|Partition Equal Subset Sum|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PartitionEqualSubsetSum.java)|
|[421](https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array)|Maximum XOR of Two Numbers in an Array|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaximumXorOfTwoNumbersInAnArray.java)|
|[424](https://leetcode-cn.com/problems/longest-repeating-character-replacement)|Longest Repeating Character Replacement|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LongestRepeatingCharacterReplacement.java)|
|[435](https://leetcode-cn.com/problems/non-overlapping-intervals)|Non-overlapping Intervals|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/NonOverlappingIntervals.java)|
|[437](https://leetcode-cn.com/problems/path-sum-iii)|Path Sum III|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PathSumIii.java)|
|[438](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string)|Find All Anagrams in a String|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FindAllAnagramsInAString.java)|
|[448](https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array)|Find All Numbers Disappeared in an Array|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FindAllNumbersDisappearedInAnArray.java)|
|[452](https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons)|Minimum Number of Arrows to Burst Balloons|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MinimumNumberOfArrowsToBurstBalloons.java)|
|[454](https://leetcode-cn.com/problems/4sum-ii)|4Sum II|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FourSumIi.java)|
|[455](https://leetcode-cn.com/problems/assign-cookies)|Assign Cookies|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/AssignCookies.java)|
|[456](https://leetcode-cn.com/problems/132-pattern)|132 Pattern|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/One32Pattern.java)|
|[461](https://leetcode-cn.com/problems/hamming-distance)|Hamming Distance|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/HammingDistance.java)|
|[477](https://leetcode-cn.com/problems/total-hamming-distance)|Total Hamming Distance|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/TotalHammingDistance.java)|
|[480](https://leetcode-cn.com/problems/sliding-window-median)|Sliding Window Median|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SlidingWindowMedian.java)|
|[485](https://leetcode-cn.com/problems/max-consecutive-ones)|Max Consecutive Ones|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaxConsecutiveOnes.java)|
|[494](https://leetcode-cn.com/problems/target-sum)|Target Sum|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/TargetSum.java)|
|[503](https://leetcode-cn.com/problems/next-greater-element-ii)|Next Greater Element II|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/NextGreaterElementIi.java)|
|[509](https://leetcode-cn.com/problems/fibonacci-number)|Fibonacci Number|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FibonacciNumber.java)|
|[523](https://leetcode-cn.com/problems/continuous-subarray-sum)|Continuous Subarray Sum|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ContinuousSubarraySum.java)|
|[525](https://leetcode-cn.com/problems/contiguous-array)|Contiguous Array|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ContiguousArray.java)|
|[538](https://leetcode-cn.com/problems/convert-bst-to-greater-tree)|Convert BST to Greater Tree|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ConvertBstToGreaterTree.java)|
|[543](https://leetcode-cn.com/problems/diameter-of-binary-tree)|Diameter of Binary Tree|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DiameterOfBinaryTree.java)|
|[547](https://leetcode-cn.com/problems/number-of-provinces)|Number of Provinces|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/NumberOfProvinces.java)|
|[554](https://leetcode-cn.com/problems/brick-wall)|Brick Wall|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BrickWall.java)|
|[560](https://leetcode-cn.com/problems/subarray-sum-equals-k)|Subarray Sum Equals K|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SubarraySumEqualsK.java)|
|[561](https://leetcode-cn.com/problems/array-partition-i)|Array Partition I|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ArrayPartitionI.java)|
|[566](https://leetcode-cn.com/problems/reshape-the-matrix)|Reshape the Matrix|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ReshapeTheMatrix.java)|
|[567](https://leetcode-cn.com/problems/permutation-in-string)|Permutation in String|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PermutationInString.java)|
|[581](https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray)|Shortest Unsorted Continuous Subarray|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ShortestUnsortedContinuousSubarray.java)|
|[605](https://leetcode-cn.com/problems/can-place-flowers)|Can Place Flowers|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CanPlaceFlowers.java)|
|[617](https://leetcode-cn.com/problems/merge-two-binary-trees)|Merge Two Binary Trees|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MergeTwoBinaryTrees.java)|
|[621](https://leetcode-cn.com/problems/task-scheduler)|Task Scheduler|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/TaskScheduler.java)|
|[628](https://leetcode-cn.com/problems/maximum-product-of-three-numbers)|Maximum Product of Three Numbers|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaximumProductOfThreeNumbers.java)|
|[633](https://leetcode-cn.com/problems/sum-of-square-numbers)|Sum of Square Numbers|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SumOfSquareNumbers.java)|
|[643](https://leetcode-cn.com/problems/maximum-average-subarray-i)|Maximum Average Subarray I|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaximumAverageSubarrayI.java)|
|[647](https://leetcode-cn.com/problems/palindromic-substrings)|Palindromic Substrings|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PalindromicSubstrings.java)|
|[664](https://leetcode-cn.com/problems/strange-printer)|Strange Printer|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/StrangePrinter.java)|
|[665](https://leetcode-cn.com/problems/non-decreasing-array)|Non-decreasing Array|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/NonDecreasingArray.java)|
|[674](https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence)|Longest Continuous Increasing Subsequence|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LongestContinuousIncreasingSubsequence.java)|
|[684](https://leetcode-cn.com/problems/redundant-connection)|Redundant Connection|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RedundantConnection.java)|
|[690](https://leetcode-cn.com/problems/employee-importance)|Employee Importance|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/EmployeeImportance.java)|
|[692](https://leetcode-cn.com/problems/top-k-frequent-words)|Top K Frequent Words|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/TopKFrequentWords.java)|
|[697](https://leetcode-cn.com/problems/degree-of-an-array)|Degree of an Array|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DegreeOfAnArray.java)|
|[703](https://leetcode-cn.com/problems/kth-largest-element-in-a-stream)|Kth Largest Element in a Stream|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/KthLargestElementInAStream.java)|
|[705](https://leetcode-cn.com/problems/design-hashset)|Design HashSet|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DesignHashset.java)|
|[706](https://leetcode-cn.com/problems/design-hashmap)|Design HashMap|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DesignHashmap.java)|
|[709](https://leetcode-cn.com/problems/to-lower-case)|To Lower Case|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ToLowerCase.java)|
|[713](https://leetcode-cn.com/problems/subarray-product-less-than-k)|Subarray Product Less Than K|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SubarrayProductLessThanK.java)|
|[714](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee)|Best Time to Buy and Sell Stock with Transaction Fee|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BestTimeToBuyAndSellStockWithTransactionFee.java)|
|[721](https://leetcode-cn.com/problems/accounts-merge)|Accounts Merge|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/AccountsMerge.java)|
|[724](https://leetcode-cn.com/problems/find-pivot-index)|Find Pivot Index|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FindPivotIndex.java)|
|[738](https://leetcode-cn.com/problems/monotone-increasing-digits)|Monotone Increasing Digits|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MonotoneIncreasingDigits.java)|
|[739](https://leetcode-cn.com/problems/daily-temperatures)|Daily Temperatures|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DailyTemperatures.java)|
|[740](https://leetcode-cn.com/problems/delete-and-earn)|Delete and Earn|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DeleteAndEarn.java)|
|[746](https://leetcode-cn.com/problems/min-cost-climbing-stairs)|Min Cost Climbing Stairs|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MinCostClimbingStairs.java)|
|[765](https://leetcode-cn.com/problems/couples-holding-hands)|Couples Holding Hands|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CouplesHoldingHands.java)|
|[766](https://leetcode-cn.com/problems/toeplitz-matrix)|Toeplitz Matrix|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ToeplitzMatrix.java)|
|[767](https://leetcode-cn.com/problems/reorganize-string)|Reorganize String|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ReorganizeString.java)|
|[781](https://leetcode-cn.com/problems/rabbits-in-forest)|Rabbits in Forest|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RabbitsInForest.java)|
|[783](https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes)|Minimum Distance Between BST Nodes|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MinimumDistanceBetweenBstNodes.java)|
|[830](https://leetcode-cn.com/problems/positions-of-large-groups)|Positions of Large Groups|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PositionsOfLargeGroups.java)|
|[832](https://leetcode-cn.com/problems/flipping-an-image)|Flipping an Image|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FlippingAnImage.java)|
|[860](https://leetcode-cn.com/problems/lemonade-change)|Lemonade Change|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LemonadeChange.java)|
|[867](https://leetcode-cn.com/problems/transpose-matrix)|Transpose Matrix|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/TransposeMatrix.java)|
|[872](https://leetcode-cn.com/problems/leaf-similar-trees)|Leaf-Similar Trees|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LeafSimilarTrees.java)|
|[888](https://leetcode-cn.com/problems/fair-candy-swap)|Fair Candy Swap|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FairCandySwap.java)|
|[896](https://leetcode-cn.com/problems/monotonic-array)|Monotonic Array|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MonotonicArray.java)|
|[897](https://leetcode-cn.com/problems/increasing-order-search-tree)|Increasing Order Search Tree|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/IncreasingOrderSearchTree.java)|
|[922](https://leetcode-cn.com/problems/sort-array-by-parity-ii)|Sort Array By Parity II|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SortArrayByParityIi.java)|
|[938](https://leetcode-cn.com/problems/range-sum-of-bst)|Range Sum of BST|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RangeSumOfBst.java)|
|[951](https://leetcode-cn.com/problems/flip-equivalent-binary-trees)|Flip Equivalent Binary Trees|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FlipEquivalentBinaryTrees.java)|
|[959](https://leetcode-cn.com/problems/regions-cut-by-slashes)|Regions Cut By Slashes|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RegionsCutBySlashes.java)|
|[978](https://leetcode-cn.com/problems/longest-turbulent-subarray)|Longest Turbulent Subarray|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LongestTurbulentSubarray.java)|
|[989](https://leetcode-cn.com/problems/add-to-array-form-of-integer)|Add to Array-Form of Integer|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/AddToArrayFormOfInteger.java)|
|[992](https://leetcode-cn.com/problems/subarrays-with-k-different-integers)|Subarrays with K Different Integers|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SubarraysWithKDifferentIntegers.java)|
|[993](https://leetcode-cn.com/problems/cousins-in-binary-tree)|Cousins in Binary Tree|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CousinsInBinaryTree.java)|
|[995](https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips)|Minimum Number of K Consecutive Bit Flips|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MinimumNumberOfKConsecutiveBitFlips.java)|
|[1004](https://leetcode-cn.com/problems/max-consecutive-ones-iii)|Max Consecutive Ones III|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaxConsecutiveOnesIii.java)|
|[1006](https://leetcode-cn.com/problems/clumsy-factorial)|Clumsy Factorial|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ClumsyFactorial.java)|
|[1011](https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days)|Capacity To Ship Packages Within D Days|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CapacityToShipPackagesWithinDDays.java)|
|[1018](https://leetcode-cn.com/problems/binary-prefix-divisible-by-5)|Binary Prefix Divisible By 5|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BinaryPrefixDivisibleBy5.java)|
|[1030](https://leetcode-cn.com/problems/matrix-cells-in-distance-order)|Matrix Cells in Distance Order|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MatrixCellsInDistanceOrder.java)|
|[1035](https://leetcode-cn.com/problems/uncrossed-lines)|Uncrossed Lines|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/UncrossedLines.java)|
|[1046](https://leetcode-cn.com/problems/last-stone-weight)|Last Stone Weight|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LastStoneWeight.java)|
|[1047](https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string)|Remove All Adjacent Duplicates In String|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RemoveAllAdjacentDuplicatesInString.java)|
|[1052](https://leetcode-cn.com/problems/grumpy-bookstore-owner)|Grumpy Bookstore Owner|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/GrumpyBookstoreOwner.java)|
|[1074](https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target)|Number of Submatrices That Sum to Target|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/NumberOfSubmatricesThatSumToTarget.java)|
|[1122](https://leetcode-cn.com/problems/relative-sort-array)|Relative Sort Array|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/RelativeSortArray.java)|
|[1128](https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs)|Number of Equivalent Domino Pairs|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/NumberOfEquivalentDominoPairs.java)|
|[1143](https://leetcode-cn.com/problems/longest-common-subsequence)|Longest Common Subsequence|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LongestCommonSubsequence.java)|
|[1178](https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle)|Number of Valid Words for Each Puzzle|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/NumberOfValidWordsForEachPuzzle.java)|
|[1190](https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses)|Reverse Substrings Between Each Pair of Parentheses|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/ReverseSubstringsBetweenEachPairOfParentheses.java)|
|[1202](https://leetcode-cn.com/problems/smallest-string-with-swaps)|Smallest String With Swaps|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SmallestStringWithSwaps.java)|
|[1208](https://leetcode-cn.com/problems/get-equal-substrings-within-budget)|Get Equal Substrings Within Budget|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/GetEqualSubstringsWithinBudget.java)|
|[1211](https://leetcode-cn.com/problems/queries-quality-and-percentage)|Queries Quality and Percentage|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/BestTimeToBuyAndSellStock.java)|
|[1232](https://leetcode-cn.com/problems/check-if-it-is-a-straight-line)|Check If It Is a Straight Line|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CheckIfItIsAStraightLine.java)|
|[1269](https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps)|Number of Ways to Stay in the Same Place After Some Steps|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/NumberOfWaysToStayInTheSamePlaceAfterSomeSteps.java)|
|[1310](https://leetcode-cn.com/problems/xor-queries-of-a-subarray)|XOR Queries of a Subarray|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/XorQueriesOfASubarray.java)|
|[1370](https://leetcode-cn.com/problems/increasing-decreasing-string)|Increasing Decreasing String|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/IncreasingDecreasingString.java)|
|[1423](https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards)|Maximum Points You Can Obtain from Cards|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaximumPointsYouCanObtainFromCards.java)|
|[1438](https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit)|Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit.java)|
|[1442](https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor)|Count Triplets That Can Form Two Arrays of Equal XOR|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CountTripletsThatCanFormTwoArraysOfEqualXor.java)|
|[1473](https://leetcode-cn.com/problems/paint-house-iii)|Paint House III|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PaintHouseIii.java)|
|[1482](https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets)|Minimum Number of Days to Make m Bouquets|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MinimumNumberOfDaysToMakeMBouquets.java)|
|[1486](https://leetcode-cn.com/problems/xor-operation-in-an-array)|XOR Operation in an Array|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/XorOperationInAnArray.java)|
|[1603](https://leetcode-cn.com/problems/design-parking-system)|Design Parking System|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DesignParkingSystem.java)|
|[1631](https://leetcode-cn.com/problems/path-with-minimum-effort)|Path With Minimum Effort|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/PathWithMinimumEffort.java)|
|[1707](https://leetcode-cn.com/problems/maximum-xor-with-an-element-from-array)|Maximum XOR With an Element From Array|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MaximumXorWithAnElementFromArray.java)|
|[1720](https://leetcode-cn.com/problems/decode-xored-array)|Decode XORed Array|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DecodeXoredArray.java)|
|[1723](https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs)|Find Minimum Time to Finish All Jobs|hard|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FindMinimumTimeToFinishAllJobs.java)|
|[1734](https://leetcode-cn.com/problems/decode-xored-permutation)|Decode XORed Permutation|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/DecodeXoredPermutation.java)|
|[1738](https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value)|Find Kth Largest XOR Coordinate Value|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FindKthLargestXorCoordinateValue.java)|
|[1744](https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day)|Can You Eat Your Favorite Candy on Your Favorite Day?|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/CanYouEatYourFavoriteCandyOnYourFavoriteDay.java)|
|[1758](https://leetcode-cn.com/problems/minimum-changes-to-make-alternating-binary-string)|Minimum Changes To Make Alternating Binary String|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/MinimumChangesToMakeAlternatingBinaryString.java)|
|[1822](https://leetcode-cn.com/problems/sign-of-the-product-of-an-array)|Sign of the Product of an Array|easy|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/SignOfTheProductOfAnArray.java)|
|[1823](https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game)|Find the Winner of the Circular Game|medium|[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/FindTheWinnerOfTheCircularGame.java)|
