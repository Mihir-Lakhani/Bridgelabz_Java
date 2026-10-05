package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.AssistedProblems.BankAndAccuntHolders;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Account> accounts = new ArrayList<>();

    Customer(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void addAccount(Account account){
        accounts.add(account);
    }

    void viewBalance(){
        System.out.println("Account balances for " + name + ":");
        if (accounts.isEmpty()){
            System.out.println("No accounts opened yet.");
            return;
        }

        for (Account account : accounts){
            System.out.println("Bank: " + account.getBank().getName());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.printf("Balance: %.2f%n", account.getBalance());
            System.out.println();
        }
    }
}
