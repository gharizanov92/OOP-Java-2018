package org.foosoft.lambdas;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<Integer> arg = Arrays.asList(1, 2, 3, 4, 5);
        LambdaFunctions.forEachElementDo(arg, new MyAction() {
            @Override
            public void apply(Object argument) {
                System.out.println(argument);
            }
        });

        Integer result = LambdaFunctions.reduce(arg, new Reducer() {
            @Override
            public Integer reduce(Integer a1, Integer a2) {
                return a1 + a2;
            }
        });


        Integer result2 = LambdaFunctions.reduce(arg, new Reducer() {
            @Override
            public Integer reduce(Integer a1, Integer a2) {
                return a1 * a2;
            }
        });

        System.out.println(result);
        System.out.println(result2);
    }
}
