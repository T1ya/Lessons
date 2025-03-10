package homework.Task2;

public class ElectronicWallet implements PaymentSystem {
    private double balance;
    private final String currency;

    public ElectronicWallet(double initialBalance, String currency) {
        this.balance = initialBalance;
        this.currency = currency;
    }

    @Override
    public void withdrawMoney(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Withdraw: %.2f %s. New balance: %.2f %s\n", amount, currency, balance, currency);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public void depositTransfer(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposit: %.2f %s. New balance: %.2f %s\n", amount, currency, balance, currency);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public double checkBalance() {
        System.out.printf("Balance: %.2f %s\n", balance, currency);
        return balance;

    }
}
