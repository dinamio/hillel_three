package task1;

public class MinimalNumber {
    public int minArr(int[] mas){
        int min = mas[0];
        if (mas.length != 0){
            for (int res : mas){
                if (res < min) min = res;
            }
        }
        else throw new IllegalArgumentException("Array is empty");
        return  min;
    }
}
