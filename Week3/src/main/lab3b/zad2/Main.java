package main.lab3b.zad2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array size: ");
        //int arraySize = scanner.nextInt();

       // int[] array = new int[arraySize];

        // 2 3 4 5 6
        //String input = scanner.nextLine();
        String input = "2 3 4 5 6";

        String[] strArr = input.split(" ");
        System.out.println(Arrays.toString(strArr));

        int[] intArr = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
    }
}
