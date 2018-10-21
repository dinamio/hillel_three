package main.java;

import java.util.Scanner;

public class Array {
    private int arraySize;
    private int[] array = new int[arraySize];

    public void setArraySize(int arraySize){
        this.arraySize = arraySize;
    }

    public int getArraySize() {
        return arraySize;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }


    public void getUserArraySize() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size for array (from 1 to 32 767): ");
        int enteredValue = input.nextInt();
        if ((enteredValue >= 0) && (enteredValue > 32767)) {
            System.out.println("Incorrect value! Please try again!!");
            getUserArraySize();
        } else {
            setArraySize(enteredValue);
        }
    }

    public void fillArray() {
        int arraySize = getArraySize();
        int enteredValue;
        int[] array = new int[arraySize];
        Scanner input = new Scanner(System.in);

        for(int i = 0; i < arraySize; i++){
            System.out.println("Enter value(from -32 768 to 32 767) for element #" + (i + 1) + ": ");
            enteredValue = input.nextInt();
            if ((enteredValue >= -32768) && (enteredValue <= 32767)) {
                array[i] = enteredValue;
            } else {
                System.out.println("Incorrect value! Please try again!!");
                --i;
            }

        }
        setArray(array);
    }

    public void findMaxArrValue(int[] array) {
        int maxElement = array[0];

        for (int arrElement : array){
            if (maxElement < arrElement){
                maxElement = arrElement;
            }
        }
        System.out.println("Max value in the array is..." + maxElement);;
    }
}
