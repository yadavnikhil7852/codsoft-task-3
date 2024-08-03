import java.util.Scanner;

public class ATMProgram {

    // Class to represent the user's bank account
    static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            if (initialBalance < 0) {
                System.out.println("Initial balance cannot be negative. Setting balance to 0.");
                this.balance = 0;
            } else {
                this.balance = initialBalance;
            }
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
            } else {
                System.out.println("Invalid withdrawal amount or insufficient funds.");
            }
        }
    }

    // Class to represent the ATM machine
    static class ATM {
        private BankAccount account;

        public ATM(BankAccount account) {
            this.account = account;
        }

        public void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Invalid amount. Please enter a positive number.");
            } else if (amount > account.getBalance()) {
                System.out.println("Insufficient balance.");
            } else {
                account.withdraw(amount);
                System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
            }
        }

        public void deposit(double amount) {
            if (amount <= 0) {
                System.out.println("Invalid amount. Please enter a positive number.");
            } else {
                account.deposit(amount);
                System.out.println("Deposit successful. New balance: $" + account.getBalance());
            }
        }

        public void checkBalance() {
            System.out.println("Current balance: $" + account.getBalance());
        }
    }

    // Main class to run the ATM interface
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a bank account with an initial balance of $1000
        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return; // Exit the loop and end the program
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
