package Java_LinkedLists.PracticeProblems.DoublyLinkedList;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class TextEditor {

    private static class textState{

        String text = content;
        textState next = null;
        textState prev = null;
        static int size = 0;
        static String content = "";

        textState(String content){
            textState.content = content;
        }
    }

    Scanner sc = new Scanner(System.in);

    textState head;
    textState tail;


    void type(String newText){
        if(textState.size < 10){
            textState.size++;
        }else{
            head.next.prev = null;
            head = head.next;

        }
        textState.content += newText;

        textState newNode = new textState(textState.content);


        if (textState.size == 1){
            head = newNode;

        }else{
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        System.out.println(textState.size);
    }

    void display(){
        System.out.println(tail.text);
    }

    void undo(){
        if (textState.size < 2){
            System.out.println("We are at the starting point");
            display();
        }else{
            textState.size--;
            tail = tail.prev;
            textState.content = tail.text;
            display();
        }
    }

    void redo(){
        if(tail.next == null){
            System.out.println("We are at the end...TYPE SOMETHING");
        }else{
            tail = tail.next;
            textState.size++;
            display();
            textState.content = tail.text;
        }
    }



    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.type("Hello");
        editor.type(" world");
        editor.type("!");

        System.out.println("=== Current Text ===");
        editor.display();

        System.out.println("\n=== Undo ===");
        editor.undo();

        System.out.println("\n=== Undo Again ===");
        editor.undo();

        editor.type(" world");
        editor.type(" My");
        editor.type(" Name");
        editor.type(" Is");
        editor.type(" Mihir");
        editor.type(" Lakhani");
        editor.type(" How");
        editor.type(" Are");
        editor.type(" You");
        editor.type(" Guys");

        System.out.println("=== Current Text ===");
        editor.display();

        System.out.println("\n=== Undo ===");
        editor.undo();

        System.out.println("\n=== Undo ===");
        editor.undo();

        System.out.println("\n=== Redo ===");
        editor.redo();

        System.out.println("\n=== Redo Again ===");
        editor.redo();

        System.out.println("\n=== Current Text ===");
        editor.display();
        System.out.println("\n=== Undo ===");
        editor.undo();
        System.out.println("\n=== Undo ===");
        editor.undo();
        System.out.println("\n=== Undo ===");
        editor.undo();
        System.out.println("\n=== Undo ===");
        editor.undo();
        System.out.println("\n=== Undo ===");
        editor.undo();
        System.out.println("\n=== Undo ===");
        editor.undo();
        System.out.println("\n=== Undo ===");
        editor.undo();
        System.out.println("\n=== Undo ===");
        editor.undo();
        System.out.println("\n=== Undo ===");
        editor.undo();
        System.out.println("\n=== Undo ===");
        editor.undo();

        System.out.println(textState.size);

    }
}