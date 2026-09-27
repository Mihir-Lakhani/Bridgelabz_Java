package Java_Strings.Level_2;

import java.util.Scanner;

public class StudentMarks {
    static int[][] makeMarks(int n) {
        int[][] marks = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                marks[i][j] = 10 + (int) (Math.random() * 90);
            }
        }
        return marks;
    }

    static double[][] calculate(int[][] marks) {
        double[][] result = new double[marks.length][3];

        for (int i = 0; i < marks.length; i++) {
            double total = marks[i][0] + marks[i][1] + marks[i][2];
            double avg = total / 3;
            double per = total / 300 * 100;

            result[i][0] = total;
            result[i][1] = Math.round(avg * 100.0) / 100.0;
            result[i][2] = Math.round(per * 100.0) / 100.0;
        }
        return result;
    }

    static String[][] getGrades(double[][] result) {
        String[][] grades = new String[result.length][2];

        for (int i = 0; i < result.length; i++) {
            double p = result[i][2];

            if (p >= 80) {
                grades[i][0] = "A";
                grades[i][1] = "Level 4";
            } else if (p >= 70) {
                grades[i][0] = "B";
                grades[i][1] = "Level 3";
            } else if (p >= 60) {
                grades[i][0] = "C";
                grades[i][1] = "Level 2";
            } else if (p >= 50) {
                grades[i][0] = "D";
                grades[i][1] = "Level 1";
            } else if (p >= 40) {
                grades[i][0] = "E";
                grades[i][1] = "Below Level 1";
            } else {
                grades[i][0] = "R";
                grades[i][1] = "Remedial";
            }
        }
        return grades;
    }

    static void show(int[][] marks, double[][] result, String[][] grades) {
        System.out.println("Student\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");

        for (int i = 0; i < marks.length; i++) {
            System.out.println((i + 1) + "\t" + marks[i][0] + "\t"
                    + marks[i][1] + "\t" + marks[i][2] + "\t"
                    + result[i][0] + "\t" + result[i][1] + "\t"
                    + result[i][2] + "\t" + grades[i][0]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of students: ");
        int n = sc.nextInt();

        int[][] marks = makeMarks(n);
        double[][] result = calculate(marks);
        String[][] grades = getGrades(result);

        show(marks, result, grades);
        sc.close();
    }
}