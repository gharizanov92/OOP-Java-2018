import java.util.*;

public class Main {
    public static void main(String[] args) {
        final List<Person> personList = getPeople();

        final boolean hasIvan =
                personList.contains(new Person("Ivan"));

        final Map<Integer, String> intsMap = new HashMap<>();

        intsMap.put(1, "One");
        intsMap.put(2, "Two");
        intsMap.put(3, "Three");

        System.out.println(intsMap.get(2));

        for (Integer key : intsMap.keySet()) {
            System.out.println(intsMap.get(key));
        }

        System.out.println(hasIvan);

        final Map<Person, String> students = new HashMap<>();

        students.put(new Person("Ivan"), "FMI");
        students.put(new Person("Georgi"), "TU");

        System.out.println(students.get(new Person("Ivan")));

        final Map<Person, String> people = new TreeMap<>();

        people.put(new Person("Pesho"), "Telerik");

        System.out.println(people);
        // -----------------

        Set<Integer> intSet = new TreeSet<>();

        intSet.add(0);
        intSet.add(15);
        intSet.add(7);
        intSet.add(-10);
        intSet.add(10);
        intSet.add(-1);

        System.out.println(intSet);
    }

    private static List<Person> getPeople() {
        return Arrays.asList(
                    new Person("Ivan"),
                    new Person("Georgi")
            );
    }
}
