package Java_Sorting;

import java.util.Arrays;

public class QuickSortProductPrices {

    static void quickSort(double[] prices, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(prices, low, high);

        quickSort(prices, low, pivotIndex - 1);
        quickSort(prices, pivotIndex + 1, high);
    }

    static int partition(double[] prices, int low, int high) {
        double pivot = prices[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;
                swap(prices, i, j);
            }
        }

        swap(prices, i + 1, high);
        return i + 1;
    }

    static void swap(double[] prices, int i, int j) {
        double temp = prices[i];
        prices[i] = prices[j];
        prices[j] = temp;
    }

    public static void main(String[] args) {
        double[] prices = {999.99, 249.50, 1499.00, 99.99, 599.00};

        System.out.println("Before: " + Arrays.toString(prices));
        quickSort(prices, 0, prices.length - 1);
        System.out.println("After:  " + Arrays.toString(prices));
    }
}
