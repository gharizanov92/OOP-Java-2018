package org.foosoft.lambdas;

import java.util.Iterator;
import java.util.List;

public class LambdaFunctions {

    public static void forEachElementDo(List<Integer> list, MyAction action) {
        for (Integer element : list) {
            action.apply(element);
        }
    }

    public static Integer reduce(List<Integer> elements, Reducer reducer) {
        final Iterator<Integer> iterator = elements.iterator();

        Integer accumulator = iterator.next();

        while (iterator.hasNext()) {
            accumulator = reducer.reduce(accumulator, iterator.next());
        }

        return accumulator;
    }

}
