package Java_Sorting;

import java.util.Arrays;

public class CountingSortStudentAges {

    static void countingSort(int[] ages) {
        int minAge = 10;
        int maxAge = 18;

        int[] count = new int[maxAge - minAge + 1];
        int[] output = new int[ages.length];

        // Count the frequency of each age.
        for (int age : ages) {
            if (age < minAge || age > maxAge) {
                throw new IllegalArgumentException(
                        "Age must be between 10 and 18");
            }
            count[age - minAge]++;
        }

        // Calculate cumulative frequencies.
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Place each age in its sorted position.
        for (int i = ages.length - 1; i >= 0; i--) {
            int index = ages[i] - minAge;
            output[count[index] - 1] = ages[i];
            count[index]--;
        }

        // Copy the sorted values back.
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        int[] ages = {15, 10, 18, 12, 15, 11, 10, 17};

        countingSort(ages);

        System.out.println(Arrays.toString(ages));
    }
}