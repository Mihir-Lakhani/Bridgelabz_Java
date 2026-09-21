/*
This is a Program to Compute the Age of Harry if we are given the birth year as 2000
and the current year as 2024
 */


public class AgeOfHarry{
    public static void main(String[] args){

        //Create an int variable birth_year and assign the default value 2000
        int birth_year=2000;

        //Create an int variable current_year and assign the value 2024
        int current_year=2024;

        //Create an int variable AgeOfHarry that defines the current age of him by subtracting current year with birth year
        int AgeOfHarry= current_year - birth_year;

        //Print the computed age of Harryy
        System.out.printf("Harry's age in 2024 is %d", AgeOfHarry);
    }
}