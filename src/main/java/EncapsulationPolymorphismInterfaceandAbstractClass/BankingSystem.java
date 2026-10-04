/*
4. Banking System
Description: Create a banking system with different account types:
Define an abstract class BankAccount with fields like accountNumber, holderName, and balance.
Add methods like deposit(double amount) and withdraw(double amount) (concrete) and calculateInterest() (abstract).
Implement subclasses SavingsAccount and CurrentAccount with unique interest calculations.
Create an interface Loanable with methods applyForLoan() and calculateLoanEligibility().
Use encapsulation to secure account details and restrict unauthorized access.
Demonstrate polymorphism by processing different account types and calculating interest dynamically.
 */

package EncapsulationPolymorphismInterfaceandAbstractClass;

import java.util.List;
import java.util.ArrayList;


abstract class BankAccount implements Loanable{
    private final long accountNumber;
    private String holderName;
    private double balance;

    BankAccount(long accountNumber, String holderName, double balance){
        if (balance < 0) {
            throw new IllegalArgumentException("Starting balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public long getAccountNumber() {return accountNumber;}

    public double getBalance() {return balance;}

    public String getHolderName() {return holderName;}

    public void setHolderName(String holderName) {this.holderName = holderName;}

    void deposit(double amount){
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive");
            return;
        }
        System.out.printf("Previous Balance: %.2f\n", balance);
        balance+=amount;
        System.out.printf("Balance after Deposit: %.2f\n", balance);
    }

    void withdraw(double amount){
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive");
        } else if (amount <= balance) {
            System.out.printf("Previous Balance : %.2f\n", balance);
            balance-=amount;
            System.out.printf("Balance after withdrawal: %.2f\n", balance);
        }else{
            System.out.println("Not Enough Balance");
        }
    }

    abstract void displayDetails();
    abstract double calculateInterest();
}

interface Loanable{
    void applyForLoan();
    void calculateLoanEligibility();
}

class SavingsAccount extends BankAccount{

    SavingsAccount(long accountNumber, String holderName, double balance){
        super(accountNumber, holderName, balance);
    }

    @Override
    void displayDetails(){
        System.out.println("Savings Account");
        System.out.println("Bank Account Number: "+ getAccountNumber());
        System.out.println("Bank Account Holder: "+ getHolderName());
        System.out.printf("Bank Account Balance: %.2f%n", getBalance());
    }

    @Override
    double calculateInterest() {
        return getBalance() * 0.04; // Example: 4% annual interest
    }

    @Override
    public void applyForLoan(){
        if (getBalance() >= 190000) {
            System.out.println("Loan application submitted");
        } else {
            System.out.println("Loan application rejected: not eligible");
        }
    }

    @Override
    public void calculateLoanEligibility(){
        if(getBalance() < 190000){
            System.out.println("Not Applicable for loan");
        }else{
            System.out.println("Loan can be applied");
        }
    }
}

class CurrentAccount extends BankAccount{

    CurrentAccount(long accountNumber, String holderName, double balance){
        super(accountNumber, holderName, balance);
    }

    @Override
    void displayDetails(){
        System.out.println("Current Account");
        System.out.println("Bank Account Number: "+ getAccountNumber());
        System.out.println("Bank Account Holder: "+ getHolderName());
        System.out.printf("Bank Account Balance: %.2f%n", getBalance());
    }

    @Override
    double calculateInterest() {
        return 0; // Example: current accounts earn no interest
    }

    @Override
    public void applyForLoan(){
        if (getBalance() >= 190000) {
            System.out.println("Loan application submitted");
        } else {
            System.out.println("Loan application rejected: not eligible");
        }
    }

    @Override
    public void calculateLoanEligibility(){
        if(getBalance() < 190000){
            System.out.println("Not Applicable for loan");
        }else{
            System.out.println("Loan can be applied");
        }
    }
}



public class BankingSystem {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount(1001, "Mihir", 200000);
        BankAccount current = new CurrentAccount(1002, "Rishika", 100000);

        savings.deposit(10000);
        current.withdraw(5000);
        System.out.println();

        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(savings);
        accounts.add(current);

        for (BankAccount account : accounts) {
            account.displayDetails();
            System.out.printf("Annual interest: %.2f%n", account.calculateInterest());
            account.calculateLoanEligibility();
            account.applyForLoan();
            System.out.println();
        }
    }
}
