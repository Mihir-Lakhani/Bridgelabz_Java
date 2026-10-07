/*
1. Design a Banking System
Design a Banking System using OOP principles.
Requirements:
- +Create different account types: SavingsAccount, CurrentAccount, and FixedDepositAccount.
- Implement operations like deposit(), withdraw(), and calculateInterest().
- Each account type should have different withdrawal and interest rules.
- Create a common Account abstraction.
- Apply Encapsulation, Inheritance, Abstraction, and Polymorphism.
- Handle invalid operations using custom exceptions.
Expected concepts:
abstract class, inheritance, method overriding, encapsulation, polymorphism, custom exception.
 */

package Review2;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

interface Loanable{
    void takeLoan(int amount);
}


abstract class Account {

    private long accNo;
    private String holderName;
    private int balance;

    Account(long accNo, String holderName, int balance){
        this.accNo = accNo;
        this.holderName = holderName;
        this.balance = balance;
    }
//OR
    void displayClassDetails(){
        System.out.println("WE ARE IN ACCOUNT CLASS");
    }

    public int getBalance() {
        return balance;
    }

    public long getAccNo() {
        return accNo;
    }

    public String getHoldername() {
        return holderName;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    abstract void deposit(int amount);
    abstract double calculateInterest();

    void displayAll(){
        System.out.printf("Name: %s\n", holderName);
        System.out.printf("Account number: %d\n", accNo);
        System.out.printf("Balance: %d\n", balance);
    }
}

class SavingAccount extends Account implements Loanable{

    int score;

    SavingAccount(long accNo, String holderName, int balance, int score){
        super(accNo, holderName, balance);
        this.score = score;
    }

    @Override
    void displayClassDetails(){
        System.out.println("WE ARE IN SAVING ACCOUNT");
        displayAll();
    }

    @Override
    double calculateInterest() {
        return getBalance() * 0.04;
    }
    void withdraw(int amount){
        setBalance(getBalance() - amount);
    }
    void deposit(int amount){
        setBalance(getBalance() + amount);
        System.out.println("Deposited: "+ amount);

    }
    public void takeLoan(int amount){
        if (score>7 && getBalance()>amount){
            System.out.println("Loan Graanted");
        }else{
            System.out.println("Cannot apply for loan, less Score...");
        }
    }

}
class CurrentAccount extends Account{

    CurrentAccount(long accNo, String holderName, int balance){
        super(accNo, holderName, balance);
    }

    @Override
    void displayClassDetails(){
        System.out.println("WE ARE IN CURRENT ACCOUNT");
        displayAll();

    }
    @Override
    double calculateInterest() {
        return getBalance() * 0.01;
    }

    void withdraw(int amount){
        setBalance(getBalance() - amount);
    }
    void deposit(int amount){
        setBalance(getBalance() + amount);
        System.out.println("Deposited: "+ amount);

    }
}

class FixedDepositAccount extends Account implements Loanable{

    FixedDepositAccount(long accNo, String holderName, int balance){
        super(accNo, holderName, balance);
    }

    @Override
    void displayClassDetails(){
        System.out.println("WE ARE IN FIXED DEPOSIT ACCOUNT");
        displayAll();

    }
    @Override
    double calculateInterest() {
        return getBalance() * 0.07;
    }

    public void takeLoan(int amount){
        if (getBalance()>amount){
            System.out.println("Loan Graanted");
        }else{
            System.out.println("Cannot apply for loan, less Score...");
        }
    }

    void deposit(int amount){
        setBalance(getBalance() + amount);
        System.out.println("Deposited: "+ amount);
    }

}

public class BankingSystem {
    public static void main(String[] args) {


        SavingAccount SA = new SavingAccount(65768798, "Mihir Lakhani", 55000, 8);
        CurrentAccount CA = new CurrentAccount(76678987, "Harsh Sarode", 45000);
        FixedDepositAccount FA = new FixedDepositAccount(5676688, "Shrey Modi", 23000);

        SA.deposit(34000);
        CA.deposit(45000);
        FA.deposit(21000);

        SA.takeLoan(23000);
        FA.takeLoan(21000);

        Account[] accounts = {SA, CA, FA};

        for(Account account: accounts){
            account.displayAll();
            System.out.printf("Interest: %.2f", account.calculateInterest());

        }
    }
}