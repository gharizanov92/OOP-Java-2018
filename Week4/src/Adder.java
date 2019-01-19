import java.util.ArrayList;

public class Adder {
    private ArrayList<Integer> arrayList;

    public Adder() {
        arrayList = new ArrayList<>();
    }

    public static int add(int a1, int a2) {
        return a1 + a2;
    }

    public void addNumber(int num) {
        // if no duplicates
        // then add
        // otherwise don't
        if (!isDuplicate(num)) {
            arrayList.add(num);
        }
    }

    private boolean isDuplicate(int num) {
        int occurrenceCount = 0;
/*
        for (int i = 0; i < arrayList.size(); i++) {
            final Integer ithElement = arrayList.get(i);
            if (ithElement == num) {
                occurrenceCount++;
            }
        }
        */
        // iter
        for (Integer el : arrayList) {
            if (el == num) {
                occurrenceCount++;
            }
        }

        return occurrenceCount >= 1;
    }

    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }
}
