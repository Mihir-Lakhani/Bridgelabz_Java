/*
6. Write a program SpringSeason that takes two int values month and day from the command line
and prints “It's a Spring Season” otherwise prints “Not a Spring Season”.
 */

package Java_Methods.Level_1;
import java.util.Scanner;

public class SpringSeason {
    public boolean season(int m, int d){
        if(m == 3 && d >= 20){
            return true;

        }else if(m == 4 || m == 5){
            return true;

        }else if(m == 6 && d <= 20){
            return true;
        }

        return false;
    }

    public static void main(String[] args){
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);

        SpringSeason obj = new SpringSeason();

        System.out.printf("%s a Spring Season", (obj.season(m, d)) ? "It's" : "Not", "a Spring Season");
    }
}
