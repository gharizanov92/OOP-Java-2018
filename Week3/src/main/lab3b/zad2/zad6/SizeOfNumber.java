package main.lab3b.zad2.zad6;

public class SizeOfNumber {
    public static int sizeOf(final Class numberClass) {
        if (numberClass == Integer.class) {
            return Integer.SIZE / Byte.SIZE;
        }

        return 0;
    }

    public void changeIt(Integer i) {
        i = 5;
    }

    public static void main(String[] args) {
        System.out.println(sizeOf(Integer.class));
    }
}
