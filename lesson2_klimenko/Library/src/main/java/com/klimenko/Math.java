package com.klimenko;

import org.jetbrains.annotations.Contract;

import java.util.Random;

public class Math {
    /**
     * Sorting array
     *
     * @param arrayForSort array witch will be sorted
     * @param directSort   sorting direction: true - ascending; false - descending
     * @return if it works, will return sorted array. if something wrong - NULL;
     */
    public static Integer[] sortedArray(Integer[] arrayForSort, boolean directSort) throws NullPointerException {

        if (checkArray(arrayForSort)) return null;

        if (isArraySorted(arrayForSort, directSort)) return arrayForSort;

        int tempVariable = 0;
        for (int i = 0; i < arrayForSort.length; i++)
            for (int k = 0; k < arrayForSort.length - 1 - i; k++)
                if (directSort == (arrayForSort[k] > arrayForSort[k + 1])) {

                    tempVariable = arrayForSort[k];
                    arrayForSort[k] = arrayForSort[k + 1];
                    arrayForSort[k + 1] = tempVariable;

                }

        return arrayForSort;
    }

    @Contract(value = "null -> true", pure = true)
    private static boolean checkArray(Integer[] initArray) {
        if (initArray == null || initArray.length == 0) {
            return true;
        }
        return false;
    }

    public static boolean isArraySorted(Integer[] array, boolean directSort) {
        for (int i = 0; i < array.length - 1; i++) {
            if (directSort != (array[i] > array[i + 1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * fill array random value
     *
     * @param initArray
     * @return if it works, will return sorted array. if something wrong - NULL;
     */
    public static Integer[] initArray(Integer[] initArray) {

        if (checkArray(initArray)) return null;
        Random random = new Random();
        for (int i = 0; i < initArray.length; i++) {
            initArray[i] = random.nextInt(25);
        }
        return initArray;
    }

}
