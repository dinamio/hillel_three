package com.lessons;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ArrayService arrayService = new ArrayService();
        int testArray[] = arrayService.createArray(10);
        int testEmptyArray[] = {};
        for(int currentInt: testArray){
            System.out.println(currentInt);
        }

        arrayService.printMaxValue(testArray);
        arrayService.printMaxValue(testEmptyArray);
    }
}
