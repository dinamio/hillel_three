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

        if (args.length > 0) {

            sampleSort.basket = new Integer[args.length];

            for (int i = 0; i < args.length; i++) {
                sampleSort.basket[i] = Integer.valueOf(args[i]);
            }
        } else {
            sampleSort.basket = new Integer[]{64, 26, 460, 4, 75};
        }

        List<Integer> out = Arrays.asList(sampleSort.basket);

        //https://dzone.com/articles/java-8-comparator-how-to-sort-a-list
        out.sort(Comparator.<Integer>naturalOrder());

        out.stream().forEach(System.out::println);
    }

}
