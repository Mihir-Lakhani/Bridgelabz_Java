package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.AssistedProblems.BankAndAccuntHolders;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Account> accounts = new ArrayList<>();

    Bank(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void openAccount(Customer customer, String accountNumber, double balance){
        Account account = new Account(accountNumber, balance, this, customer);
        accounts.add(account);
        customer.addAccount(account);
    }

    void displayAccounts(){
        System.out.println("Accounts in " + name + ":");
        for (Account account : accounts){
            System.out.println(account.getAccountNumber() + " - " + account.getCustomer().getName());
        }
    }
}
