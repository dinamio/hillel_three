package task1;

public class MinimalNumber  {

    public int minArr(int[] mas) {

        int min = mas[0];

        if (mas.length != 0) {
            for(int i = 0; i < mas.length; i++) {
                int res = mas[i];
                if (res < min) {
                    min = res;
                }
            }

            return min;
        } else {
            throw new IllegalArgumentException("Array is empty");
        }
    }
}
