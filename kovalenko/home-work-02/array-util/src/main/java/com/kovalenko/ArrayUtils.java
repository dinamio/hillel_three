package com.kovalenko;

public class ArrayUtils {

    public static void sort(int[] array) {

        validate(array);

        int temp;

        for (int i = 0; i < array.length; i++) {

            for (int j = i + 1; j < array.length; j++) {

                if (array[i] > array[j]) {

                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    public static void reverse(int[] array) {

        validate(array);

        int temp;

        for (int i = 0; i < array.length / 2; i++) {

            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }

    }

    private static void validate(int[] array) {

        if (array == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Argument is empty");
        }
    }
}
