/*
Circular Tour Problem
Problem: Given a set of petrol pumps with petrol and distance to the next pump, determine the starting point for completing a circular tour.
Hint: Use a queue to simulate the tour, keeping track of surplus petrol at each pump.
 */

package Java_StackQueueHashMapAndHashing.StacksAndQueue;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Queue;

public class CircularTourGasStationProblem {


    static int GasStation(int[] cost, int[] reserve) {
        if (cost == null || reserve == null
                || cost.length == 0 || cost.length != reserve.length) {
            throw new IllegalArgumentException("Invalid arrays");
        }

        int total = 0;

        for (int i = 0; i < cost.length; i++) {
            total += (int) reserve[i] - cost[i];
        }

        if (total < 0) {
            return -1;
        }

        Queue<Integer> tour = new ArrayDeque<>();

        int remain = 0;
        int index = 0;

        while (tour.size() < cost.length) {
            tour.offer(index);
            remain += reserve[index] - cost[index];

            if (remain < 0) {
                tour.clear();
                remain = 0;
            }

            index = (index + 1) % cost.length;
        }

        return tour.peek();
    }


    public static void main(String[] args) {
        int[] reserve = {2, 3, 4};
        int[] cost = {3, 4, 3};
        int start = GasStation(cost, reserve);
        System.out.println(start);

        int[] reserve2 = {1, 2, 3, 4, 5};
        int[] cost2 = {3, 4, 5, 1, 2};
        start = GasStation(cost2, reserve2);
        System.out.println(start);
    }
}