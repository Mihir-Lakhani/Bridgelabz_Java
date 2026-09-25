/*
9. Rewrite the MarksAndAvgOfStudents program to store the marks of the students in physics, chemistry, and maths
in a 2D array and then compute the percentage and grade

 */

package Java_Arrays.Level_2;

import java.util.Scanner;

public class MarksAndAvgOfStudentsMultiDimArray {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] data =  new int[n][4]; // 4 columns for phy-0 chem-1 maths-2 and percentage-3

        String[] grades = new String[n];

        for(int i=0; i<n; i++){
            System.out.printf("Enter the marks of Physics for Student %d", i);
            data[i][0] = sc.nextInt(); //Adding in column 0th

            System.out.printf("Enter the marks of Chemistry for Student %d", i);
            data[i][1] = sc.nextInt(); //Adding in column 1st

            System.out.printf("Enter the marks of Maths for Student %d", i);
            data[i][2] = sc.nextInt(); //Adding in column 2nd

            data[i][3] = (data[i][0] + data[i][1] + data[i][2]) / 3; //Adding in column 3rd

            if(data[i][3]<40){
                grades[i] = "R";
            }else if(data[i][3]<50){
                grades[i] = "E";
            }else if(data[i][3]<60){
                grades[i] = "D";
            }else if(data[i][3]<70){
                grades[i] = "C";
            }else if(data[i][3]<80){
                grades[i] = "B";
            }else{
                grades[i] = "A";
            }
        }

        for(int i=0; i<n; i++){
            System.out.printf("The Percentage of Student %d is %d with grade is %s\n",i+1, data[i][3], grades[i]);
        }
    }
}
