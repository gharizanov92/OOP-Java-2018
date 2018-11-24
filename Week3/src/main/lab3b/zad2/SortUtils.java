package main.lab3b.zad2;

import java.util.Arrays;

public class SortUtils {
    private int[] arr;
    /**
     * Initializes the array
     */
    public SortUtils(int[] arg) {
        arr = Arrays.copyOf(arg, arg.length);
    }

    /**
     * Prints the array, example [1,2,3]
     */
    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * Sorts the array using the bubble sort algorithm
     * @return new array, sorted in ascending order
     */
    public int[] sortBbl() {
        return null; // TODO
    }

    /**
     * Performs the merge step of merge sort algorithm
     * @param a left half, sorted
     * @param b right half, sorted
     * @return a sorted array, containing all elements from a and b
     */
    public static int[] mergeSort(int[] a, int[] b) {
        return null; //TODO
    }
}