package com.klimenko;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testSortingByDescending() {

        Integer[] nonSortArray = {5, 6, 8, 0, 4, 3, 5};
        Integer[] sortedArray = {0, 3, 4, 5, 5, 6, 8};



        if (nonSortArray.length != sortedArray.length) {
            assertTrue(false);
        }

        Math.sortedArray(nonSortArray, true);
        for (int i = 0; i < nonSortArray.length; i++)
            if (sortedArray[i] != nonSortArray[i]) {
                assertTrue(false);
            }
        assertTrue(true);
    }
    @Test
    public void testSortingByAscending() {

        Integer[] nonSortArray = {5, 6, 8, 0, 4, 3, 5};
        Integer[] sortedArray = {8, 6, 5, 5, 4, 3, 0};

        if (nonSortArray.length != sortedArray.length) {
            assertTrue(false);
        }

        Math.sortedArray(nonSortArray, false);
        for (int i = 0; i < nonSortArray.length; i++)
            if (sortedArray[i] != nonSortArray[i])
                assertTrue(false);
        assertTrue(true);
    }

}
