/*
A program to calculate the BMI of a person
and determine their weight status.
 */

package Java_Control_Flow.Level_2;
import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter weight in kg: ");
        double weight = sc.nextDouble(); //Taking weight input

        System.out.println("Enter height in cm: ");
        double height_cm = sc.nextDouble(); //Taking height input

        //Convert height from cm to meter
        double height_m = height_cm / 100.0;

        //Calculate BMI
        double bmi = weight / (height_m * height_m);

        String status;

        //Determine weight status based on BMI
        if(bmi < 18.5){
            status = "Underweight";

        }else if(bmi < 25.0){
            status = "Normal";

        }else if(bmi < 40.0){
            status = "Overweight";

        }else{
            status = "Obese";
        }

        //Print BMI and weight status
        System.out.printf("BMI is %.2f\n", bmi);
        System.out.println("Weight Status: " + status);
    }
}