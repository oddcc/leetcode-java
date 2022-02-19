package com.oddcc.leetcode.editor.cn.common;

public interface StringUtils {
    static String repeat(String str, Integer count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
