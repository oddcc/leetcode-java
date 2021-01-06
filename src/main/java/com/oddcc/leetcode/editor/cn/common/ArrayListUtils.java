package com.oddcc.leetcode.editor.cn.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface ArrayListUtils {
    static <E> List<E> arrayToList(E[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    static <E> List<List<E>> arrayToList(E[][] array) {
        List<List<E>> l = new ArrayList<>();
        for (E[] arr : array) {
            l.add(arrayToList(arr));
        }
        return l;
    }
}
