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
目前已有219道题，不断添加中…
|ID|标题|难度|CODE|
| ---- | ---- | ---- | ---- |
|6|ZigZag Conversion|medium|[url](baidu.com)|
|7|Reverse Integer|easy|[url](baidu.com)|
|12|Integer to Roman|medium|[url](baidu.com)|
|13|Roman to Integer|easy|[url](baidu.com)|
|26|Remove Duplicates from Sorted Array|easy|[url](baidu.com)|
|27|Remove Element|easy|[url](baidu.com)|
|28|Implement strStr()|easy|[url](baidu.com)|
|30|Substring with Concatenation of All Words|hard|[url](baidu.com)|
|41|First Missing Positive|hard|[url](baidu.com)|
|42|Trapping Rain Water|hard|[url](baidu.com)|
|49|Group Anagrams|medium|[url](baidu.com)|
|54|Spiral Matrix|medium|[url](baidu.com)|
|55|Jump Game|medium|[url](baidu.com)|
|59|Spiral Matrix II|medium|[url](baidu.com)|
|61|Rotate List|medium|[url](baidu.com)|
|62|Unique Paths|medium|[url](baidu.com)|
|73|Set Matrix Zeroes|medium|[url](baidu.com)|
|74|Search a 2D Matrix|medium|[url](baidu.com)|
|80|Remove Duplicates from Sorted Array II|medium|[url](baidu.com)|
|81|Search in Rotated Sorted Array II|medium|[url](baidu.com)|
|82|Remove Duplicates from Sorted List II|medium|[url](baidu.com)|
|84|Largest Rectangle in Histogram|hard|[url](baidu.com)|
|87|Scramble String|hard|[url](baidu.com)|
|90|Subsets II|medium|[url](baidu.com)|
|91|Decode Ways|medium|[url](baidu.com)|
|92|Reverse Linked List II|medium|[url](baidu.com)|
|103|Binary Tree Zigzag Level Order Traversal|medium|[url](baidu.com)|
|115|Distinct Subsequences|hard|[url](baidu.com)|
|119|Pascal's Triangle II|easy|[url](baidu.com)|
|131|Palindrome Partitioning|medium|[url](baidu.com)|
|132|Palindrome Partitioning II|hard|[url](baidu.com)|
|134|Gas Station|medium|[url](baidu.com)|
|135|Candy|hard|[url](baidu.com)|
|137|Single Number II|medium|[url](baidu.com)|
|145|Binary Tree Postorder Traversal|easy|[url](baidu.com)|
|146|LRU Cache|medium|[url](baidu.com)|
|147|Insertion Sort List|medium|[url](baidu.com)|
|150|Evaluate Reverse Polish Notation|medium|[url](baidu.com)|
|153|Find Minimum in Rotated Sorted Array|medium|[url](baidu.com)|
|154|Find Minimum in Rotated Sorted Array II|hard|[url](baidu.com)|
|164|Maximum Gap|hard|[url](baidu.com)|
|169|Majority Element|easy|[url](baidu.com)|
|173|Binary Search Tree Iterator|medium|[url](baidu.com)|
|179|Largest Number|medium|[url](baidu.com)|
|189|Rotate Array|medium|[url](baidu.com)|
|190|Reverse Bits|easy|[url](baidu.com)|
|191|Number of 1 Bits|easy|[url](baidu.com)|
|202|Happy Number|easy|[url](baidu.com)|
|203|Remove Linked List Elements|easy|[url](baidu.com)|
|204|Count Primes|easy|[url](baidu.com)|
|205|Isomorphic Strings|easy|[url](baidu.com)|
|208|Implement Trie (Prefix Tree)|medium|[url](baidu.com)|
|209|Minimum Size Subarray Sum|medium|[url](baidu.com)|
|213|House Robber II|medium|[url](baidu.com)|
|215|Kth Largest Element in an Array|medium|[url](baidu.com)|
|217|Contains Duplicate|easy|[url](baidu.com)|
|220|Contains Duplicate III|medium|[url](baidu.com)|
|221|Maximal Square|medium|[url](baidu.com)|
|222|Count Complete Tree Nodes|medium|[url](baidu.com)|
|224|Basic Calculator|hard|[url](baidu.com)|
|225|Implement Stack using Queues|easy|[url](baidu.com)|
|227|Basic Calculator II|medium|[url](baidu.com)|
|228|Summary Ranges|easy|[url](baidu.com)|
|231|Power of Two|easy|[url](baidu.com)|
|232|Implement Queue using Stacks|easy|[url](baidu.com)|
|235|Lowest Common Ancestor of a Binary Search Tree|easy|[url](baidu.com)|
|236|Lowest Common Ancestor of a Binary Tree|medium|[url](baidu.com)|
|237|Delete Node in a Linked List|easy|[url](baidu.com)|
|238|Product of Array Except Self|medium|[url](baidu.com)|
|240|Search a 2D Matrix II|medium|[url](baidu.com)|
|242|Valid Anagram|easy|[url](baidu.com)|
|257|Binary Tree Paths|easy|[url](baidu.com)|
|263|Ugly Number|easy|[url](baidu.com)|
|264|Ugly Number II|medium|[url](baidu.com)|
|279|Perfect Squares|medium|[url](baidu.com)|
|283|Move Zeroes|easy|[url](baidu.com)|
|287|Find the Duplicate Number|medium|[url](baidu.com)|
|290|Word Pattern|easy|[url](baidu.com)|
|300|Longest Increasing Subsequence|medium|[url](baidu.com)|
|303|Range Sum Query - Immutable|easy|[url](baidu.com)|
|304|Range Sum Query 2D - Immutable|medium|[url](baidu.com)|
|309|Best Time to Buy and Sell Stock with Cooldown|medium|[url](baidu.com)|
|316|Remove Duplicate Letters|medium|[url](baidu.com)|
|322|Coin Change|medium|[url](baidu.com)|
|328|Odd Even Linked List|medium|[url](baidu.com)|
|331|Verify Preorder Serialization of a Binary Tree|medium|[url](baidu.com)|
|337|House Robber III|medium|[url](baidu.com)|
|338|Counting Bits|easy|[url](baidu.com)|
|341|Flatten Nested List Iterator|medium|[url](baidu.com)|
|342|Power of Four|easy|[url](baidu.com)|
|343|Integer Break|medium|[url](baidu.com)|
|347|Top K Frequent Elements|medium|[url](baidu.com)|
|354|Russian Doll Envelopes|hard|[url](baidu.com)|
|363|Max Sum of Rectangle No Larger Than K|hard|[url](baidu.com)|
|368|Largest Divisible Subset|medium|[url](baidu.com)|
|377|Combination Sum IV|medium|[url](baidu.com)|
|387|First Unique Character in a String|easy|[url](baidu.com)|
|394|Decode String|medium|[url](baidu.com)|
|395|Longest Substring with At Least K Repeating Characters|medium|[url](baidu.com)|
|399|Evaluate Division|medium|[url](baidu.com)|
|403|Frog Jump|hard|[url](baidu.com)|
|406|Queue Reconstruction by Height|medium|[url](baidu.com)|
|415|Add Strings|easy|[url](baidu.com)|
|416|Partition Equal Subset Sum|medium|[url](baidu.com)|
|421|Maximum XOR of Two Numbers in an Array|medium|[url](baidu.com)|
|424|Longest Repeating Character Replacement|medium|[url](baidu.com)|
|435|Non-overlapping Intervals|medium|[url](baidu.com)|
|437|Path Sum III|medium|[url](baidu.com)|
|438|Find All Anagrams in a String|medium|[url](baidu.com)|
|448|Find All Numbers Disappeared in an Array|easy|[url](baidu.com)|
|452|Minimum Number of Arrows to Burst Balloons|medium|[url](baidu.com)|
|454|4Sum II|medium|[url](baidu.com)|
|455|Assign Cookies|easy|[url](baidu.com)|
|456|132 Pattern|medium|[url](baidu.com)|
|461|Hamming Distance|easy|[url](baidu.com)|
|477|Total Hamming Distance|medium|[url](baidu.com)|
|480|Sliding Window Median|hard|[url](baidu.com)|
|485|Max Consecutive Ones|easy|[url](baidu.com)|
|494|Target Sum|medium|[url](baidu.com)|
|503|Next Greater Element II|medium|[url](baidu.com)|
|509|Fibonacci Number|easy|[url](baidu.com)|
|523|Continuous Subarray Sum|medium|[url](baidu.com)|
|525|Contiguous Array|medium|[url](baidu.com)|
|538|Convert BST to Greater Tree|medium|[url](baidu.com)|
|543|Diameter of Binary Tree|easy|[url](baidu.com)|
|547|Number of Provinces|medium|[url](baidu.com)|
|554|Brick Wall|medium|[url](baidu.com)|
|560|Subarray Sum Equals K|medium|[url](baidu.com)|
|561|Array Partition I|easy|[url](baidu.com)|
|566|Reshape the Matrix|easy|[url](baidu.com)|
|567|Permutation in String|medium|[url](baidu.com)|
|581|Shortest Unsorted Continuous Subarray|medium|[url](baidu.com)|
|605|Can Place Flowers|easy|[url](baidu.com)|
|617|Merge Two Binary Trees|easy|[url](baidu.com)|
|621|Task Scheduler|medium|[url](baidu.com)|
|628|Maximum Product of Three Numbers|easy|[url](baidu.com)|
|633|Sum of Square Numbers|medium|[url](baidu.com)|
|643|Maximum Average Subarray I|easy|[url](baidu.com)|
|647|Palindromic Substrings|medium|[url](baidu.com)|
|664|Strange Printer|hard|[url](baidu.com)|
|665|Non-decreasing Array|easy|[url](baidu.com)|
|674|Longest Continuous Increasing Subsequence|easy|[url](baidu.com)|
|684|Redundant Connection|medium|[url](baidu.com)|
|690|Employee Importance|easy|[url](baidu.com)|
|692|Top K Frequent Words|medium|[url](baidu.com)|
|697|Degree of an Array|easy|[url](baidu.com)|
|703|Kth Largest Element in a Stream|easy|[url](baidu.com)|
|705|Design HashSet|easy|[url](baidu.com)|
|706|Design HashMap|easy|[url](baidu.com)|
|709|To Lower Case|easy|[url](baidu.com)|
|713|Subarray Product Less Than K|medium|[url](baidu.com)|
|714|Best Time to Buy and Sell Stock with Transaction Fee|medium|[url](baidu.com)|
|721|Accounts Merge|medium|[url](baidu.com)|
|724|Find Pivot Index|easy|[url](baidu.com)|
|738|Monotone Increasing Digits|medium|[url](baidu.com)|
|739|Daily Temperatures|medium|[url](baidu.com)|
|740|Delete and Earn|medium|[url](baidu.com)|
|746|Min Cost Climbing Stairs|easy|[url](baidu.com)|
|765|Couples Holding Hands|hard|[url](baidu.com)|
|766|Toeplitz Matrix|easy|[url](baidu.com)|
|767|Reorganize String|medium|[url](baidu.com)|
|781|Rabbits in Forest|medium|[url](baidu.com)|
|783|Minimum Distance Between BST Nodes|easy|[url](baidu.com)|
|830|Positions of Large Groups|easy|[url](baidu.com)|
|832|Flipping an Image|easy|[url](baidu.com)|
|860|Lemonade Change|easy|[url](baidu.com)|
|867|Transpose Matrix|easy|[url](baidu.com)|
|872|Leaf-Similar Trees|easy|[url](baidu.com)|
|888|Fair Candy Swap|easy|[url](baidu.com)|
|896|Monotonic Array|easy|[url](baidu.com)|
|897|Increasing Order Search Tree|easy|[url](baidu.com)|
|922|Sort Array By Parity II|easy|[url](baidu.com)|
|938|Range Sum of BST|easy|[url](baidu.com)|
|951|Flip Equivalent Binary Trees|medium|[url](baidu.com)|
|959|Regions Cut By Slashes|medium|[url](baidu.com)|
|978|Longest Turbulent Subarray|medium|[url](baidu.com)|
|989|Add to Array-Form of Integer|easy|[url](baidu.com)|
|992|Subarrays with K Different Integers|hard|[url](baidu.com)|
|993|Cousins in Binary Tree|easy|[url](baidu.com)|
|995|Minimum Number of K Consecutive Bit Flips|hard|[url](baidu.com)|
|1004|Max Consecutive Ones III|medium|[url](baidu.com)|
|1006|Clumsy Factorial|medium|[url](baidu.com)|
|1011|Capacity To Ship Packages Within D Days|medium|[url](baidu.com)|
|1018|Binary Prefix Divisible By 5|easy|[url](baidu.com)|
|1030|Matrix Cells in Distance Order|easy|[url](baidu.com)|
|1035|Uncrossed Lines|medium|[url](baidu.com)|
|1046|Last Stone Weight|easy|[url](baidu.com)|
|1047|Remove All Adjacent Duplicates In String|easy|[url](baidu.com)|
|1052|Grumpy Bookstore Owner|medium|[url](baidu.com)|
|1074|Number of Submatrices That Sum to Target|hard|[url](baidu.com)|
|1122|Relative Sort Array|easy|[url](baidu.com)|
|1128|Number of Equivalent Domino Pairs|easy|[url](baidu.com)|
|1143|Longest Common Subsequence|medium|[url](baidu.com)|
|1178|Number of Valid Words for Each Puzzle|hard|[url](baidu.com)|
|1190|Reverse Substrings Between Each Pair of Parentheses|medium|[url](baidu.com)|
|1202|Smallest String With Swaps|medium|[url](baidu.com)|
|1208|Get Equal Substrings Within Budget|medium|[url](baidu.com)|
|1211|Queries Quality and Percentage|easy|[url](baidu.com)|
|1232|Check If It Is a Straight Line|easy|[url](baidu.com)|
|1269|Number of Ways to Stay in the Same Place After Some Steps|hard|[url](baidu.com)|
|1310|XOR Queries of a Subarray|medium|[url](baidu.com)|
|1370|Increasing Decreasing String|easy|[url](baidu.com)|
|1423|Maximum Points You Can Obtain from Cards|medium|[url](baidu.com)|
|1438|Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit|medium|[url](baidu.com)|
|1442|Count Triplets That Can Form Two Arrays of Equal XOR|medium|[url](baidu.com)|
|1473|Paint House III|hard|[url](baidu.com)|
|1482|Minimum Number of Days to Make m Bouquets|medium|[url](baidu.com)|
|1486|XOR Operation in an Array|easy|[url](baidu.com)|
|1603|Design Parking System|easy|[url](baidu.com)|
|1631|Path With Minimum Effort|medium|[url](baidu.com)|
|1707|Maximum XOR With an Element From Array|hard|[url](baidu.com)|
|1720|Decode XORed Array|easy|[url](baidu.com)|
|1723|Find Minimum Time to Finish All Jobs|hard|[url](baidu.com)|
|1734|Decode XORed Permutation|medium|[url](baidu.com)|
|1738|Find Kth Largest XOR Coordinate Value|medium|[url](baidu.com)|
|1744|Can You Eat Your Favorite Candy on Your Favorite Day?|medium|[url](baidu.com)|
|1758|Minimum Changes To Make Alternating Binary String|easy|[url](baidu.com)|
|1822|Sign of the Product of an Array|easy|[url](baidu.com)|
|1823|Find the Winner of the Circular Game|medium|[url](baidu.com)|
