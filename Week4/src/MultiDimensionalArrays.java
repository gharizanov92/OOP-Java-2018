import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MultiDimensionalArrays {
    public static void main(String[] args) {
        String[] arr = new String[5];
        int[][] intArr = {{1,2}, {3,4}, {5,6}};

        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr[i].length; j++) {
                System.out.print(intArr[i][j] + " ");
            }
            System.out.println();
        }

        ArrayList<Integer> intArrList = new ArrayList<>();

        intArrList.add(1); // O(1)
        intArrList.add(2);
        intArrList.add(3);
        intArrList.add(4);
        intArrList.add(5);

        LinkedList<Integer> intLinkedList = new LinkedList<>();

        intLinkedList.add(5); // O(n)
        // [] -> [] -> [] ->

    }
}
