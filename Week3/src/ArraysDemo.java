import main.lab3b.zad2.SortUtils;

import java.util.Arrays;

public class ArraysDemo {

    public static void print(int[] arr) {
        arr[2] = 10;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];

        arr[0] = 0;
        arr[1] = 1;

        int[] arrInitialized = new int[]{1,2,3,4};

        print(arrInitialized);

        System.out.println(Arrays.toString(arrInitialized));

        System.out.println("-------SortUtils--------");

        SortUtils utils = new SortUtils(arrInitialized);
        //System.out.println(Arrays.toString(utils.getArr()));
        arrInitialized[0] = 50;
        //System.out.println(Arrays.toString(utils.getArr()));
    }
}
