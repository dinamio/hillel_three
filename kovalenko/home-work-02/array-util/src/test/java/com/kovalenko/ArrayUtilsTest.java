package com.kovalenko;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class ArrayUtilsTest {

    @RunWith(Parameterized.class)
    public static class ArrayUtilsParamTest {

        @Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                    {
                            new int[]{1,-2,-2,-1,-8,0,0,-50,-1,-10,80},
                            new int[]{-50, -10, -8, -2, -2, -1, -1, 0, 0, 1, 80},
                            new int[]{80, 1, 0, 0, -1, -1, -2, -2, -8, -10, -50}
                    },
                    {
                            new int[]{1,-2,1},
                            new int[]{-2,1,1},
                            new int[]{1,1,-2}
                    },
                    {
                            new int[]{2,2},
                            new int[]{2,2},
                            new int[]{2,2}
                    },
                    {
                            new int[]{1},
                            new int[]{1},
                            new int[]{1}
                    },
            });
        }

        @Parameter
        public int[] input;

        @Parameter(1)
        public int[] expectedSort;

        @Parameter(2)
        public int[] expectedReverse;

        @Test
        public void sort() {

            int[] input = this.input;
            ArrayUtils.sort(input);
            assertArrayEquals(expectedSort, input);
        }

        @Test
        public void reverse() {

            int[] input = this.input;
            ArrayUtils.sort(input);
            ArrayUtils.reverse(input);
            assertArrayEquals(expectedReverse, input);
        }
    }

    public static class ArrayUtilsSingleTest {

        @Test
        public void SortShouldThrowIfArgIsNullOrEmpty() {

            try {
                ArrayUtils.sort(null);
            } catch (IllegalArgumentException ex) {
                assertThat(ex.getMessage(), is("Argument is null"));
            }

            try {
                ArrayUtils.sort(new int[0]);
            } catch (IllegalArgumentException ex) {
                assertThat(ex.getMessage(), is("Argument is empty"));
            }
        }

        @Test
        public void ReverseShouldThrowIfArgIsNullOREmpty() {

            try {
                ArrayUtils.reverse(null);
            } catch (IllegalArgumentException ex) {
                assertThat(ex.getMessage(), is("Argument is null"));
            }
            try {
                ArrayUtils.reverse(new int[0]);
            } catch (IllegalArgumentException ex) {
                assertThat(ex.getMessage(), is("Argument is empty"));
            }
        }
    }
}