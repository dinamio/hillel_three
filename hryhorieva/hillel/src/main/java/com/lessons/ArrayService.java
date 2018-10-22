package com.lessons;

import java.lang.reflect.Array;

public class ArrayService {

    public int[] createArray(int arrayLength){
        int randomArray[] = new int[arrayLength];
        for (int i = 0; i< randomArray.length; i++){
            randomArray[i] = (int)(Math.random() * 100);
        }
        return randomArray;
    }

    public Integer findMaxValue(int[] arr){
        boolean empty = true;
        for (int currentInteger : arr) {
            if (currentInteger != 0) {
                empty = false;
                break;
            }
        }
        if(empty || arr == null){
            return null;
        }
        Integer maxValue = arr[0];
        for(int currentInteger: arr){
            if(currentInteger > maxValue){
                maxValue = currentInteger;
            }
        }
        return maxValue;
    }

    public void printMaxValue(int[] arr){
        if(findMaxValue(arr) == null){
            System.out.println("The array is empty");
        }else{
            System.out.println("The greatest number in array is: " + findMaxValue(arr));
        }
    }
}
