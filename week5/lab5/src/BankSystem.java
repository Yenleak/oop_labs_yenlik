import java.util.Vector;

public class BankSystem {

    public static void main(String[] args) {

        Bank bank = new Bank();

        Account a1 = new SavingsAccount(101, 5); // 5% interest
        Account a2 = new CheckingAccount(201);

        a1.deposit(1000);
        a2.deposit(500);

        a2.withdraw(100);
        a2.deposit(50);
        a2.withdraw(20);

        bank.openAccount(a1);
        bank.openAccount(a2);

        bank.printAccounts();

        System.out.println("\nОбновление счетов...\n");

        bank.update();

        bank.printAccounts();
    }
}

//аккаунт

class Account {

    private double balance;
    private int accNumber;

    public Account(int a) {
        balance = 0.0;
        accNumber = a;
    }

    public void deposit(double sum) {
        balance += sum;
    }

    public void withdraw(double sum) {
        if (sum <= balance) {
            balance -= sum;
        } else {
            System.out.println("Недостаточно средств");
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accNumber;
    }

    public void transfer(double amount, Account other) {
        withdraw(amount);
        other.deposit(amount);
    }

    public String toString() {
        return "Account #" + accNumber + " | Balance: $" + balance;
    }

    public final void print() {
        System.out.println(toString());
    }
}

//сохр акк 

class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(int accNumber, double rate) {
        super(accNumber);
        interestRate = rate;
    }

    public void addInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
    }

    public String toString() {
        return "Savings " + super.toString() +
                " | Interest: " + interestRate + "%";
    }
}

//пров акк

class CheckingAccount extends Account {

    private int transactionCount;
    private static final int FREE_TRANSACTIONS = 3;

    public CheckingAccount(int accNumber) {
        super(accNumber);
        transactionCount = 0;
    }

    public void deposit(double sum) {
        super.deposit(sum);
        transactionCount++;
    }

    public void withdraw(double sum) {
        super.withdraw(sum);
        transactionCount++;
    }

    public void deductFee() {

        if (transactionCount > FREE_TRANSACTIONS) {

            int extra = transactionCount - FREE_TRANSACTIONS;
            double fee = extra * 0.02;

            super.withdraw(fee);
        }

        transactionCount = 0;
    }

    public String toString() {
        return "Checking " + super.toString() +
                " | Transactions: " + transactionCount;
    }
}

//банк

class Bank {

    private Vector<Account> accounts;

    public Bank() {
        accounts = new Vector<>();
    }

    public void openAccount(Account acc) {
        accounts.add(acc);
    }

    public void closeAccount(Account acc) {
        accounts.remove(acc);
    }

    public void update() {

        for (Account acc : accounts) {

            if (acc instanceof SavingsAccount) {
                ((SavingsAccount) acc).addInterest();
            }

            if (acc instanceof CheckingAccount) {
                ((CheckingAccount) acc).deductFee();
            }
        }
    }

    public void printAccounts() {

        System.out.println("Счета в банке:");

        for (Account acc : accounts) {
            acc.print();
        }
    }
}