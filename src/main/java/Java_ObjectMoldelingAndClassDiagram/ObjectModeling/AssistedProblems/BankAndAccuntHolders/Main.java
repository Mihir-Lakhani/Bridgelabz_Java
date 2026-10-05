package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.AssistedProblems.BankAndAccuntHolders;

public class Main {
    public static void main(String[] args) {
        Bank b1 = new Bank("SBI");
        Bank b2 = new Bank("HDFC");

        // Customers are created independently of the banks.
        Customer c1 = new Customer("Mihir");
        Customer c2 = new Customer("Shrey");

        // One customer can hold multiple accounts, even at the same bank.
        b1.openAccount(c1, "SBI101", 5000);
        b1.openAccount(c1, "SBI102", 2500);
        b2.openAccount(c1, "HDFC101", 10000);
        b1.openAccount(c2, "SBI103", 7500);

        c1.viewBalance();
        c2.viewBalance();

        b1.displayAccounts();
        System.out.println();
        b2.displayAccounts();
    }
}
