import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] arr =  {
            1, 8, 9, 10, 20, 34
        } ;
        List<Integer> arrayList = new ArrayList<Integer>();
        arrayList = Arrays.asList(arr);
        ArrayUtil arrayUtil = new ArrayUtil();
        System.out.println(arrayUtil.maxSize(arrayList));
    }
}
