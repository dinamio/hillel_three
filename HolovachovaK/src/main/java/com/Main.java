package com;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Integer[] arr = {
                1, 8, 9, 10, 20, 34
        };
        List<Integer> arrayList;
        arrayList = Arrays.asList(arr);

        System.out.println(ArrayUtil.maxElement(arrayList));

    }
}
