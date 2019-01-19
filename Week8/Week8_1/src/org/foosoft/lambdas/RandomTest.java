package org.foosoft.lambdas;

import java.util.Random;

public class RandomTest {
    public static final int seed = 10;
    public static void main(String[] args) {
        Random random = new Random(seed);

        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(100));
        }
    }
}
