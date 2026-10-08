/*
6. Circular Linked List: Round Robin Scheduling Algorithm
Each process contains Process ID, Burst Time, and Priority.
Operations:
1. Add a process at the end of the circular list.
2. Remove a process by ID after execution.
3. Simulate round robin scheduling using a fixed time quantum.
4. Display the remaining processes after each complete round.
5. Calculate average waiting time and turnaround time.
Assumptions: All processes arrive at time 0; context switching takes no time.
Priority is stored for display. Round robin serves processes in queue order.
Turnaround time = completion time - arrival time = completion time here.
Waiting time = turnaround time - original burst time.
 */

package Java_LinkedLists.PracticeProblems.CircularLinkedList;

public class RoundRobinScheduling {

    private class Process {
        private final String processId;
        private final int burstTime;
        private final int priority;
        private int remainingTime;
        private Process next;

        Process(String processId, int burstTime, int priority) {
            this.processId = processId;
            this.burstTime = burstTime;
            this.priority = priority;
            this.remainingTime = burstTime;
        }

        void displayProcess() {
            System.out.printf("ID: %s | Burst: %d | Remaining: %d | Priority: %d%n",
                    processId, burstTime, remainingTime, priority);
        }
    }

    private Process head;
    private Process tail;
    private int size;
    private double averageWaitingTime;
    private double averageTurnaroundTime;

    void addEnd(String processId, int burstTime, int priority) {
        if (processId == null || processId.isBlank() || burstTime <= 0) {
            System.out.println("Enter a non-empty process ID and a positive burst time");
            return;
        }
        if (head != null) {
            Process current = head;
            do {
                if (current.processId.equals(processId)) {
                    System.out.println("Process ID already exists: " + processId);
                    return;
                }
                current = current.next;
            } while (current != head);
        }

        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            newProcess.next = newProcess;
        } else {
            newProcess.next = head;
            tail.next = newProcess;
            tail = newProcess;
        }
        size++;
    }

    private void unlink(Process previous, Process current) {
        if (size == 1) {
            head = tail = null;
        } else {
            previous.next = current.next;
            if (current == head) head = current.next;
            if (current == tail) tail = previous;
            tail.next = head;
        }
        current.next = null;
        size--;
    }

    void remove(String processId) {
        if (head == null) {
            System.out.println("Process queue is empty");
            return;
        }
        Process previous = tail;
        Process current = head;
        do {
            if (current.processId.equals(processId)) {
                unlink(previous, current);
                System.out.println("Removed process: " + processId);
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
        System.out.println("Process not found: " + processId);
    }

    void displayProcesses() {
        if (head == null) {
            System.out.println("Process queue is empty");
            return;
        }
        Process current = head;
        do {
            current.displayProcess();
            current = current.next;
        } while (current != head);
    }

    void simulate(int timeQuantum) {
        if (timeQuantum <= 0) {
            System.out.println("Time quantum must be positive");
            return;
        }
        if (head == null) {
            System.out.println("No processes to schedule");
            return;
        }

        int processCount = size;
        int round = 1;
        long elapsedTime = 0;
        long totalWaitingTime = 0;
        long totalTurnaroundTime = 0;
        Process current = head;
        Process previous = tail;

        while (head != null) {
            System.out.println("\n=== Round " + round + " ===");
            // Each process present at the start of this round gets one turn.
            int turnsThisRound = size;
            for (int i = 0; i < turnsThisRound; i++) {
                Process nextProcess = current.next;
                int executionTime = Math.min(timeQuantum, current.remainingTime);
                long startTime = elapsedTime;
                elapsedTime += executionTime;
                current.remainingTime -= executionTime;
                System.out.printf("%s executes from %d to %d; remaining: %d%n",
                        current.processId, startTime, elapsedTime, current.remainingTime);

                if (current.remainingTime == 0) {
                    long turnaroundTime = elapsedTime;
                    long waitingTime = turnaroundTime - current.burstTime;
                    totalTurnaroundTime += turnaroundTime;
                    totalWaitingTime += waitingTime;
                    System.out.printf("%s completed | Waiting: %d | Turnaround: %d%n",
                            current.processId, waitingTime, turnaroundTime);
                    // The previous node remains the predecessor of nextProcess.
                    unlink(previous, current);
                } else {
                    previous = current;
                }
                current = head == null ? null : nextProcess;
            }

            System.out.println("Queue after round " + round + ":");
            displayProcesses();
            round++;
        }

        averageWaitingTime = (double) totalWaitingTime / processCount;
        averageTurnaroundTime = (double) totalTurnaroundTime / processCount;
        System.out.printf("%nAverage waiting time: %.2f%n", averageWaitingTime);
        System.out.printf("Average turnaround time: %.2f%n", averageTurnaroundTime);
    }

    public double getAverageWaitingTime() {
        return averageWaitingTime;
    }

    public double getAverageTurnaroundTime() {
        return averageTurnaroundTime;
    }

    public static void main(String[] args) {
        RoundRobinScheduling scheduler = new RoundRobinScheduling();
        scheduler.addEnd("P101", 5, 1);
        scheduler.addEnd("P102", 3, 2);
        scheduler.addEnd("P103", 1, 3);
        System.out.println("=== Initial Process Queue ===");
        scheduler.displayProcesses();
        System.out.println("\nTime quantum: 2");
        scheduler.simulate(2);
    }
}
