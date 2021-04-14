// 208

package com.oddcc.leetcode.editor.cn;

public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        ImplementTriePrefixTree test = new ImplementTriePrefixTree();
        test.test();
    }

    private void test() {
        Trie obj = new Trie();
        obj.insert("apple");
        System.out.println(obj.search("apple")); // true
        System.out.println(obj.search("app")); // false
        System.out.println(obj.startsWith("app")); // true
        obj.insert("app");
        System.out.println(obj.search("app")); // true
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        private class Node {
            boolean isLast;
            Node[] children = new Node[26];

            public Node(boolean isLast) {
                this.isLast = isLast;
            }
        }

        private Node root;

        /** Initialize your data structure here. */
        public Trie() {
            this.root = new Node(false);
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node cur = this.root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                // 如果碰到节点不存在，则要新建，还要看是否是结尾的字符
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Node(i == word.length() - 1);
                }
                // 如果节点存在，要看是不是结尾的字符，是的话isLast标为true
                else {
                    if (i == word.length() - 1) {
                        cur.children[c - 'a'].isLast = true;
                    }
                }
                cur = cur.children[c - 'a'];
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            return find(word, false);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return find(prefix, true);
        }

        private boolean find(String word, Boolean isPrefix) {
            Node cur = this.root;
            // 从root开始找word.length()次，如果中间节点就为null，说明不存在
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                cur = cur.children[c - 'a'];
                if (cur == null) return false;
            }
            // 如果找完了word.length()次没有碰到null，则看找的是什么分别处理
            if (isPrefix) return true;
            return cur.isLast;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}