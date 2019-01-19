package main;

import sample.Invoice;

import javax.swing.event.ChangeEvent;
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lambdas {
    public static void main(String[] args) {
        Integer[] ints = new Integer[5];

        ints[0] = 1;
        ints[1] = 2;
        ints[2] = 3;
        ints[3] = 4;
        ints[4] = 5;

        /*
        Consumer<Integer> doSomething = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };*/

        Consumer<Integer> doSomething = arg -> System.out.println(arg);
        Consumer<Integer> longExample = (Integer arg) -> {
            System.out.println(arg);
        };
        Consumer<Integer> pointer = System.out::println;

        BiFunction<Integer, Integer, Integer> findMax =
                (arg1, arg2) -> arg1 > arg2 ? arg1 : arg2;

        for (Integer anInt : ints) {
            //pointer.accept(anInt);
        }

        ////
        Arrays.stream(ints)
                .filter(arg -> arg % 2 == 0)
                .map(arg -> arg * 2)
                .reduce((arg1, arg2) -> arg1 + arg2)
                .ifPresent(System.out::println);


        List<Integer> intList = Arrays.asList(1, 2, 4, 5, 6, 7);

        intList.stream()
                .filter(arg -> arg % 2 == 0)
                .map(arg -> arg * 2)
                .reduce((arg1, arg2) -> arg1 + arg2)
                .ifPresent(System.out::println);

        Random random = new Random();

        final List<Integer> randomInts =
                IntStream.generate(() -> random.nextInt(100)).limit(100)
                        .boxed()
                        .collect(Collectors.toList());

        System.out.println(randomInts);

        randomInts.stream()
                .sorted((arg1, arg2) -> arg2 - arg1)
                .forEach(System.out::println);

        final List<Invoice> invoices = Arrays.asList(
                new Invoice(83, "Electric sander", 7, 57.98),
                new Invoice(24, "Power saw", 18, 99.99),
                new Invoice(7, "Sledge hammer", 11, 21.50),
                new Invoice(77, "Hammer", 76, 11.99),
                new Invoice(39, "Lawn mower", 3, 79.50),
                new Invoice(68, "Screwdriver", 106, 6.99),
                new Invoice(56, "Jig saw", 21, 11.00),
                new Invoice(3, "Wrench", 34, 7.50)
        );

        Arrays.asList(1, 2, 3, 4);

        invoices.stream()
                // .map(inv -> Arrays.<Comparable>asList(inv.getPartDescription(), inv.getQuantity()))
                .map(inv -> {
                    final Map<String, Comparable> map = new HashMap<>();
                    map.put("description", inv.getPartDescription());
                    map.put("quantity", inv.getQuantity());
                    return map;
                })
                //.sorted( (inv1, inv2) -> inv1.get("quantity").compareTo(inv2.get("quantity")))
                .sorted(Comparator.comparing(inv -> inv.get("quantity")))
                .forEach((inv) -> {
                });

        Predicate<Invoice> cheap = inv -> inv.getPrice() < 50;
        Predicate<Invoice> bigQuantity = inv -> inv.getQuantity() > 50;

        invoices.stream()
                .filter(
                        // cheap.and(bigQuantity)
                        ((Predicate<Invoice>) (inv -> inv.getPrice() < 50))
                                .and(inv -> inv.getQuantity() > 50)
                                .and(inv -> inv.getPartDescription().endsWith("driver"))
                ).forEach(System.out::println);

        final List<Character> chars = new LinkedList<>();
        IntStream.generate(() -> random.nextInt(26) + 'A').limit(100)
                .mapToObj(i -> new Character((char)i))
                .collect(Collectors.toSet())
                .forEach(chars::add);

        System.out.println(chars);
/*
        invoices.stream()
                // .sorted((inv1, inv2) -> inv1.getPartDescription().compareTo(inv2.getPartDescription()))
                .sorted(Comparator.comparing(Invoice::getPartDescription, Comparator.reverseOrder()))
                .forEach(System.out::println);*/
    }
}
