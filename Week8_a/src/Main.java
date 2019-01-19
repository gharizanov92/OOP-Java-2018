import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        final List<Person> personList = new LinkedList<>();

        final Person pesho = new Person("Pesho");
        personList.add(pesho);
        final Person gosho = new Person("Gosho");
        personList.add(gosho);

        List<Person> people = new LinkedList<>();
        people.add(pesho);
        people.add(gosho);
        ListIterator<Person> it = people.listIterator(people.size());


        final boolean hasPesho
                = personList.contains(new Person("Pesho"));

        System.out.println(pesho.equals(gosho));
        System.out.println(hasPesho);

        final Map<Integer, String> ints = new HashMap<>();

        ints.put(1, "One");
        ints.put(2, "Two");
        ints.put(2, "Two");
        ints.put(2, "Two");
        ints.put(2, "Two");
        ints.put(2, "Two");
        ints.put(2, "Two");
        ints.put(2, "Two");
        ints.put(2, "Two");
        ints.put(2, "Two");
        ints.put(2, "Two");

        System.out.println(ints.get(1));
        System.out.println(ints.containsKey(1));

        final Map<Person, String> treeMap = new TreeMap<>();

        treeMap.put(gosho, "Gosho");

        System.out.println(treeMap);

        // множество
        Set<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(2);
        set.add(2);
        set.add(2);

        System.out.println(set);

        List<List<Integer>> list = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.add(IntStream
                    .generate(Main::randomInt)
                    .limit(10)
                    .boxed()
                    .collect(Collectors.toList())
            );
        }

        list.forEach(System.out::println);

        System.out.println(
                list.stream()
                        .map(lists -> lists.stream().reduce(Math::max))
                        .map(Optional::get)
                        .reduce(Math::max));
    }

    public static int randomInt() {
        return (int) (Math.random() * 100);
    }

    public static List<Integer> merge(final List<Integer> l1, final List<Integer> l2) {
        final List<Integer> result = new LinkedList<>();
        result.addAll(l1);
        result.addAll(l2);

        return result;
    }
}
