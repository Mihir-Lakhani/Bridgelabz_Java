package Java_Sorting;

import java.util.Arrays;

public class BubbleSortStudentMarks {

    static void bubbleSort(int[] marks) {
        for (int i = 0; i < marks.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < marks.length - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] marks = {78, 45, 92, 60, 85};

        System.out.println("Before: " + Arrays.toString(marks));
        bubbleSort(marks);
        System.out.println("After:  " + Arrays.toString(marks));
    }
}
