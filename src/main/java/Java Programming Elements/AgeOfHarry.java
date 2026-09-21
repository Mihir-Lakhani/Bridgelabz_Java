/*
This is a Program to Compute the Age of Harry if we are given the birth year as 2000
and the current year as 2024
 */


public class AgeOfHarry{
    public static void main(String[] args){
        int birth_year=2000;
        int current_year=2024;
        int AgeOfHarry= current_year - birth_year;
        System.out.printf("Harry's age in 2024 is %d", AgeOfHarry);
    }
}