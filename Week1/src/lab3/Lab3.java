package lab3;

import java.util.Scanner;

public class Lab3 {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        int number;
        do {
            System.out.print("Enter a four-digit number: ");
            number = in.nextInt();
        } while (number < 1000 || number > 9999);

        System.out.println(encryptNumber(number));
    }

    private static int encryptNumber(final int number) {
        int lastDigit = encryptDigit(number % 10);
        int thirdDigit = encryptDigit((number / 10) % 10);
        int secondDigit = encryptDigit((number / 100) % 10);
        int firstDigit = encryptDigit(number / 1000);
        int result = createMultiDigitNumber(firstDigit, secondDigit, thirdDigit, lastDigit);
        return transposeNumber(result);
    }

    private static int createMultiDigitNumber(final int... digits) {
        int result = 0;
        for (int digit : digits) {
            result = result * 10 + digit;
        }
        return result;
    }

    private static int transposeNumber(final int number) {
        int firstHalf = number / 100;
        int secondHalf = number % 100;
        return secondHalf * 100 + firstHalf;
    }
    private static int encryptDigit(final int digit) {
        return (digit + 7) % 10;
    }
}
