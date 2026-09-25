/*
8. Create a program to take input marks of students in 3 subjects physics, chemistry, and maths.
Compute the percentage and then calculate the grade.
 */

package Java_Arrays.Level_2;

import java.util.Scanner;

public class MarksAndAvgOfStudents {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] physics =  new int[n];
        int[] chemistry =  new int[n];
        int[] maths =  new int[n];
        int[] percentage = new int[n];
        String[] grades = new String[n];

        for(int i=0; i<n; i++){
            System.out.printf("Enter the marks of Physics for Student %d", i);
            physics[i] = sc.nextInt();

            System.out.printf("Enter the marks of Chemistry for Student %d", i);
            chemistry[i] = sc.nextInt();

            System.out.printf("Enter the marks of Maths for Student %d", i);
            maths[i] = sc.nextInt();

            percentage[i] = (int)(((double)(physics[i] + chemistry[i] + maths[i]) / 300)*100);
            if(percentage[i]<40){
                grades[i] = "R";
            }else if(percentage[i]<50){
                grades[i] = "E";
            }else if(percentage[i]<60){
                grades[i] = "D";
            }else if(percentage[i]<70){
                grades[i] = "C";
            }else if(percentage[i]<80){
                grades[i] = "B";
            }else{
                grades[i] = "A";
            }
        }

        for(int i=0; i<n; i++){
            System.out.printf("The Percentage of Student %d is %d with grade is %s\n",i+1, percentage[i], grades[i]);
        }
    }
}
