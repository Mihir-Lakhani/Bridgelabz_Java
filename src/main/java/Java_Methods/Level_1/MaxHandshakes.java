/*
2. 3. A program to calculate the number of handshakes among N people
 */

package Java_Methods.Level_1;
import java.util.Scanner;

public class MaxHandshakes {

    public int handshakes(int n){

        int handshakes = (n*(n-1))/2;
        return handshakes;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of people: ");
        int n = sc.nextInt();
        MaxHandshakes obj = new MaxHandshakes();
        System.out.printf("The max number of handshakes among %d people will be %d.", n, obj.handshakes(n));
    }

}
