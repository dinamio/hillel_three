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
        for(int currentInt: testArray){
            System.out.println(currentInt);
        }

        System.out.println("The greatest number in array is: " + arrayService.findMaxValue(testArray));
    }
}
