package Java_Generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmartWarehouseManagementSystem {


    abstract static class WarehouseItem{

        final String name;
        WarehouseItem(String name){
            this.name = name;
        }
    }

    static class Electronics extends WarehouseItem{
        Electronics(String name){
            super(name);
        }
    }

    static class Groceries extends WarehouseItem{
        Groceries(String name){
            super(name);
        }
    }

    static class Furniture extends WarehouseItem{
        Furniture(String name){
            super(name);
        }


    }

    static class Storage<T extends WarehouseItem>{
        List<T> items = new ArrayList<>();
        void add(T a){
            items.add(a);
        }

        T get(int index){
            return items.get(index);
        }

        List<T> items(){
            return Collections.unmodifiableList(items);
        }

    }

    static void display(List<? extends WarehouseItem> items){
        for(WarehouseItem item : items){
            System.out.println(item.name);
        }
    }


    public static void main(String[] args){
        Storage<Electronics> electronics = new Storage<>();
        electronics.add(new Electronics("Laptop"));
        Storage<Groceries> groceries = new Storage<>();
        groceries.add(new Groceries("Rice"));
        Storage<Furniture> furniture = new Storage<>();
        furniture.add(new Furniture("Desk"));
        Electronics laptop = electronics.get(0);
        System.out.println("Retrieved: " + laptop.name);
        display(electronics.items());
        display(groceries.items());
        display(furniture.items());

    }
}