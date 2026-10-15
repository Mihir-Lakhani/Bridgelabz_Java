package Java_Generics;

import java.util.ArrayList;
import java.util.List;

// Generics assignment 2: a catalog with typed product categories and discounts.
public class DynamcOnlineMarketPlace {

    abstract static class Category {
        final String name;
        final double minPrice;
        final double maxPrice;

        Category(String name, double minPrice, double maxPrice) {
            this.name = name;
            this.minPrice = minPrice;
            this.maxPrice = maxPrice;
        }
    }

    // Example ranges: the assignment does not specify numerical limits.
    static class BookCategory extends Category {
        BookCategory() { super("Books", 100, 2000); }
    }

    static class ClothingCategory extends Category {
        ClothingCategory() { super("Clothing", 200, 5000); }
    }

    static class GadgetCategory extends Category {
        GadgetCategory() { super("Gadgets", 1000, 100000); }
    }

    static class Product<T extends Category> {
        final String name;
        final T category;
        double price;

        Product(String name, double price, T category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        boolean isInPriceRange() {
            return Double.isFinite(price)
                    && price >= category.minPrice && price <= category.maxPrice;
        }

        void display() {
            System.out.println(name + " | " + category.name + " | Price: " + price);
        }
    }

    static <T extends Category> void applyDiscount(Product<T> product, double percentage) {
        if (!Double.isFinite(percentage) || percentage < 0 || percentage > 100) {
            System.out.println("Discount must be between 0 and 100");
            return;
        }
        double discountedPrice = product.price * (1 - percentage / 100);
        if (discountedPrice < product.category.minPrice
                || discountedPrice > product.category.maxPrice || !product.isInPriceRange()) {
            System.out.println("Price outside category range: " + product.name);
            return;
        }
        product.price = discountedPrice;
    }

    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Book", 500, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Shirt", 1000, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Phone", 20000, new GadgetCategory());

        List<Product<?>> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);

        applyDiscount(book, 10);
        applyDiscount(shirt, 20);
        applyDiscount(phone, 5);
        for (Product<?> product : catalog) {
            product.display();
        }
    }
}
