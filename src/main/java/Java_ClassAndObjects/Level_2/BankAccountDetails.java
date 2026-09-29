/*
2. Program to Simulate an ATM
Problem Statement: Create a BankAccount class with attributes accountHolder, accountNumber, and balance.
Add methods for:
Depositing money.
Withdrawing money (only if sufficient balance exists).
Displaying the current balance.
Explanation: The BankAccount class stores bank account details as attributes.
The methods allow interaction with these attributes to modify and view the account's state.
 */

package Java_ClassAndObjects.Level_2;

import java.util.Scanner;


class BankAccount{
    String accountHolder;
    int accountNumber;
    int balance;

    BankAccount(String accountHolder, int accountNumber, int balance){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void Deposit(int amount){
        System.out.println("Depositing "+amount);
        System.out.println("Previous Balance: "+balance);
        balance+=amount;
        System.out.println("New Balance: "+balance);
    }


    public void Withdraw(int amount){
        if (balance < amount){
            System.out.println("Not Enough Balance");
            return;
        }
        System.out.println("Withdrawing "+amount);
        System.out.println("Previous Balance: "+balance);
        balance-=amount;
        System.out.println("New Balance: "+balance);
    }

}


public class BankAccountDetails {
    public static void main(String[] args) {

        BankAccount b1 = new BankAccount("Mihir", 2308, 45000);
        b1.Deposit(10500);
        b1.Withdraw(75000);
        b1.Withdraw(27000);
    }
}