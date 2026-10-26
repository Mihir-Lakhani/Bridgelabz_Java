package Java_DesignPatterns.FactoryDesign.FactoryMethodPattern;


interface Burger {

    void prepare();

}


class VeggiesBurger implements Burger{

    @Override
    public void prepare(){
        System.out.println("Preparing Veggies Burger");
    }

}


class ChickenBurger implements Burger{

    @Override
    public void prepare(){
        System.out.println("Preparing Chicken Burger");
    }

}


abstract class Restaurant {

    public Burger orderBurger(){
        Burger burger = createBurger();
        burger.prepare();
        return burger;
    }

    public abstract Burger createBurger();
}

class VegBurgerRestro extends Restaurant{

    @Override
    public Burger createBurger(){
        return new VeggiesBurger();
    }

}

class ChickenBurgerRestro extends Restaurant{

    @Override
    public Burger createBurger(){
        return new ChickenBurger();
    }
}

public class Main{
    public static void main(String[] args){

        VegBurgerRestro vegBurgerRestro = new VegBurgerRestro();
        vegBurgerRestro.orderBurger();

        ChickenBurgerRestro chickenBurgerRestro = new ChickenBurgerRestro();
        chickenBurgerRestro.orderBurger();

    }
}


