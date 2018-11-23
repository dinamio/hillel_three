package ua.sortarray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Sample array sorter by homework git check
 */
public class SampleSort {

    private Integer[] basket;

    public static void main(String[] args) {

        SampleSort sampleSort = new SampleSort();

        sampleSort.initArray(args);

        sampleSort.sortArray();

        StringBuilder buildForOut = new StringBuilder();
        for (Integer i : sampleSort.basket) {
            buildForOut.append(i);
            buildForOut.append(" ");
        }
        System.out.println(buildForOut.substring(0, buildForOut.length() - 1));
    }

    public void initArray(String[] values) {
        if (values.length > 0) {

            basket = new Integer[values.length];

            for (int i = 0; i < values.length; i++) {
                basket[i] = Integer.valueOf(values[i]);
            }
        } else {
            basket = new Integer[]{64, 26, 460, 4, 75};
        }
    }

    public void sortArray() {
        List<Integer> digitList = Arrays.asList(basket);

        //https://dzone.com/articles/java-8-comparator-how-to-sort-a-list
        digitList.sort(Comparator.<Integer>naturalOrder());

        basket = digitList.toArray(basket);
    }

    public Integer[] getBasket() {
        return basket;
    }
}
