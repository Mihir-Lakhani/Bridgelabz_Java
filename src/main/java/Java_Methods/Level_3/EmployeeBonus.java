/*
11. Create a program to find the bonus of 10 employees based on their years of service as well as the total bonus amount the 10-year-old company Zara has to pay as a bonus, along with the old and new salary.
    Hint =>
    Zara decides to give a bonus of 5% to employees whose year of service is more than 5 years or 2% if less than 5 years
    Create a Method to determine the Salary and years of service and return the same. Use the Math.random() method to determine the 5-digit salary for each employee and also use the random method to determine the years of service. Define 2D Array to save the salary and years of service.
    Write a Method to calculate the new salary and bonus based on the logic defined above and return the new 2D Array of the latest salary and bonus amount
    Write a Method to Calculate the sum of the Old Salary, the Sum of the New Salary, and the Total Bonus Amount and display it in a Tabular Format

 */

package Java_Methods.Level_3;

public class EmployeeBonus {

    public static double[][] GetSalaryAndService(){

        double[][] employees = new double[10][2];

        for(int i=0; i<employees.length; i++){

            //5-digit salary
            employees[i][0] = (int)(Math.random()*90000)+10000;

            //Years of service from 1 to 10
            employees[i][1] = (int)(Math.random()*10)+1;
        }

        return employees;
    }


    public static double[][] FindNewSalaryAndBonus(double[][] employees){

        double[][] newSalaryAndBonus = new double[employees.length][2];

        for(int i=0; i<employees.length; i++){

            double salary = employees[i][0];
            double years = employees[i][1];

            double bonus;

            if(years>5){
                bonus = salary*0.05;
            }
            else{
                bonus = salary*0.02;
            }

            double newSalary = salary+bonus;

            newSalaryAndBonus[i][0] = newSalary;
            newSalaryAndBonus[i][1] = bonus;
        }

        return newSalaryAndBonus;
    }


    public static void Display(double[][] employees, double[][] result){

        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.println("Salary\tYears\tBonus\tNew Salary");

        for(int i=0; i<employees.length; i++){

            System.out.printf(
                    "%.0f\t%.0f\t%.2f\t%.2f\n",
                    employees[i][0],
                    employees[i][1],
                    result[i][1],
                    result[i][0]
            );

            totalOldSalary += employees[i][0];
            totalNewSalary += result[i][0];
            totalBonus += result[i][1];
        }

        System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
        System.out.printf("Total Bonus: %.2f\n", totalBonus);
    }


    public static void main(String[] args) {

        double[][] employees = GetSalaryAndService();

        double[][] result = FindNewSalaryAndBonus(employees);

        Display(employees, result);
    }
}