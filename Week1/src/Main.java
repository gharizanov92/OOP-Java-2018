import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //////
        String test = "test";
        System.out.println(test == "test"); // true, because of optimizations
        String te = "te";
        System.out.println((te + "st") == "test"); // false, cannot be optimized
        System.out.println("test".equals(te + "st")); // true, correct way to do this
        System.out.println((te + "st").intern() == "test"); // true, optimization


        String resultString = String.format("%d is a palindrome", 12321);
        resultString = String.format("%d is not a palindrome", 12321);

        System.out.println(resultString);

    }

}
