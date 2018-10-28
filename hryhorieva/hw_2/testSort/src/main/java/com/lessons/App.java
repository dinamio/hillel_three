package com.lessons;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("=====testing joda-time======");
        Date juDate = new Date();
        DateTime dt = new DateTime(juDate);
        System.out.println(dt + "\n");


        System.out.println("=====Anther project for testing sortArray dependency==");
        ArrayService arrayService = new ArrayService();
        int testArray[] = arrayService.createArray(13);

        System.out.println("==========Unsorted Array ASC=============");
        arrayService.printArray(testArray);
        System.out.println("\n=======================================");

        System.out.println("==========Sorted Array ASC=============");
        int sortedArray[] = arrayService.sortASCArray(testArray);
        arrayService.printArray(sortedArray);

        System.out.println("\n==========Sorted Array DESC=============");
        int sortArray[] = arrayService.sortDESCArray(testArray);
        arrayService.printArray(sortArray);

    }
}
