import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.BaseStream;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        final List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);

        final Function<Integer, Integer> multiply = arg -> arg * 2;
        final Function<Integer, Integer> add = arg -> arg + 2;

        final Function<Integer, Integer> combined = multiply.andThen(add);

        // doForEach(intList, combined);

        intList.stream()
                .map(combined)
                .filter(a -> a < 10)
                .reduce((acc, next) -> acc + next)
                .ifPresent(System.out::println);

        Consumer<String> voidMethod = System.out::println;

        BiFunction<String, String, String> formatter = String::format;

        System.out.println(formatter.apply("Hello %s", "World"));

        Random random = new Random();
        IntStream.generate(() ->
                random.nextInt(100))
                .limit(100)
                .boxed()
                .map(combined)
                .filter(a -> a < 10)
                .reduce((acc, next) -> acc + next)
                .ifPresent(System.out::println);

        // [[][][]]
        final List<List<Integer>> lists = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            lists.add(
                    IntStream.generate(() ->
                            random.nextInt(10))
                            .limit(10)
                            .boxed()
                            .collect(Collectors.toList()));
        }
        System.out.println(lists);

        lists.stream()
                .map(Collections::max)
                .reduce(Math::max)
                .ifPresent(System.out::println);
    }


    @FunctionalInterface
    private interface Callback {
        Integer apply(Integer arg);

        default Callback andThen(Callback other) {
            return (arg) -> other.apply(this.apply(arg));
        }
    }
}
