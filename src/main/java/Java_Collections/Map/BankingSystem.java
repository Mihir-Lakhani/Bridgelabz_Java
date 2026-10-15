package Java_Collections.Map;

import java.util.*;

// Map 9: account balances, balance sorting and FIFO withdrawal requests.
public class BankingSystem {

    private final Map<String, Long> accounts = new HashMap<>();
    private final Queue<Request> requests = new ArrayDeque<>();

    static class Request {
        final String account;
        final long amount;
        Request(String account, long amount) { this.account = account; this.amount = amount; }
    }

    boolean addAccount(String account, long balance) {
        if (balance < 0 || accounts.containsKey(account)) return false;
        accounts.put(account, balance);
        return true;
    }

    void requestWithdrawal(String account, long amount) {
        requests.offer(new Request(account, amount));
    }

    void processWithdrawals() {
        while (!requests.isEmpty()) {
            Request request = requests.remove();
            Long balance = accounts.get(request.account);
            if (balance == null || request.amount <= 0 || request.amount > balance) {
                System.out.println("Rejected: " + request.account);
            } else {
                accounts.put(request.account, balance - request.amount);
                System.out.println("Paid: " + request.account);
            }
        }
    }

    Map<Long, List<String>> sortedByBalance() {
        Map<Long, List<String>> result = new TreeMap<>();
        for (String account : new TreeSet<>(accounts.keySet())) {
            result.computeIfAbsent(accounts.get(account), balance -> new ArrayList<>()).add(account);
        }
        return result;
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.addAccount("A", 1000);
        bank.addAccount("B", 1000);
        bank.addAccount("C", 500);
        bank.requestWithdrawal("A", 200);
        bank.requestWithdrawal("C", 600);
        bank.requestWithdrawal("B", 200);
        bank.requestWithdrawal("Z", 100);
        bank.processWithdrawals();
        System.out.println("Balances (cents): " + bank.sortedByBalance());
    }
}
