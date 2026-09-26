/*
13. Write a program to perform matrix manipulation operations like addition, subtraction, multiplication, and transpose. Also finding the determinant and inverse of a matrix. The program should take random matrices as input and display the result of the operations.
    Hint =>
    Write a Method to create a random matrix taking rows and columns as parameters
    Write a Method to add two matrices
    Write a Method to subtract two matrices
    Write a Method to multiply two matrices

    Write a Method to find the transpose of a matrix

    Write a Method to find the determinant of a 2x2 matrix
    Write a Method to find the determinant of a 3x3 matrix

    Write a Method to find the inverse of a 2x2 matrix
    Write a Method to find the inverse of a 3x3 matrix
    Write a Method to display a matrix
 */

package Java_Methods.Level_3;

import java.util.Scanner;

public class MatrixOperations {

    public static double[][] CreateMatrix(int rows, int columns){

        double[][] matrix = new double[rows][columns];

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                matrix[i][j] = (int)(Math.random()*9)+1;
            }
        }

        return matrix;
    }


    public static double[][] AddMatrix(double[][] matrix1, double[][] matrix2){

        double[][] answer = new double[matrix1.length][matrix1[0].length];

        for(int i=0; i<matrix1.length; i++){
            for(int j=0; j<matrix1[0].length; j++){
                answer[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return answer;
    }


    public static double[][] SubtractMatrix(double[][] matrix1, double[][] matrix2){

        double[][] answer = new double[matrix1.length][matrix1[0].length];

        for(int i=0; i<matrix1.length; i++){
            for(int j=0; j<matrix1[0].length; j++){
                answer[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        return answer;
    }


    public static double[][] MultiplyMatrix(double[][] matrix1, double[][] matrix2){

        double[][] answer = new double[matrix1.length][matrix2[0].length];

        for(int i=0; i<matrix1.length; i++){

            for(int j=0; j<matrix2[0].length; j++){

                for(int k=0; k<matrix1[0].length; k++){

                    answer[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return answer;
    }


    public static double[][] TransposeMatrix(double[][] matrix){

        double[][] transpose = new double[matrix[0].length][matrix.length];

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){

                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }


    public static double Determinant2x2(double[][] matrix){

        double determinant =
                matrix[0][0]*matrix[1][1]
                        -
                        matrix[0][1]*matrix[1][0];

        return determinant;
    }


    public static double Determinant3x3(double[][] matrix){

        double determinant =

                matrix[0][0] *
                        (matrix[1][1]*matrix[2][2]
                                - matrix[1][2]*matrix[2][1])

                        - matrix[0][1] *
                        (matrix[1][0]*matrix[2][2]
                                - matrix[1][2]*matrix[2][0])

                        + matrix[0][2] *
                        (matrix[1][0]*matrix[2][1]
                                - matrix[1][1]*matrix[2][0]);

        return determinant;
    }


    public static double[][] Inverse2x2(double[][] matrix){

        double determinant = Determinant2x2(matrix);

        if(determinant==0){
            return null;
        }

        double[][] inverse = new double[2][2];

        inverse[0][0] = matrix[1][1]/determinant;
        inverse[0][1] = -matrix[0][1]/determinant;
        inverse[1][0] = -matrix[1][0]/determinant;
        inverse[1][1] = matrix[0][0]/determinant;

        return inverse;
    }


    public static double[][] Inverse3x3(double[][] matrix){

        double determinant = Determinant3x3(matrix);

        if(determinant==0){
            return null;
        }

        double[][] cofactor = new double[3][3];

        cofactor[0][0] =
                matrix[1][1]*matrix[2][2]
                        - matrix[1][2]*matrix[2][1];

        cofactor[0][1] =
                -(matrix[1][0]*matrix[2][2]
                        - matrix[1][2]*matrix[2][0]);

        cofactor[0][2] =
                matrix[1][0]*matrix[2][1]
                        - matrix[1][1]*matrix[2][0];


        cofactor[1][0] =
                -(matrix[0][1]*matrix[2][2]
                        - matrix[0][2]*matrix[2][1]);

        cofactor[1][1] =
                matrix[0][0]*matrix[2][2]
                        - matrix[0][2]*matrix[2][0];

        cofactor[1][2] =
                -(matrix[0][0]*matrix[2][1]
                        - matrix[0][1]*matrix[2][0]);


        cofactor[2][0] =
                matrix[0][1]*matrix[1][2]
                        - matrix[0][2]*matrix[1][1];

        cofactor[2][1] =
                -(matrix[0][0]*matrix[1][2]
                        - matrix[0][2]*matrix[1][0]);

        cofactor[2][2] =
                matrix[0][0]*matrix[1][1]
                        - matrix[0][1]*matrix[1][0];


        double[][] adjoint = TransposeMatrix(cofactor);

        double[][] inverse = new double[3][3];

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){

                inverse[i][j] = adjoint[i][j]/determinant;
            }
        }

        return inverse;
    }


    public static void DisplayMatrix(double[][] matrix){

        if(matrix==null){

            System.out.println("Inverse does not exist.");
            return;
        }

        for(int i=0; i<matrix.length; i++){

            for(int j=0; j<matrix[0].length; j++){

                System.out.printf("%.2f\t", matrix[i][j]);
            }

            System.out.println();
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter rows of Matrix A: ");
        int row1 = sc.nextInt();

        System.out.println("Enter columns of Matrix A: ");
        int col1 = sc.nextInt();

        System.out.println("Enter rows of Matrix B: ");
        int row2 = sc.nextInt();

        System.out.println("Enter columns of Matrix B: ");
        int col2 = sc.nextInt();


        double[][] matrix1 = CreateMatrix(row1, col1);
        double[][] matrix2 = CreateMatrix(row2, col2);


        System.out.println("\nMatrix A:");
        DisplayMatrix(matrix1);

        System.out.println("\nMatrix B:");
        DisplayMatrix(matrix2);


        if(row1==row2 && col1==col2){

            System.out.println("\nAddition:");
            DisplayMatrix(AddMatrix(matrix1, matrix2));

            System.out.println("\nSubtraction:");
            DisplayMatrix(SubtractMatrix(matrix1, matrix2));
        }


        if(col1==row2){

            System.out.println("\nMultiplication:");
            DisplayMatrix(MultiplyMatrix(matrix1, matrix2));
        }


        System.out.println("\nTranspose of Matrix A:");
        DisplayMatrix(TransposeMatrix(matrix1));


        if(row1==2 && col1==2){

            System.out.printf(
                    "\nDeterminant of Matrix A: %.2f\n",
                    Determinant2x2(matrix1)
            );

            System.out.println("\nInverse of Matrix A:");
            DisplayMatrix(Inverse2x2(matrix1));
        }


        else if(row1==3 && col1==3){

            System.out.printf(
                    "\nDeterminant of Matrix A: %.2f\n",
                    Determinant3x3(matrix1)
            );

            System.out.println("\nInverse of Matrix A:");
            DisplayMatrix(Inverse3x3(matrix1));
        }

        sc.close();
    }
}