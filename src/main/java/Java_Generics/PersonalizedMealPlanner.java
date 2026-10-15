package Java_Generics;

import java.util.ArrayList;
import java.util.List;

// Generics assignment 4: generate typed Vegetarian, Vegan, Keto and High-Protein meals.
public class PersonalizedMealPlanner {

    interface MealPlan {
        void addIngredients();
        List<String> getIngredients();
        String getName();
    }

    // Common meal information is reused; each subclass supplies its category.
    abstract static class BasicMeal implements MealPlan {
        final String name;
        final List<String> ingredients = new ArrayList<>();

        BasicMeal(String name) { this.name = name; }
        public String getName() { return name; }
        public List<String> getIngredients() { return ingredients; }
        abstract String category();

        public void addIngredients() {
            System.out.println(name + " | " + category() + " --> preparing the meal");
        }
    }

    static class VegetarianMeal extends BasicMeal {
        VegetarianMeal(String name) { super(name); }
        String category() { return "Vegetarian"; }
    }

    static class VeganMeal extends BasicMeal {
        VeganMeal(String name) { super(name); }
        String category() { return "Vegan"; }
    }

    static class KetoMeal extends BasicMeal {
        KetoMeal(String name) { super(name); }
        String category() { return "Keto"; }
    }

    static class HighProteinMeal extends BasicMeal {
        HighProteinMeal(String name) { super(name); }
        String category() { return "High-Protein"; }
    }

    static class Meal<T extends MealPlan> {
        final T plan;
        Meal(T plan) { this.plan = plan; }
        public T getPlan() { return plan; }

        void prepare() {
            plan.addIngredients();
            System.out.println(plan.getIngredients());
        }
    }

    // Structural validation; the assignment supplies no nutritional rules/database.
    static <T extends MealPlan> Meal<T> addMeal(T plan) {
        if (plan == null || plan.getName() == null || plan.getName().trim().isEmpty()
                || plan.getIngredients() == null || plan.getIngredients().isEmpty()) {
            System.out.println("A meal needs a name and ingredients");
            return null;
        }
        for (String ingredient : plan.getIngredients()) {
            if (ingredient == null || ingredient.trim().isEmpty()) {
                System.out.println("Ingredients cannot be blank");
                return null;
            }
        }
        return new Meal<>(plan);
    }

    public static void main(String[] args) {
        VegetarianMeal v1 = new VegetarianMeal("Pasta");
        v1.ingredients.add("Macaroni");
        v1.ingredients.add("Pasta masala");
        VeganMeal p1 = new VeganMeal("Avocado Sandwich");
        p1.ingredients.add("Avocado");
        p1.ingredients.add("Bread");
        KetoMeal k1 = new KetoMeal("Paneer Salad");
        k1.ingredients.add("Paneer");
        k1.ingredients.add("Lettuce");
        HighProteinMeal h1 = new HighProteinMeal("Lentil Bowl");
        h1.ingredients.add("Lentils");
        h1.ingredients.add("Tofu");

        Meal<VegetarianMeal> pasta = addMeal(v1);
        Meal<VeganMeal> avocadoSandwich = addMeal(p1);
        Meal<KetoMeal> keto = addMeal(k1);
        Meal<HighProteinMeal> protein = addMeal(h1);
        if (pasta != null) pasta.prepare();
        if (avocadoSandwich != null) avocadoSandwich.prepare();
        if (keto != null) keto.prepare();
        if (protein != null) protein.prepare();
    }
}
