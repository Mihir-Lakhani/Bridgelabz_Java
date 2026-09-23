/*
10. Create a program to divide N number of chocolates among M children.
 */

package Java_Methods.Level_1;
import java.util.Scanner;

public class NChocolatesAmongMChildren {
    public static int[] distribute(int n, int m){
        int choco = n/m;
        int remain = n%m;

        int ans[] = {choco, remain};
        return ans;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of chocolates: ");
        int n = sc.nextInt();

        System.out.println("Enter the number of students: ");
        int m = sc.nextInt();
        int ans[] = distribute(n,m);
        System.out.printf("Number of chocolate per student - %d, number of remaining chocolates - %d", ans[0], ans[1]);
    }
}
