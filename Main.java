import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public String withdraw(double amount) {
        if (amount > balance) {
            return "Insufficient balance.";
        } else {
            balance -= amount;
            return "Withdrawal of " + amount + " successful. New balance: " + balance;
        }
    }

    public String deposit(double amount) {
        if (amount <= 0) {
            return "Deposit amount must be positive.";
        } else {
            balance += amount;
            return "Deposit of " + amount + " successful. New balance: " + balance;
        }
    }

    public String checkBalance() {
        return "Your current balance is: " + balance;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayOptions() {
        System.out.println("Welcome to the ATM. Please choose an option:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void executeOption(int choice, Scanner scanner) {
        if (choice == 1) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            System.out.println(account.withdraw(amount));
        } else if (choice == 2) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            System.out.println(account.deposit(amount));
        } else if (choice == 3) {
            System.out.println(account.checkBalance());
        } else if (choice == 4) {
            System.out.println("Thank you for using the ATM. Goodbye!");
        } else {
            System.out.println("Invalid option. Please choose again.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a bank account with an initial balance
        BankAccount userAccount = new BankAccount(1000);

        // Create an ATM instance connected to the user's bank account
        ATM atm = new ATM(userAccount);

        // Simulate ATM operation
        while (true) {
            atm.displayOptions();
            System.out.print("Enter your choice: ");
            int userChoice = scanner.nextInt();
            if (userChoice == 4) {
                break;
            }
            atm.executeOption(userChoice, scanner);
        }

        scanner.close();
    }
}
