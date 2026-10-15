package Java_Collections.Map;

import java.util.*;

// Map 8: catalog lookup, item insertion order and grouped price sorting.
public class ShoppingCart {

    // Monetary values use integer cents so prices can be compared exactly.
    private final Map<String, Long> prices = new HashMap<>();
    private final Map<String, Long> cart = new LinkedHashMap<>();

    void addProduct(String product, long price) { prices.put(product, price); }

    boolean addToCart(String product) {
        if (!prices.containsKey(product)) return false;
        cart.put(product, prices.get(product));
        return true;
    }

    Map<Long, List<String>> sortedByPrice() {
        Map<Long, List<String>> result = new TreeMap<>();
        cart.forEach((product, price) -> result.computeIfAbsent(price,
                key -> new ArrayList<>()).add(product));
        return result; // Equal-price products are all retained.
    }

    public static void main(String[] args) {
        ShoppingCart shopping = new ShoppingCart();
        shopping.addProduct("Book", 1000);
        shopping.addProduct("Pen", 200);
        shopping.addProduct("Pencil set", 200);
        shopping.addToCart("Book");
        shopping.addToCart("Pen");
        shopping.addToCart("Pencil set");
        System.out.println("Added order: " + shopping.cart);
        System.out.println("Sorted by price (cents): " + shopping.sortedByPrice());
    }
}
