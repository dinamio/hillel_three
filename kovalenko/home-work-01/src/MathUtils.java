import java.util.Arrays;

public class MathUtils {

    public static int min(int[] array) {
        return Arrays.stream(array).min().getAsInt();
    }

    public static double min(double[] array) {
        return Arrays.stream(array).min().getAsDouble();
    }
}
