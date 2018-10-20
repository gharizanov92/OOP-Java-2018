package lab2;

import java.util.Scanner;

public class PalindromeCheat {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final String resultTemplate = "%d %s a palindrome";

        int number;
        do {
            System.out.print("Enter a five-digit number: ");
            number = in.nextInt();
        } while (number < 10000 || number > 99999);

        int lastDigit = number % 10;
        int fourthDigit = (number / 10) % 10;
        int secondDigit = (number / 1000) % 10;
        int firstDigit = number / 10000;

        String resultString;
        if (lastDigit == firstDigit && fourthDigit == secondDigit) {
            resultString = String.format(resultTemplate, number, "is");
        } else {
            resultString = String.format(resultTemplate, number, "is NOT");
        }
        System.out.println(resultString);
    }
}
