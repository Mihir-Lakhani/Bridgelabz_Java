/*
4. 5. 6. Create a UnitConvertor utility class with static methods
for different unit conversions.
 */

package Java_Methods.Level_2;

import java.util.Scanner;

public class UnitConvertor {

    //4. Method to convert Kilometers to Miles
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    //4. Method to convert Miles to Kilometers
    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    //4. Method to convert Meters to Feet
    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    //4. Method to convert Feet to Meters
    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }

    //5. Method to convert Yards to Feet
    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }

    //5. Method to convert Feet to Yards
    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }

    //5. Method to convert Meters to Inches
    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

    //5. Method to convert Inches to Meters
    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

    //5. Method to convert Inches to Centimeters
    public static double convertInchesToCm(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }

    //6. Method to convert Fahrenheit to Celsius
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        double fahrenheit2celsius = (fahrenheit - 32) * 5.0 / 9.0;
        return fahrenheit2celsius;
    }

    //6. Method to convert Celsius to Fahrenheit
    public static double convertCelsiusToFahrenheit(double celsius) {
        double celsius2fahrenheit = (celsius * 9.0 / 5.0) + 32;
        return celsius2fahrenheit;
    }

    //6. Method to convert Pounds to Kilograms
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    //6. Method to convert Kilograms to Pounds
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    //6. Method to convert Gallons to Liters
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    //6. Method to convert Liters to Gallons
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter value for Kilometers: ");
        double km = sc.nextDouble();

        System.out.println("Enter value for Miles: ");
        double miles = sc.nextDouble();

        System.out.println("Enter value for Meters: ");
        double meters = sc.nextDouble();

        System.out.println("Enter value for Feet: ");
        double feet = sc.nextDouble();

        System.out.println("Enter value for Yards: ");
        double yards = sc.nextDouble();

        System.out.println("Enter value for Inches: ");
        double inches = sc.nextDouble();

        System.out.println("Enter temperature in Fahrenheit: ");
        double fahrenheit = sc.nextDouble();

        System.out.println("Enter temperature in Celsius: ");
        double celsius = sc.nextDouble();

        System.out.println("Enter weight in Pounds: ");
        double pounds = sc.nextDouble();

        System.out.println("Enter weight in Kilograms: ");
        double kilograms = sc.nextDouble();

        System.out.println("Enter value in Gallons: ");
        double gallons = sc.nextDouble();

        System.out.println("Enter value in Liters: ");
        double liters = sc.nextDouble();

        //Print all converted values
        System.out.printf("%.2f km = %.2f miles%n",
                km, convertKmToMiles(km));

        System.out.printf("%.2f miles = %.2f km%n",
                miles, convertMilesToKm(miles));

        System.out.printf("%.2f meters = %.2f feet%n",
                meters, convertMetersToFeet(meters));

        System.out.printf("%.2f feet = %.2f meters%n",
                feet, convertFeetToMeters(feet));

        System.out.printf("%.2f yards = %.2f feet%n",
                yards, convertYardsToFeet(yards));

        System.out.printf("%.2f feet = %.2f yards%n",
                feet, convertFeetToYards(feet));

        System.out.printf("%.2f meters = %.2f inches%n",
                meters, convertMetersToInches(meters));

        System.out.printf("%.2f inches = %.2f meters%n",
                inches, convertInchesToMeters(inches));

        System.out.printf("%.2f inches = %.2f centimeters%n",
                inches, convertInchesToCm(inches));

        System.out.printf("%.2f Fahrenheit = %.2f Celsius%n",
                fahrenheit, convertFahrenheitToCelsius(fahrenheit));

        System.out.printf("%.2f Celsius = %.2f Fahrenheit%n",
                celsius, convertCelsiusToFahrenheit(celsius));

        System.out.printf("%.2f pounds = %.2f kilograms%n",
                pounds, convertPoundsToKilograms(pounds));

        System.out.printf("%.2f kilograms = %.2f pounds%n",
                kilograms, convertKilogramsToPounds(kilograms));

        System.out.printf("%.2f gallons = %.2f liters%n",
                gallons, convertGallonsToLiters(gallons));

        System.out.printf("%.2f liters = %.2f gallons%n",
                liters, convertLitersToGallons(liters));
    }
}