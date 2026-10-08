package Java_Sorting;

import java.util.Arrays;

public class MergeSortBookPrices {

    static void mergeSort(double[] prices, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(prices, left, mid);
        mergeSort(prices, mid + 1, right);
        merge(prices, left, mid, right);
    }

    static void merge(double[] prices, int left, int mid, int right) {
        double[] temp = new double[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (prices[i] <= prices[j]) {
                temp[k++] = prices[i++];
            } else {
                temp[k++] = prices[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = prices[i++];
        }

        while (j <= right) {
            temp[k++] = prices[j++];
        }

        for (int index = 0; index < temp.length; index++) {
            prices[left + index] = temp[index];
        }
    }

    public static void main(String[] args) {
        double[] prices = {499.50, 199.00, 350.75, 150.25, 299.99};

        System.out.println("Before: " + Arrays.toString(prices));
        mergeSort(prices, 0, prices.length - 1);
        System.out.println("After:  " + Arrays.toString(prices));
    }
}
