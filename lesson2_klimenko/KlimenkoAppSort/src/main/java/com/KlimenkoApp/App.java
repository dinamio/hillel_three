package com.KlimenkoApp;

import com.klimenko.Math;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Integer[] array = new Integer[10];

        System.out.println("Array list sorted by ascending");
        try {
            Math.initArray(array);
            Math.sortedArray(array, true);
            Arrays.asList(array).forEach(System.out::println);
        } catch (NullPointerException e) {
            System.out.println("Wrong array");
            return;
        }

        System.out.println("Array list sorted by descending");
        Math.initArray(array);
        Math.sortedArray(array, false);
        Arrays.asList(array).forEach(System.out::println);

    }
}
