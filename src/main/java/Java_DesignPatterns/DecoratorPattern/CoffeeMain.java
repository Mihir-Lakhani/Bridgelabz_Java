package Java_DesignPatterns.DecoratorPattern;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.*;



interface Coffee{
    int getCost();
    String getDesc();
}

class PlainCoffee implements Coffee{
    private static Coffee coffee;

    @MethodInfo(author = "Mihir")
    public int getCost(){
        return 80;
    }

    @MethodInfo(author = "Mihir", revision = 3)
    public String getDesc(){
        return "Plain Milk";
    }
}

class SugarCoffee implements Coffee{
    private Coffee coffee;

    SugarCoffee(Coffee coffee){
        this.coffee = coffee;
    }

    public int getCost(){
        return 5 + coffee.getCost();
    }

    public String getDesc(){
        return "Sugar and " + coffee.getDesc();
    }
}

class CreamCoffee implements Coffee{
    private Coffee coffee;

    CreamCoffee(Coffee coffee){
        this.coffee = coffee;
    }

    public int getCost(){
        return 20 + coffee.getCost();
    }

    public String getDesc(){
        return "Cream and " + coffee.getDesc();
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MethodInfo{
    String author();
    int revision() default 1;
}

public class CoffeeMain {

    static void showInfo(Method method){
        if(method.isAnnotationPresent(MethodInfo.class))
        {
            MethodInfo info = method.getAnnotation(MethodInfo.class);

            System.out.println(method.getName());
            System.out.println(info.author());
        }
    }


    public static void main(String[] args) throws NoSuchMethodException {

        showInfo(PlainCoffee.class.getDeclaredMethod("getDesc"));


        Coffee creamCoffee = new CreamCoffee(new SugarCoffee(new PlainCoffee()));

        System.out.println(creamCoffee.getCost());
        System.out.println(creamCoffee.getDesc());

    }
}
