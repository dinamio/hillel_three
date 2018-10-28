package com.lessons;

import java.util.Date;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println("=============Test correct work of methods=============");
        ArrayService arrayService = new ArrayService();

        System.out.println("====Empty Array===");
        int emptyArray[] = arrayService.createArray(0);
        arrayService.printArray(arrayService.sortASCArray(emptyArray));

        System.out.println("====Unsorted Array===");
        int testArray[] = arrayService.createArray(5);
        arrayService.printArray(testArray);

        System.out.println("\n====Sorted Array ASC====");
        int sortedArray[] = arrayService.sortASCArray(testArray);
        arrayService.printArray(sortedArray);

        System.out.println("\n=====Original Array========");
        arrayService.printArray(testArray);

        System.out.println("\n====Sorted Array DESC====");
        int sortArray[] = arrayService.sortDESCArray(testArray);
        arrayService.printArray(sortArray);
    }
}
