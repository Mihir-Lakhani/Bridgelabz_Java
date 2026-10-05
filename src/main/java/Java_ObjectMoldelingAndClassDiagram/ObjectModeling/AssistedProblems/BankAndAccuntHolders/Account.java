package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.AssistedProblems.BankAndAccuntHolders;

class Account {
    private String accountNumber;
    private double balance;
    private Bank bank;
    private Customer customer;

    Account(String accountNumber, double balance, Bank bank, Customer customer){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bank = bank;
        this.customer = customer;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Bank getBank() {
        return bank;
    }

    public Customer getCustomer() {
        return customer;
    }
}
