import java.util.List;
import java.util.stream.Collectors;

public class ArrayUtil {
    public static int maxSize(List<Integer> list){
        return list.stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax();
    }
}
