import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Lamdas {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7);


        final Predicate odd = (Integer x) -> x % 2 != 0;
        final Predicate greater = x -> x > 2;

        final Predicate combined = odd.and(greater);

        //final Consumer<Integer> print = x -> System.out.print(x);
        final Consumer<Integer> print = System.out::print;
        final Consumer<Integer> commaPrinter = x -> System.out.print(", ");

        final Consumer<Integer> combinedConsumers = print.andThen(commaPrinter);

        for (Integer i : arr) {
            if (combined.test(i)) {
                combinedConsumers.accept(i);
            }
        }
    }

}
