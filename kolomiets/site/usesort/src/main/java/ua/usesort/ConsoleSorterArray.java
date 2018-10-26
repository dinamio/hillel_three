package ua.usesort;

import ua.sortarray.SampleSort;

import java.util.Scanner;

/**
 * Represent usage class from maven local repository
 */
public class ConsoleSorterArray extends SampleSort {

    /**
     * Init array from console
     */
    public void inputArray() {
        System.out.println("Input any digits like 3 8 5:");
        Scanner scanner = new Scanner(System.in);
        String inputData = scanner.nextLine();

        initArray(inputData.split(" "));
    }

    /**
     * Just output in console array as sorted by greater
     */
    public void outputArrayToConsole() {
        sortArray();

        StringBuilder stringBuilder = new StringBuilder("Sorted array: \n");

        for (Integer out : getBasket()) {
            stringBuilder.append(out);
            stringBuilder.append(" ");
        }
        System.out.println(stringBuilder);
    }
}
