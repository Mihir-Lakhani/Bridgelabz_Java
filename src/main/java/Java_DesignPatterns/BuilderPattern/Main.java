package Java_DesignPatterns.BuilderPattern;

import java.util.*;

class Burger{
    private final String patty;
    private final boolean cheese;
    private final boolean lettuce;
    private final String sauce;

    private Burger(Builder builder) {
        this.patty = builder.patty;
        this.cheese = builder.cheese;
        this.lettuce = builder.lettuce;
        this.sauce= builder.sauce;
    }

    void showOrder(){
        System.out.println("Patty: " + this.patty);
        System.out.println("Cheese: " + this.cheese);
        System.out.println("Lettuce: " + this.lettuce);
        System.out.println("Sauce: " + this.sauce);
    }


    static class Builder{

        private final String patty;
        private boolean cheese;
        private boolean lettuce;
        private String sauce = "None";

        Builder(String patty){
            this.patty = patty;
        }

        Builder addCheese(){
            this.cheese = true;
            return this;
        }

        Builder addLettuce(){
            this.lettuce = true;
            return this;
        }

        Builder addSauce(String sauce){
            this.sauce = sauce;
            return this;
        }

        Burger build(){
            return new Burger(this);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Burger burger = new Burger.Builder("Veg")
                .addCheese()
                .addLettuce()
                .addSauce("Tandoori")
                .build();

        burger.showOrder();

        /*
        Burger.Builder builder = new Burger.Builder("Veg"); // Builder object
        builder.addCheese();                                // updates builder
        builder.addLettuce();                               // updates builder
        builder.addSauce("Tandoori");                       // updates builder

        Burger burger = builder.build();                    // creates the Burger
         */

    }
}