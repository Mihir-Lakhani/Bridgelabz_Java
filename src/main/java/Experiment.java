import java.util.Scanner;

public class Experiment {
    int a = 10;
    static int b = 15;

    public void exp(int a, int b){
        this.a = a;
        System.out.println(a);
        this.b = b;
        System.out.println(b);
    }

    static int add(int a, int b, Experiment obj){
        obj.exp(a,b);
        return obj.a + b;
    }

    public static void main(String[] args) {
        Experiment obj1 = new Experiment();
        Experiment obj2 = new Experiment();
        System.out.println(obj1.a);
        System.out.println(obj2.b);
        obj1.exp(100, 500);
        System.out.println(obj2.b);
        System.out.println(add(obj1.a, 4000, obj1));

    }

}