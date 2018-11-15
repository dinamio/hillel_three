package com.lessons;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SortingTest {
    @Test
    public void shouldSortArrayASC(){
        ArrayService arrayService = new ArrayService();
        int unsortedArray[] = {4,2,8,1};
        int realResult[] = arrayService.sortASCArray(unsortedArray);
        int expectedResult[] = {1,2,4,8};
        for(int i = 0; i<expectedResult.length; i++){
            assertEquals(expectedResult[i], realResult[i]);
        }
    }

    @Test
    public void shouldSortArrayDDESC(){
        ArrayService arrayService = new ArrayService();
        int unsortedArray[] = {4,2,8,1};
        int realResult[] = arrayService.sortDESCArray(unsortedArray);
        int expectedResult[] = {8,4,2,1};
        for(int i = 0; i<expectedResult.length; i++){
            assertEquals(expectedResult[i], realResult[i]);
        }
    }

    @Test
    public void shouldReceiveNullWhenSortEmptyArray(){
        ArrayService arrayService = new ArrayService();
        int empty[] = {};
        Object result = arrayService.sortASCArray(empty);
        assertEquals(null, result);
    }

    @Test
    public void shouldReceiveNullWhenSortNullArray(){
        ArrayService arrayService = new ArrayService();
        int empty[] = null;
        Object result = arrayService.sortASCArray(empty);
        assertEquals(null, result);
    }
}
