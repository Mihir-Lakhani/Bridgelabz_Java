package Java_StackQueueHashMapAndHashing.HashMapAndHashing;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomHashMap {

    private class Node{

        int key;
        String value;
        Node next = null;

        Node(int key, String value){
            this.key = key;
            this.value = value;
        }
    }
    private int size = 0;


    void put(int key, String value) {
        int index = Math.floorMod(key, buckets.size());
        Node head = buckets.get(index);

        // Update the value if the key already exists.
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        // Insert a new entry at the beginning of this bucket.
        Node newNode = new Node(key, value);
        newNode.next = head;
        buckets.set(index, newNode);
        size++;


    }

    String get(int key){
        int index = Math.floorMod(key,5);
        Node head = buckets.get(index);
        if (head == null){
            return null;
        }

        Node current = head;
        while(current!=null){
            if (current.key == key){
                return current.value;
            }
            current = current.next;
        }
        return null;

    }

    void remove(int key){
        int index = Math.floorMod(key,5);
        Node head = buckets.get(index);
        if(!containsKey(key)){
            System.out.println("Key not present");
            return;
        }

        if(head.key == key){
            head = head.next;
            buckets.set(index, head);
            size--;
        }else{
            Node current = head;
            while(current.next!=null){
                if (current.next.key == key){
                    current.next = current.next.next;
                    size--;
                    return;
                }
                current = current.next;
            }
        }


    }

    boolean containsKey(int key){
        int index = Math.floorMod(key,5);
        Node head = buckets.get(index);
        if (head == null){
            return false;
        }

        Node current = head;
        while(current!=null){
            if (current.key == key){
                return true;
            }
            current = current.next;
        }
        return false;
    }


    ArrayList<Node> buckets = new ArrayList<>();
    CustomHashMap(){
        for(int i = 0; i < 5; i++){
            buckets.add(null);
        }
    }

    public static void main(String[] args) {


        CustomHashMap map = new CustomHashMap();

        map.put(5,"Mihir");
        map.put(10,"Shrey");
        map.put(7,"Sanidhya");
        map.put(1,"Rishika");
        map.put(2,"Jinay");

        System.out.println(map.get(10));

    }
}
