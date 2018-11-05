package com.lessons;

public class ArrayService {

    public int[] createArray(int arrayLength){
        int randomArray[] = new int[arrayLength];
        for (int i = 0; i< randomArray.length; i++){
            randomArray[i] = (int)(Math.random() * 100);
        }
        return randomArray;
    }

    public int[] sortASCArray(int[] unsortedArray){
        if(isEmpty(unsortedArray)){
            //System.out.println("The array is empty");
            return null;
        }

        int sortedArray[] = unsortedArray.clone();
        boolean changes;
        int max;
        do{
            changes = false;
            for(int i = 0; i<sortedArray.length-1; i++){
                if(sortedArray[i]>sortedArray[i+1]){
                    max = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = max;
                    changes = true;
                }
            }
        }while(changes);
        return sortedArray;
    }

    public int[] sortDESCArray(int[] unsortedArray){
        if(isEmpty(unsortedArray)){
            //System.out.println("The array is empty");
            return null;
        }

        int sortedArray[] = unsortedArray.clone();
        boolean changes;
        int min;
        do{
            changes = false;
            for(int i = 0; i<sortedArray.length-1; i++){
                if(sortedArray[i]<sortedArray[i+1]){
                    min = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = min;
                    changes = true;
                }
            }
        }while(changes);
        return sortedArray;
    }

    public boolean isEmpty(int[] arr){
        boolean res = false;
        boolean empty = true;
        if(arr == null){
            res=true;
            return res;
        }
        for (int currentInteger : arr) {
            if (currentInteger != 0) {
                empty = false;
                break;
            }
        }
        if(empty){
            res=true;
        }
        return res;
    }

    public void printArray(int[] arr){
        if(arr == null){
            System.out.println("The array is empty");
        }else{
            for(int item: arr){
                System.out.print(item + " ");
            }
        }
    }
}
