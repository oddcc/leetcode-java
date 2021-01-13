# LeetCode Practices
LeetCode练习记录，JDK版本是11

可以通过题目名称的大驼峰来搜索，也可以通过题号来搜索，大体思路一般会在commit message里面，详细的思路一般会在注释中

项目拉下来直接导入IntelliJ IDEA就可以了，每道题都可以单独运行，已经带了一部分常见的测试用例



另外如果你也用IDEA刷题的话，推荐一下这个[插件](https://plugins.jetbrains.com/plugin/12132-leetcode-editor)，非常好用

我的习惯配置是

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

1. https://csacademy.com/app/graph_editor，可以根据“边”来构造图，有向图无向图都可以，在测试用例太大，你自己画不出来的时候可以用这个，方便找问题
2. https://graphonline.ru/en/?graph=Planar，除了手画之外，构造图不是很方便，但内置了多种算法演示，如果你能把图画出来，在上面演示非常方便，不理解算法中某一步的时候用