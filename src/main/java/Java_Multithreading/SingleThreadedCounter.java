package Java_Multithreading;

import java.util.*;


class Counter{
    int count = 1;
    int limit;

    synchronized void increment(){
        count++;
    }
}

public class SingleThreadedCounter {
    public static void main(String[] args) {


        Counter counter = new Counter();
        Scanner sc = new Scanner(System.in);
        counter.limit = 10000;


        Thread t1 = new Thread(() -> {
            for(int i = 1; i<=counter.limit; i++){
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 1; i<counter.limit; i++){
                counter.increment();
            }
        });
        t1.start();
        t2.start();
        try {
        t1.join();
        t2.join();
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        System.out.println(counter.count);
    }
}
