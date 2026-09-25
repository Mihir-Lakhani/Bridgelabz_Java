/*
10. find the Body Mass Index (BMI) of all the persons in the team of 10 members.
For this create a program to find the BMI and display the height, weight, BMI and status of each individual
 */

package Java_Methods.Level_2;

import java.util.Scanner;

public class FindTheBMIMultiDimArray {

    //Method to calculate BMI and store in third column
    public static double[][] calculateBMI(double[][] personData){

        for(int i = 0; i < personData.length; i++){

            //Convert height from cm to meter
            double heightInMeter = personData[i][1] / 100.0; //Convert height from cm to meter


            personData[i][2] = personData[i][0] / (heightInMeter * heightInMeter); //Calculate BMI
        }

        return personData;
    }

    //Method to determine BMI status of all persons
    public static String[] findBMIStatus(double[][] personData){

        String[] status = new String[personData.length];

        for(int i = 0; i < personData.length; i++){

            double bmi = personData[i][2];

            if(bmi <= 18.4){
                status[i] = "Underweight";

            }else if(bmi <= 24.9){
                status[i] = "Normal";

            }else if(bmi <= 39.9){
                status[i] = "Overweight";

            }else{
                status[i] = "Obese";
            }
        }

        return status;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);


        double[][] personData = new double[10][3]; //10 rows for 10 persons and 3 columns for weight, height and BMI

        for(int i = 0; i < personData.length; i++){

            System.out.printf("Enter weight of Person %d in kg: ", i + 1);
            personData[i][0] = sc.nextDouble();

            System.out.printf("Enter height of Person %d in cm: ", i + 1);
            personData[i][1] = sc.nextDouble();
        }

        //Calculate BMI
        personData = calculateBMI(personData);

        //Find BMI status
        String[] status = findBMIStatus(personData);

        //Display all details
        System.out.println("\nPerson\tWeight\tHeight\tBMI\tStatus");

        for(int i = 0; i < personData.length; i++){

            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s%n",
                    i + 1,
                    personData[i][0],
                    personData[i][1],
                    personData[i][2],
                    status[i]);
        }
    }
}
