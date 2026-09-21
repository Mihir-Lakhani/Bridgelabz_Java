/*
A program to input Physics, Chemistry and Maths marks,
calculate the average and display the Grade and Remarks.
 */

package Java_Control_Flow.Level_2;
import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter Physics marks: ");
        double physics = sc.nextDouble(); //Input Physics marks

        System.out.println("Enter Chemistry marks: ");
        double chemistry = sc.nextDouble(); //Input Chemistry marks

        System.out.println("Enter Maths marks: ");
        double maths = sc.nextDouble(); //Input Maths marks

        //Calculate the average percentage
        double average = (physics + chemistry + maths) / 3.0;

        String grade;
        String remarks;

        //Find Grade and Remarks based on average marks
        if(average >= 80){
            grade = "A";
            remarks = "Level 4, above agency-normalized standards";

        }else if(average >= 70){
            grade = "B";
            remarks = "Level 3, at agency-normalized standards";

        }else if(average >= 60){
            grade = "C";
            remarks = "Level 2, below, but approaching agency-normalized standards";

        }else if(average >= 50){
            grade = "D";
            remarks = "Level 1, well below agency-normalized standards";

        }else if(average >= 40){
            grade = "E";
            remarks = "Level 1-, too below agency-normalized standards";

        }else{
            grade = "R";
            remarks = "Remedial standards";
        }

        //Print Average, Grade and Remarks
        System.out.printf("Average Mark: %.2f%%\n", average);
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
    }
}