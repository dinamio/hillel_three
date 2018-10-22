package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Integer[] array = {10, 5, 30, 15, 36, 88, 23};
        System.out.println(Arrays.asList(array).stream().max(Integer::compareTo).get());

    }
}
