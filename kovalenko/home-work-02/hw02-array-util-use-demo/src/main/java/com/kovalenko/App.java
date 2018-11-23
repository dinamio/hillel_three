package com.kovalenko;

import java.util.Arrays;

public class App {

    public static void main( String[] args ) {

        int[] array = {-85,0,2,2,35,64,-85,-6,38};

        ArrayUtils.sort(array);

        System.out.println(Arrays.toString(array));

        ArrayUtils.reverse(array);

        System.out.println(Arrays.toString(array));
    }
}
