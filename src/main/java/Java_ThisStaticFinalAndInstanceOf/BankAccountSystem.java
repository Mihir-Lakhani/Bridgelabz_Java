/*
Sample Program 1: Bank Account System
Create a BankAccount class with the following features:
Static:
A static variable bankName shared across all accounts.
A static method getTotalAccounts() to display the total number of accounts.
This:
Use this to resolve ambiguity in the constructor when initializing accountHolderName and accountNumber.
Final:
Use a final variable accountNumber to ensure it cannot be changed once assigned.
Instanceof:
Check if an account object is an instance of the BankAccount class before displaying its details.
 */

package Java_ThisStaticFinalAndInstanceOf;

import java.util.Scanner;

class BankAccount{
    static String bankName;
    int totalAccount=0;
    final long accountNumber;


    Scanner sc = new Scanner(System.in);

    BankAccount(){
        System.out.println("Enter the Acc Number: ");
        accountNumber = sc.nextLong();
        totalAccount++;
    }
    BankAccount(long accountNumber){
        this.accountNumber = accountNumber;
        totalAccount++;
    }

    public static int getTotalAccounts(BankAccount obj){
        return obj.totalAccount;
    }

    public void Display(){
        System.out.printf("Bank Name: %s\n", bankName);
        System.out.printf("Acc Number: %s\n", accountNumber);
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount(456);
        BankAccount account3 = new BankAccount(476);
        BankAccount account4 = new BankAccount();
        BankAccount.bankName = "HDFC";

        account1.Display();
        account2.Display();
        account3.Display();
        account4.Display();

        if(account1 instanceof BankAccount) {
            System.out.println("Account 1 is the object of class BankAccount");
        }
        System.out.printf("Total Accounts: %d", BankAccount.getTotalAccounts(account1));

    }
}