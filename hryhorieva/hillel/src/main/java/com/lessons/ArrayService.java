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

    public int findMaxValue(int[] arr){
        int maxValue = arr[0];
        for(int currentInteger: arr){
            if(currentInteger > maxValue){
                maxValue = currentInteger;
            }
        }
        return maxValue;
    }
}
