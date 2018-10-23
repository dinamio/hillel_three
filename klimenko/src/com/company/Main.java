package com.company;

public class Main {

    public static void main(String[] args) {

        Integer[] array = {10, 5, 30, 15, 36, 88, 23};
        System.out.println("Max value of array " + findMaxValue(array));

    }

    public static int findMaxValue(Integer[] array) {

        if (array == null || array.length == 0) return 0;
        int maxValue = array[0];
        for (Integer currentValue : array) {
            if (currentValue > maxValue)
                maxValue = currentValue;

        }
        return maxValue;
    }
}
