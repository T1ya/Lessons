package homework.Task2;

public class PaymentSystemApp {
    public static void main(String[] args) {
        PaymentSystem bankAccount = new BankAccount(1050, "EUR");
        PaymentSystem eWallet = new ElectronicWallet(550, "USD");

        bankAccount.checkBalance();
        bankAccount.depositTransfer(200);
        bankAccount.withdrawMoney(150);
        bankAccount.checkBalance();

        eWallet.checkBalance();
        eWallet.depositTransfer(100);
        eWallet.withdrawMoney(50);
        eWallet.checkBalance();

    }
}
