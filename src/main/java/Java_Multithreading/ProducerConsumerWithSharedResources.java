package Java_Multithreading;

import java.util.*;

class ProducerConsumer{
    public int[] buffer = new int[5];
    int count = -1;

    synchronized public void input() throws InterruptedException {
        while (count == buffer.length-1){
            System.out.println("Inside input loop");
            wait();
        }
        int number = 1 + (int)(Math.random() * 20);
        count++;
        buffer[count] = number;
        System.out.println("Added number: " + number);
        notify();

    }

    synchronized public void output() throws InterruptedException {
        while (count == -1){
            System.out.println("Inside output loop");
            wait();
        }

        System.out.println("Removed Number: " + buffer[count]);
        count--;
        notify();

    }
}


public class ProducerConsumerWithSharedResources {
    public static void main(String[] args) throws InterruptedException {

        ProducerConsumer pc = new ProducerConsumer();

        Thread producer = new Thread(() -> {
            for(int i = 0; i < 500; i++){
                try {
                    pc.input();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 500; i++){
                try {
                    pc.output();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        Scanner sc = new Scanner(System.in);

    }
}