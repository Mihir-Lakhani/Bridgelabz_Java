package Java_Sorting;

import java.util.Arrays;

public class InsertionSortEmployeeIds {

    static void insertionSort(int[] ids) {
        for (int i = 1; i < ids.length; i++) {
            int currentId = ids[i];
            int j = i - 1;

            while (j >= 0 && ids[j] > currentId) {
                ids[j + 1] = ids[j];
                j--;
            }

            ids[j + 1] = currentId;
        }
    }

    public static void main(String[] args) {
        int[] ids = {105, 102, 108, 101, 104};

        System.out.println("Before: " + Arrays.toString(ids));
        insertionSort(ids);
        System.out.println("After:  " + Arrays.toString(ids));
    }
}
