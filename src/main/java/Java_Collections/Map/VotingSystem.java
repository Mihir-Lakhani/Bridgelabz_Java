package Java_Collections.Map;

import java.util.*;

// Map 7: vote counts, alphabetical results and order of first vote for each candidate.
public class VotingSystem {

    private final Map<String, Integer> votes = new HashMap<>();
    private final Map<String, Integer> firstVoteOrder = new LinkedHashMap<>();

    void vote(String candidate) {
        votes.merge(candidate, 1, Integer::sum);
        firstVoteOrder.merge(candidate, 1, Integer::sum);
    }

    Map<String, Integer> sortedResults() { return new TreeMap<>(votes); }

    public static void main(String[] args) {
        VotingSystem election = new VotingSystem();
        election.vote("Bob");
        election.vote("Alice");
        election.vote("Bob");
        election.vote("Carol");
        System.out.println("Sorted by candidate: " + election.sortedResults());
        System.out.println("First-vote order: " + election.firstVoteOrder);
    }
}
