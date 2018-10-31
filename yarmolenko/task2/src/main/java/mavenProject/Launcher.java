package task1;

public class Launcher {

    public static void main(String[] args) {

        MinimalNumber mn = new MinimalNumber();
        int[] array = {1, -1, 0, 15, -9, 7};

        System.out.println(mn.minArr(array));
    }
}
