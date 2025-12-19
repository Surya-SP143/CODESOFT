import java.util.Scanner;

// Class representing the user's bank account
class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
}

// Class representing the ATM Machine
public class ATM {

    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("WELCOME TO THE ATM MACHINE ");

        boolean running = true;

        while (running) {
            showMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleWithdraw();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    handleCheckBalance();
                    break;
                case 4:
                    System.out.println(" Thank you for using the ATM. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println(" Invalid option! Please try again.");
            }
        }
        scanner.close();
    }

    private void showMenu() {
        System.out.println("\n----ATM MENU ----");
        System.out.println("1. Withdraw Money");
        System.out.println("2. Deposit Money");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.println("----------------->");
    }

    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();

        if (account.withdraw(amount)) {
            System.out.println(" Withdrawal successful!");
            System.out.println("Remaining Balance: ₹" + account.getBalance());
        } else {
            System.out.println(" Withdrawal failed! Insufficient balance or invalid amount.");
        }
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();

        if (account.deposit(amount)) {
            System.out.println(" Deposit successful!");
            System.out.println("Updated Balance: ₹" + account.getBalance());
        } else {
            System.out.println(" Invalid deposit amount!");
        }
    }

    private void handleCheckBalance() {
        System.out.println(" Current Balance: ₹" + account.getBalance());
    }

    // Main method
    public static void main(String[] args) {

        BankAccount userAccount = new BankAccount(5000); // Initial balance
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
