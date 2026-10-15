package Java_Collections.Queue;

import java.util.*;

// Queue 3: higher severity first; equal severity follows arrival order.
public class HospitalTriageSystem {

    static class Patient {
        final String name;
        final int severity;
        final long arrival;
        Patient(String name, int severity, long arrival) {
            this.name = name;
            this.severity = severity;
            this.arrival = arrival;
        }
    }

    private long nextArrival;
    private final Queue<Patient> patients = new PriorityQueue<>(
            Comparator.comparingInt((Patient p) -> p.severity).reversed()
                    .thenComparingLong(p -> p.arrival));

    void admit(String name, int severity) {
        patients.offer(new Patient(name, severity, nextArrival++));
    }

    Patient treatNext() { return patients.poll(); }

    public static void main(String[] args) {
        HospitalTriageSystem hospital = new HospitalTriageSystem();
        hospital.admit("John", 3);
        hospital.admit("Alice", 5);
        hospital.admit("Bob", 2);
        Patient next;
        while ((next = hospital.treatNext()) != null) System.out.println(next.name);
    }
}
