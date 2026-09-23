/*
Find the youngest and the tallest btween amar akbar and anthony
 */

package Java_Arrays.Level_2;

import javax.swing.plaf.synth.SynthStyle;
import java.util.Scanner;

public class YoungestAndTallest {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        double[] height = new double[3];
        double[] age = new double[3];

        for(int i=0; i<3; i++){
            System.out.printf("Enter the age of person %d: ", i+1);
            age[i] = sc.nextDouble();

            System.out.printf("Enter the height of person %d: ", i+1);
            height[i] = sc.nextDouble();
        }

        double ans[] = {age[0], height[0]};

        for(double i: age){
            if(ans[0]>i){
                ans[0]=i;
            }
        }
        for(double i: height){
            if(ans[1]<i){
                ans[1]=i;
            }
        }

        String youngest = (ans[0] == 0) ? "Amar" : (ans[0] == 1) ? "Akbar" : "Anthony";
        String tallest = (ans[1] == 0) ? "Amar" : (ans[0] == 1) ? "Akbar" : "Anthony";

        System.out.printf("The Youngest is %s of age %.2f\n", youngest, ans[0]);
        System.out.printf("The Tallest is %s of age %.2f", tallest, ans[1]);

    }
}
