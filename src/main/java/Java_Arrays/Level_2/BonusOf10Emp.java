/*
1. Create a program to find the bonus of 10 employees based on their years of service
and the total bonus amount the company Zara has to pay, along with the old and new salary.
 */

package Java_Arrays.Level_2;

import java.util.Arrays;
import java.util.Scanner;

public class BonusOf10Emp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] salary = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];
        double totalold = 0;
        double totalbonus = 0;
        double totalnew=0;

        for (int i = 0; i < 10; i++) {

            System.out.printf("Enter the salary of Employee number %d: ", i + 1);
            salary[i] = sc.nextDouble();


            System.out.printf("Enter the years of service of Employee number %d: ", i + 1);
            yearsOfService[i] = sc.nextDouble();

            if(salary[i] <1 || yearsOfService[i] <1){
                i--;
                System.out.println("InValid Input!!! Enter Again.");
                continue;
            }
            totalold+=salary[i];
        }

        for(int i = 0; i < 10; i++){
            bonus[i] = (yearsOfService[i] > 5)? 0.05 * salary[i] : 0.02 * salary[i];
            newSalary[i] = salary[i] + bonus[i];
            totalbonus += bonus[i];
            totalnew+=newSalary[i];
        }

        System.out.printf("The total old salary : %.2f\nThe total bonuses : %.2f\nThe total new salary : %.2f\n" +
                "Old Salary of 10 people: %s\nYears of Exp. of 10 people: %s\nBonuses of 10 people: %s\nNew Salary of 10 people: %s\n",
                totalold, totalbonus, totalnew, Arrays.toString(salary), Arrays.toString(yearsOfService), Arrays.toString(bonus), Arrays.toString(newSalary));
    }
}
