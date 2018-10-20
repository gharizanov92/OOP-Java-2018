package test.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class TestUtil {
    public static void verifyField(Field field) {
        int modifier = field.getModifiers();
        verify(Modifier.isPrivate(modifier), String.format("Field %s is not private. All fields must be private.", field.toGenericString()));
    }

    public static void verifyAllDeclaredFields(Class clazz) {
        final Field[] declaredFields = clazz.getDeclaredFields();
        verify(declaredFields.length > 0 ,
                "No declared fields in class SortUtils! Make sure you have a field for the array");
        for (Field field : declaredFields) {
            verifyField(field);
        }
    }

    public static void verifyContainsAllElementsInSameOrder(int[] left, int[] right, String errorText) {
        verify(left.length == right.length, errorText);
        for (int i = 0; i < left.length; i++) {
            verify(left[i] == right[i], errorText);
        }
    }

    public static void verify(final boolean statement, final String errorText) {
        if (!statement) {
            System.err.println("There are test failures");
            System.err.println(errorText);
            System.exit(1);
        }
    }

    public static Field getDeclaredFieldOfType(Class clazz, String intArrTypeName) {
        for (final Field field : clazz.getDeclaredFields()) {
            if (field.getType().getTypeName().equals(intArrTypeName)) {
                return field;
            }
        }

        return null;
    }

    public static int[] newRandomIntArray() {
        final int size = randomInt(3, 5);
        final int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = randomInt(50);
        }

        return result;
    }

    public static int randomInt(int high) {
        return randomInt(0, high);
    }

    public static int randomInt(int low, int high) {
        return (int) (Math.random() * (high - low)) + low;
    }

    public static <T> T getFieldValue(final Object holder, final String typeName) {
        final Field field = getDeclaredFieldOfType(holder.getClass(), typeName);
        field.setAccessible(true);
        try {
            return (T) field.get(holder);
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    public static void verifySorted(final int[] arr, final String err) {
        final int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);

        verifyContainsAllElementsInSameOrder(arr, sorted, err);
    }
}
