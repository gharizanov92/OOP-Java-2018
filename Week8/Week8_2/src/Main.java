import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        Utils.forEach(intList, new PrintAction());
        System.out.println("----");
        Utils.forEach(intList, new DoubleAction());
        Utils.forEach(intList, new MyAction() {
            @Override
            public void apply(Integer arg) {
                System.out.print(arg + ", ");
            }
        });

        System.out.println("\n----");

        System.out.println(Utils.filter(intList, new FilterAction() {
            @Override
            public boolean isEligible(Integer el) {
                return el % 2 == 0;
            }
        }));
    }
}
