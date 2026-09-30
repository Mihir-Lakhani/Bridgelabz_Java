package Java_ConstructorsInstancesAndAccessModifiers.AccessModifiers;

import java.util.Scanner;

class BankAccount{
    final public long accountNumber;
    protected String accountHolder;
    private long balance;

    BankAccount(long accountNumber){
        this.accountNumber = accountNumber;
    }

    BankAccount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the account number: ");
        accountNumber = sc.nextLong();
    }


    public long getBalance(){
        return balance;
    }

    public void Withdraw(long amount){
        if(amount>balance){
            System.out.println("Not Enough Balance");
            return;
        }

        System.out.printf("Previous Balance: %d\n", balance);
        balance-=amount;
        System.out.printf("Current Balance: %d\n", balance);
    }

    public void Deposit(long amount){
        System.out.printf("Previous Balance: %d\n", balance);
        balance+=amount;
        System.out.printf("Current Balance: %d\n", balance);
    }
}

class SavingAccount extends BankAccount{

    SavingAccount(){
        super();
    }
    SavingAccount(long accountNumber){
        super(accountNumber);
    }

    public void setHolderName(String name){
        accountHolder = name;
    }
    public String getHolderName(){
        return accountHolder;
    }

    public void Display(){
        System.out.printf("BankAcc Number: %d\n", accountNumber);
        System.out.printf("Account Holder: %s\n", accountHolder);
        System.out.printf("Balance: %d\n", getBalance());
    }
}


public class BankAccountManagement {
    public static void main(String[] args) {

        SavingAccount sa1 = new SavingAccount();
        sa1.setHolderName("Mihir");
        System.out.printf("The holder name is now: %s\n", sa1.getHolderName());
        sa1.Deposit(120000);
        sa1.Withdraw(35000);
        sa1.Display();

        SavingAccount sa2 = new SavingAccount(867545);
        sa2.setHolderName("Shrey");
        System.out.printf("The holder name is now: %s\n", sa2.getHolderName());
        sa2.Deposit(210000);
        sa2.Withdraw(23000);
        sa2.Display();

    }
}