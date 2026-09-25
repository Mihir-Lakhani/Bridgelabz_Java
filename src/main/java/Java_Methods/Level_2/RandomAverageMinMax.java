/*
Write a program to generate five 4 digit random numbers
and find their average, minimum and maximum.
 */

package Java_Methods.Level_2;

import java.util.Arrays;

public class RandomAverageMinMax {

    //Method to generate 4 digit random numbers
    public static int[] generate4DigitRandomArray(int size){

        int[] numbers = new int[size];

        for(int i = 0; i < numbers.length; i++){

            numbers[i] = (int)(Math.random() * 9000) + 1000;
        }

        return numbers;
    }

    //Method to find average, minimum and maximum
    public static double[] findAverageMinMax(int[] numbers){

        double sum = 0;

        int min = numbers[0];
        int max = numbers[0];

        for(int i = 0; i < numbers.length; i++){

            sum += numbers[i];

            min = Math.min(min, numbers[i]);
            max = Math.max(max, numbers[i]);
        }

        double average = sum / numbers.length;

        return new double[]{average, min, max}; //another way to return an array
    }

    public static void main(String[] args){

        //Generate five random 4 digit numbers
        int[] numbers = generate4DigitRandomArray(5);

        //Find average, minimum and maximum
        double[] result = findAverageMinMax(numbers);

        //Display results
        System.out.println("Random Numbers: " + Arrays.toString(numbers));

        System.out.printf("Average: %.2f%n", result[0]);
        System.out.printf("Minimum: %.0f%n", result[1]);
        System.out.printf("Maximum: %.0f%n", result[2]);
    }
}