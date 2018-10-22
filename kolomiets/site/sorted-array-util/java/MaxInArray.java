/**
 * Find maximum integer value from arguments.
 * May throw NumberFormatException!
 */
public class MaxInArray {

    public static void main(String[] args) {

        SampleSort helper = new SampleSort();
        helper.initArray(args);
        helper.sortArray();

        Integer[] ourArray = helper.getBasket();

        System.out.println(ourArray[ourArray.length - 1]);

    }

}
