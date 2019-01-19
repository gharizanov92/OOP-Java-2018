import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static void forEach(List<Integer> intList, MyAction action) {
        for (Integer i : intList) {
            // doSomething with i
            action.apply(i);
        }
    }

    public static List<Integer> filter(List<Integer> intList, FilterAction action) {
        List<Integer> result = new ArrayList<>();

        for (Integer el : intList) {
            if (action.isEligible(el)) {
                result.add(el);
            }
        }

        return result;
    }

}
