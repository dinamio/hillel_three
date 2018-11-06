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

        initArray(validateInputData(inputData));
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

    private String[] validateInputData(String inpitData) {
        String[] result = inpitData.split(" ");

        for (String chekElement : result) {
            try {
                Integer.valueOf(chekElement);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input data, need digits through space");
                return new String[]{"0"};
            }
        }

        return result;
    }
}
