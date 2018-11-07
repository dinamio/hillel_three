package org.vasarray;

public class ArraySorting {

    public static void findMaxArrayElem ( int[] procArray){
        int maxValue = procArray[0];
        for (int i = 1; i < procArray.length; i++) {
            if (procArray[i] > maxValue) {
                maxValue = procArray[i];
            }
        }
        System.out.println("Максимальное значение в массиве: " + maxValue);
    }
}
