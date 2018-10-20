package test.lab3b.zad2;

import main.lab3b.zad2.SortUtils;
import test.util.TestUtil;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Arrays;

class SortUtilsTest {

    private static final String INT_ARR_TYPE_NAME = "int[]";
    private static final Class<SortUtils> sortUtilsClass = SortUtils.class;

    private void testInit() throws IllegalAccessException {
        // given
        final int[] arrayToInitializeWith = TestUtil.newRandomIntArray();

        // when
        final SortUtils sortUtilsTest = new SortUtils(arrayToInitializeWith);

        // then
        final Field arrayField = TestUtil.getDeclaredFieldOfType(sortUtilsClass, INT_ARR_TYPE_NAME);
        TestUtil.verify(arrayField != null, String.format("No %s field found in SortUtils!", INT_ARR_TYPE_NAME));

        // TestUtil
        final int[] intArray = TestUtil.getFieldValue(sortUtilsTest, INT_ARR_TYPE_NAME);

        final String fieldName = arrayField.toGenericString();
        TestUtil.verify(intArray != null, String.format("%s is null, expected array containing %s",
                fieldName, Arrays.toString(arrayToInitializeWith)));

        TestUtil.verify(intArray != arrayToInitializeWith,
                String.format("%s was copied using shallow copy", fieldName));

        TestUtil.verifyContainsAllElementsInSameOrder(arrayToInitializeWith, intArray,
                String.format("%s was expected to be %s, but was %s", fieldName, Arrays.toString(arrayToInitializeWith), Arrays.toString(intArray)));
    }

    public void testPrint() {
        // given
        final int[] arrayToInitializeWith = TestUtil.newRandomIntArray();
        final SortUtils sortUtilsTest = new SortUtils(arrayToInitializeWith);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        // when
        sortUtilsTest.print();
        // get input and replace trailing newline
        final String output = baos.toString().replaceAll("\r|\n", "");
        System.out.flush();
        System.setOut(old);

        // then
        String expected = Arrays.toString(arrayToInitializeWith);
        TestUtil.verify(expected.equals(output),
                String.format("Expected SortUtils::print() to print \"%s\" but instead it printed \"%s\"", expected, output));
    }

    public void testSortBbl() {
        // given
        final int[] arrayToInitializeWith = TestUtil.newRandomIntArray();
        final int[] expectedSortedArray = Arrays.copyOf(arrayToInitializeWith, arrayToInitializeWith.length);
        Arrays.sort(expectedSortedArray);

        final SortUtils sortUtilsTest = new SortUtils(arrayToInitializeWith);
        final Field arrayField = TestUtil.getDeclaredFieldOfType(sortUtilsClass, INT_ARR_TYPE_NAME);
        final int[] arrayRef = TestUtil.getFieldValue(sortUtilsTest, INT_ARR_TYPE_NAME);
        final int[] originalArray = Arrays.copyOf(arrayRef, arrayRef.length);

        // when
        final int[] result = sortUtilsTest.sortBbl();

        // then
        TestUtil.verifyContainsAllElementsInSameOrder(arrayRef, originalArray,
                String.format("%s has been mutated. Make sure you return a sorted copy of the array",
                        arrayField.toGenericString()));

        TestUtil.verifyContainsAllElementsInSameOrder(result, expectedSortedArray,
                String.format("Expected SortUtils::sortBbl() to return \"%s\", got instead \"%s\"",
                        Arrays.toString(expectedSortedArray), Arrays.toString(result)));
    }

    public void testMergeSort() {
        // given
        final int[] leftArray = TestUtil.newRandomIntArray();
        final int[] rightArray = TestUtil.newRandomIntArray();
        final int[] expectedSortedArray = new int[leftArray.length + rightArray.length];

        for (int i = 0; i < leftArray.length; i++) {
            expectedSortedArray[i] = leftArray[i];
        }

        for (int i = leftArray.length; i < expectedSortedArray.length; i++) {
            expectedSortedArray[i] = rightArray[i - leftArray.length];
        }

        Arrays.sort(leftArray);
        Arrays.sort(rightArray);
        Arrays.sort(expectedSortedArray);

        // when
        final int[] sorted = SortUtils.mergeSort(leftArray, rightArray);

        // then
        TestUtil.verifySorted(sorted, String.format("Expected SortUtils::mergeSort() to return sorted array \"%s\", got instead \"%s\"",
                Arrays.toString(expectedSortedArray), Arrays.toString(sorted)));
    }

    public static void main(String[] args) throws IllegalAccessException {
        final SortUtilsTest sortUtilsTest = new SortUtilsTest();
        TestUtil.verifyAllDeclaredFields(sortUtilsClass);

        sortUtilsTest.testInit();
        sortUtilsTest.testPrint();
        sortUtilsTest.testSortBbl();
        sortUtilsTest.testMergeSort();

        System.out.println("All tests passed");
    }
}