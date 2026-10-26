package Java_DesignPatterns.FactoryDesign.SingleFactoryPattern;


interface Burger {
    void prepare();
}

class VeggiesBurger implements Burger {

    @Override
    public void prepare(){
        System.out.println("Preparing Veggie Burger");
    }
}


class ChickenBurger implements Burger {

    @Override
    public void prepare(){
        System.out.println("Preparing Chicken Burger");
    }
}

class BurgerFactory{

    public static Burger getBurger(String type){
        if (type.equalsIgnoreCase("veggies")){
            return new VeggiesBurger();
        }else if (type.equalsIgnoreCase("chicken")){
            return new ChickenBurger();
        }
        return null;
    }
}


public class SingleFactoryPatternRestaurant {
    public static void main(String[] args) {

        Burger vegburger = BurgerFactory.getBurger("veggies");
        Burger chickenburger = BurgerFactory.getBurger("chicken");

        vegburger.prepare();
        chickenburger.prepare();
    }
}



