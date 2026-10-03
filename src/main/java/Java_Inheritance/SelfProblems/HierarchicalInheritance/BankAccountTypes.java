/*
Program 1: Bank Account Types (Hierarchical Inheritance)
SavingsAccount, CheckingAccount, and FixedDepositAccount share BankAccount details.
Each subclass displays its own account type and special attribute.
 */

package Java_Inheritance.SelfProblems.HierarchicalInheritance;

class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.printf("Balance: Rs.%.2f%n", balance);
    }

    void displayAccountType() {
        System.out.println("Account Type: Bank Account");
        displayDetails();
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        super.displayDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        super.displayDetails();
        System.out.printf("Withdrawal Limit: Rs.%.2f%n", withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    int depositDurationMonths;

    FixedDepositAccount(String accountNumber, double balance, int depositDurationMonths) {
        super(accountNumber, balance);
        this.depositDurationMonths = depositDurationMonths;
    }

    @Override
    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        super.displayDetails();
        System.out.println("Deposit Duration: " + depositDurationMonths + " months");
    }
}

public class BankAccountTypes {
    public static void main(String[] args) {
        BankAccount[] accounts = {
                new SavingsAccount("SA101", 25000, 4.5),
                new CheckingAccount("CA102", 15000, 5000),
                new FixedDepositAccount("FD103", 50000, 24)
        };

        for (BankAccount account : accounts) {
            account.displayAccountType();
            System.out.println();
        }
    }
}
