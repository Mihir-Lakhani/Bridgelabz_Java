/*
4. Singly Linked List: Inventory Management System
Problem Statement: Manage items containing Item Name, Item ID, Quantity, and Price.
Tasks:
1. Add an item at the beginning, end, or a specific position.
2. Remove an item by Item ID.
3. Update an item's quantity by Item ID.
4. Search by Item ID or Item Name.
5. Display the total inventory value: sum of Price * Quantity.
6. Sort by Item Name or Price in ascending or descending order.
Hint: Use next pointers for the singly linked list and merge sort for sorting.
Positions in this program are zero-based: position 0 means the beginning.
 */

package Java_LinkedLists.PracticeProblems.SinglyLinkedList;

public class InventoryManagementSystem {

    private static class Item {
        private final String name;
        private final String itemId;
        private int quantity;
        private final double price;
        private Item next;

        Item(String name, String itemId, int quantity, double price) {
            this.name = name;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
        }

        void displayDetails() {
            System.out.printf("ID: %s | Name: %s | Quantity: %d | Price: %.2f%n",
                    itemId, name, quantity, price);
        }
    }

    private static Item head;

    private static Item findById(String itemId) {
        Item current = head;
        while (current != null) {
            if (current.itemId.equals(itemId)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private static boolean validItem(String name, String itemId, int quantity, double price) {
        if (name == null || name.isBlank() || itemId == null || itemId.isBlank()) {
            System.out.println("Item name and ID cannot be empty");
            return false;
        }
        if (quantity < 0 || price < 0 || !Double.isFinite(price)) {
            System.out.println("Quantity and price must be non-negative; price must be finite");
            return false;
        }
        if (findById(itemId) != null) {
            System.out.println("Item ID already exists: " + itemId);
            return false;
        }
        return true;
    }

    static void addBeginning(String name, String itemId, int quantity, double price) {
        if (!validItem(name, itemId, quantity, price)) {
            return;
        }
        Item newItem = new Item(name, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    static void addEnd(String name, String itemId, int quantity, double price) {
        if (!validItem(name, itemId, quantity, price)) {
            return;
        }
        Item newItem = new Item(name, itemId, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newItem;
    }

    static void addAtPosition(String name, String itemId, int quantity, double price, int position) {
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 0) {
            addBeginning(name, itemId, quantity, price);
            return;
        }
        Item current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position is beyond the list");
            return;
        }
        if (!validItem(name, itemId, quantity, price)) {
            return;
        }
        Item newItem = new Item(name, itemId, quantity, price);
        newItem.next = current.next;
        current.next = newItem;
    }

    static void remove(String itemId) {
        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }
        if (head.itemId.equals(itemId)) {
            head = head.next;
            System.out.println("Removed item: " + itemId);
            return;
        }
        Item current = head;
        while (current.next != null && !current.next.itemId.equals(itemId)) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Item not found: " + itemId);
            return;
        }
        current.next = current.next.next;
        System.out.println("Removed item: " + itemId);
    }

    static void updateQuantity(String itemId, int newQuantity) {
        if (newQuantity < 0) {
            System.out.println("Quantity cannot be negative");
            return;
        }
        Item item = findById(itemId);
        if (item == null) {
            System.out.println("Item not found: " + itemId);
            return;
        }
        item.quantity = newQuantity;
        System.out.println("Updated quantity for " + itemId + " to " + newQuantity);
    }

    static void searchById(String itemId) {
        Item item = findById(itemId);
        if (item == null) {
            System.out.println("Item not found: " + itemId);
        } else {
            item.displayDetails();
        }
    }

    static void searchByName(String name) {
        boolean found = false;
        Item current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                current.displayDetails();
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Item not found: " + name);
        }
    }

    static double calculateTotalValue() {
        double total = 0;
        Item current = head;
        while (current != null) {
            total += current.price * current.quantity;
            current = current.next;
        }
        return total;
    }

    static void displayAll() {
        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }
        Item current = head;
        while (current != null) {
            current.displayDetails();
            current = current.next;
        }
    }

    static void sortByName(boolean ascending) {
        head = mergeSort(head, false, ascending);
    }

    static void sortByPrice(boolean ascending) {
        head = mergeSort(head, true, ascending);
    }

    private static Item mergeSort(Item start, boolean byPrice, boolean ascending) {
        if (start == null || start.next == null) {
            return start;
        }

        // Find the midpoint, then disconnect the two halves.
        Item slow = start;
        Item fast = start.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Item secondHalf = slow.next;
        slow.next = null;

        Item left = mergeSort(start, byPrice, ascending);
        Item right = mergeSort(secondHalf, byPrice, ascending);
        return merge(left, right, byPrice, ascending);
    }

    private static Item merge(Item left, Item right, boolean byPrice, boolean ascending) {
        Item dummy = new Item("", "", 0, 0);
        Item tail = dummy;
        while (left != null && right != null) {
            int comparison = byPrice
                    ? Double.compare(left.price, right.price)
                    : left.name.compareToIgnoreCase(right.name);

            // Equal values keep their original order (stable sorting).
            if (ascending ? comparison <= 0 : comparison >= 0) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        tail.next = left != null ? left : right;
        return dummy.next;
    }

    public static void main(String[] args) {
        addEnd("Rice", "I101", 10, 60);
        addBeginning("Milk", "I102", 6, 30);
        addEnd("Bread", "I103", 8, 40);
        addAtPosition("Apples", "I104", 5, 100, 1);

        System.out.println("=== Inventory ===");
        displayAll();

        System.out.println("\n=== Search by ID and Name ===");
        searchById("I103");
        searchByName("rice");

        System.out.println("\n=== Update Quantity ===");
        updateQuantity("I102", 10);
        System.out.printf("Total inventory value: %.2f%n", calculateTotalValue());

        System.out.println("\n=== Name: Ascending ===");
        sortByName(true);
        displayAll();
        System.out.println("\n=== Name: Descending ===");
        sortByName(false);
        displayAll();

        System.out.println("\n=== Price: Ascending ===");
        sortByPrice(true);
        displayAll();
        System.out.println("\n=== Price: Descending ===");
        sortByPrice(false);
        displayAll();

        System.out.println("\n=== Remove I104 ===");
        remove("I104");
        displayAll();
        System.out.printf("Total inventory value: %.2f%n", calculateTotalValue());
    }
}
