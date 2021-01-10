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



