import java.util.List;
import java.util.stream.Collectors;

public class ArrayUtil {
    /**
     *  Find max element in array.
     * @param list
     * @return int max element in array
     */
    public static int maxElement(List<Integer> list){
        return list.stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax();
    }
}
