import java.util.Arrays;

public class MathUtils {

    public static int min(int[] array) {

        int result = array[0];

        for (int i = 1; i < array.length; i++) {

            result = array[i] < result
                    ? array[i]
                    : result;
        }

        return result;
    }

    public static double min(double[] array) {
        return Arrays.stream(array).min().getAsDouble();
    }
}
