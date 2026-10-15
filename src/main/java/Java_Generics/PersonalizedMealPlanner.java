package Java_Generics;

import java.util.*;

public class PersonalizedMealPlanner {

    static interface MealPlan{
        void addIngredients();
        List<String> getIngredients();
    }

    static class VegetarianMeal implements MealPlan{
        String name;
        List<String> ingredients = new ArrayList<>();

        VegetarianMeal(String name){
            this.name =name;
        }

        @Override
        public void addIngredients(){
            System.out.println(getName());
            System.out.println("Vegetarian Ing --> starting to prepare the meal");
        }

        @Override
        public List<String> getIngredients(){
            return ingredients;
        }

        public String getName() {
            return name;
        }
    }


    static class VeganMeal implements MealPlan{
        String name;
        List<String> ingredients = new ArrayList<>();

        VeganMeal(String name){
            this.name =name;
        }

        @Override
        public void addIngredients(){
            System.out.println(getName());
            System.out.println("Vegan Ing --> starting to prepare the meal");
        }

        @Override
        public List<String> getIngredients(){
            return ingredients;
        }

        public String getName() {
            return name;
        }
    }

    static class Meal<T extends MealPlan>{
        T plan;
        Meal(T plan){
            this.plan = plan;
        }

        public T getPlan() {
            return plan;
        }

        void prepare(){
            plan.addIngredients();
            System.out.println(plan.getIngredients());
        }
    }

    static <T extends MealPlan> Meal<T> addMeal(T plan){
        return new Meal<>(plan);
    }


    public static void main(String[] args) {

        VegetarianMeal v1 = new VegetarianMeal("Pasta");
        VegetarianMeal v2 = new VegetarianMeal("Maggie");
        v1.ingredients.add("Macaroni");
        v1.ingredients.add("pasta masala");
        v2.ingredients.add("noodles");
        v2.ingredients.add("maggie masala");

        VeganMeal p1 = new VeganMeal("Avocado Sandwich");
        VeganMeal p2 = new VeganMeal("Eggs hehe");
        p1.ingredients.add("Avocado");
        p1.ingredients.add("Bread");
        p2.ingredients.add("chicken");
        p2.ingredients.add("it's eggs");


        Meal<VegetarianMeal> pasta = new Meal<>(v1);
        Meal<VegetarianMeal> maggie = new Meal<>(v2);
        Meal<VeganMeal> avocadoSandwich= addMeal(p1);
        Meal<VeganMeal> eggs = new Meal<>(p2);

        pasta.prepare();
        maggie.prepare();
        avocadoSandwich.prepare();
        eggs.prepare();
    }
}